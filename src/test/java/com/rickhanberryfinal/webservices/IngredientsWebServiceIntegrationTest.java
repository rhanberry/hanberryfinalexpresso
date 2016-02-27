package com.rickhanberryfinal.webservices;

/**
 *
 */

import com.rickhanberryfinal.HanberryFinalProjectApplication;
import com.rickhanberryfinal.entities.Ingredients;
import com.rickhanberryfinal.repository.IngredientsRepository;
import com.rickhanberryfinal.services.IngredientsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by rhanberry on 2/27/16.
 *
 * Test class for the IngredientsWebService REST controller.
 *
 * @see IngredientsWebService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HanberryFinalProjectApplication.class)
@WebAppConfiguration
@IntegrationTest
public class IngredientsWebServiceIntegrationTest {

    private static final String DEFAULT_INGREDIENT = "AAAAA";
    private static final String UPDATED_INGREDIENT = "BBBBB";

    private static final Double DEFAULT_INGREDIENT_COST = 1D;
    private static final Double UPDATED_INGREDIENT_COST = 2D;

    @Inject
    private IngredientsRepository ingredientsRepository;

    @Inject
    private IngredientsService ingredientsService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restIngredientsMockMvc;

    private Ingredients ingredients;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        IngredientsWebService ingredientsWebService = new IngredientsWebService();
        ReflectionTestUtils.setField(ingredientsWebService, "ingredientsService", ingredientsService);
        this.restIngredientsMockMvc = MockMvcBuilders.standaloneSetup(ingredientsWebService)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        ingredients = new Ingredients();
        ingredients.setIngredient(DEFAULT_INGREDIENT);
        ingredients.setIngredientCost(DEFAULT_INGREDIENT_COST);
    }

    @Test
    @Transactional
    public void createIngredients() throws Exception {
        int databaseSizeBeforeCreate = ingredientsRepository.findAll().size();

        // Create the Ingredients

        restIngredientsMockMvc.perform(post("/api/ingredientss")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(ingredients)))
                .andExpect(status().isCreated());

        // Validate the Ingredients in the database
        List<Ingredients> ingredientss = ingredientsRepository.findAll();
        assertThat(ingredientss).hasSize(databaseSizeBeforeCreate + 1);
        Ingredients testIngredients = ingredientss.get(ingredientss.size() - 1);
        assertThat(testIngredients.getIngredient()).isEqualTo(DEFAULT_INGREDIENT);
        assertThat(testIngredients.getIngredientCost()).isEqualTo(DEFAULT_INGREDIENT_COST);
    }

    @Test
    @Transactional
    public void checkIngredientIsRequired() throws Exception {
        int databaseSizeBeforeTest = ingredientsRepository.findAll().size();
        // set the field null
        ingredients.setIngredient(null);

        // Create the Ingredients, which fails.

        restIngredientsMockMvc.perform(post("/api/ingredientss")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(ingredients)))
                .andExpect(status().isBadRequest());

        List<Ingredients> ingredientss = ingredientsRepository.findAll();
        assertThat(ingredientss).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIngredientCostIsRequired() throws Exception {
        int databaseSizeBeforeTest = ingredientsRepository.findAll().size();
        // set the field null
        ingredients.setIngredientCost(null);

        // Create the Ingredients, which fails.

        restIngredientsMockMvc.perform(post("/api/ingredientss")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(ingredients)))
                .andExpect(status().isBadRequest());

        List<Ingredients> ingredientss = ingredientsRepository.findAll();
        assertThat(ingredientss).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllIngredientss() throws Exception {
        // Initialize the database
        ingredientsRepository.saveAndFlush(ingredients);

        // Get all the ingredientss
        restIngredientsMockMvc.perform(get("/api/ingredientss?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(ingredients.getId().intValue())))
                .andExpect(jsonPath("$.[*].ingredient").value(hasItem(DEFAULT_INGREDIENT.toString())))
                .andExpect(jsonPath("$.[*].ingredientCost").value(hasItem(DEFAULT_INGREDIENT_COST.doubleValue())));
    }

    @Test
    @Transactional
    public void getIngredients() throws Exception {
        // Initialize the database
        ingredientsRepository.saveAndFlush(ingredients);

        // Get the ingredients
        restIngredientsMockMvc.perform(get("/api/ingredientss/{id}", ingredients.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(ingredients.getId().intValue()))
                .andExpect(jsonPath("$.ingredient").value(DEFAULT_INGREDIENT.toString()))
                .andExpect(jsonPath("$.ingredientCost").value(DEFAULT_INGREDIENT_COST.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingIngredients() throws Exception {
        // Get the ingredients
        restIngredientsMockMvc.perform(get("/api/ingredientss/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateIngredients() throws Exception {
        // Initialize the database
        ingredientsRepository.saveAndFlush(ingredients);

        int databaseSizeBeforeUpdate = ingredientsRepository.findAll().size();

        // Update the ingredients
        ingredients.setIngredient(UPDATED_INGREDIENT);
        ingredients.setIngredientCost(UPDATED_INGREDIENT_COST);

        restIngredientsMockMvc.perform(put("/api/ingredientss")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(ingredients)))
                .andExpect(status().isOk());

        // Validate the Ingredients in the database
        List<Ingredients> ingredientss = ingredientsRepository.findAll();
        assertThat(ingredientss).hasSize(databaseSizeBeforeUpdate);
        Ingredients testIngredients = ingredientss.get(ingredientss.size() - 1);
        assertThat(testIngredients.getIngredient()).isEqualTo(UPDATED_INGREDIENT);
        assertThat(testIngredients.getIngredientCost()).isEqualTo(UPDATED_INGREDIENT_COST);
    }

    @Test
    @Transactional
    public void deleteIngredients() throws Exception {
        // Initialize the database
        ingredientsRepository.saveAndFlush(ingredients);

        int databaseSizeBeforeDelete = ingredientsRepository.findAll().size();

        // Get the ingredients
        restIngredientsMockMvc.perform(delete("/api/ingredientss/{id}", ingredients.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Ingredients> ingredientss = ingredientsRepository.findAll();
        assertThat(ingredientss).hasSize(databaseSizeBeforeDelete - 1);
    }
}