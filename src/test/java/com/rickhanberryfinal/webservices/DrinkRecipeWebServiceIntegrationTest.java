package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.HanberryFinalProjectApplication;
import com.rickhanberryfinal.entities.DrinkRecipe;
import com.rickhanberryfinal.repository.DrinkRecipeRepository;
import com.rickhanberryfinal.services.DrinkRecipeService;
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
 * Test class for the DrinkRecipeWebService REST controller.
 *
 * @see DrinkRecipeWebService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HanberryFinalProjectApplication.class)
@WebAppConfiguration
@IntegrationTest
public class DrinkRecipeWebServiceIntegrationTest  {

    private static final String DEFAULT_DRINK_RECIPE = "AAAAA";
    private static final String UPDATED_DRINK_RECIPE = "BBBBB";

    @Inject
    private DrinkRecipeRepository drinkRecipeRepository;

    @Inject
    private DrinkRecipeService drinkRecipeService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restDrinkRecipeMockMvc;

    private DrinkRecipe drinkRecipe;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        DrinkRecipeWebService drinkRecipeWebService = new DrinkRecipeWebService();
        ReflectionTestUtils.setField(drinkRecipeWebService, "drinkRecipeService", drinkRecipeService);
        this.restDrinkRecipeMockMvc = MockMvcBuilders.standaloneSetup(drinkRecipeWebService)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        drinkRecipe = new DrinkRecipe();
        drinkRecipe.setDrinkRecipe(DEFAULT_DRINK_RECIPE);
    }

    @Test
    @Transactional
    public void createDrinkRecipe() throws Exception {
        int databaseSizeBeforeCreate = drinkRecipeRepository.findAll().size();

        // Create the DrinkRecipe

        restDrinkRecipeMockMvc.perform(post("/api/drinkRecipes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(drinkRecipe)))
                .andExpect(status().isCreated());

        // Validate the DrinkRecipe in the database
        List<DrinkRecipe> drinkRecipes = drinkRecipeRepository.findAll();
        assertThat(drinkRecipes).hasSize(databaseSizeBeforeCreate + 1);
        DrinkRecipe testDrinkRecipe = drinkRecipes.get(drinkRecipes.size() - 1);
        assertThat(testDrinkRecipe.getDrinkRecipe()).isEqualTo(DEFAULT_DRINK_RECIPE);
    }

    @Test
    @Transactional
    public void checkDrinkRecipeIsRequired() throws Exception {
        int databaseSizeBeforeTest = drinkRecipeRepository.findAll().size();
        // set the field null
        drinkRecipe.setDrinkRecipe(null);

        // Create the DrinkRecipe, which fails.

        restDrinkRecipeMockMvc.perform(post("/api/drinkRecipes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(drinkRecipe)))
                .andExpect(status().isBadRequest());

        List<DrinkRecipe> drinkRecipes = drinkRecipeRepository.findAll();
        assertThat(drinkRecipes).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllDrinkRecipes() throws Exception {
        // Initialize the database
        drinkRecipeRepository.saveAndFlush(drinkRecipe);

        // Get all the drinkRecipes
        restDrinkRecipeMockMvc.perform(get("/api/drinkRecipes?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(drinkRecipe.getId().intValue())))
                .andExpect(jsonPath("$.[*].drinkRecipe").value(hasItem(DEFAULT_DRINK_RECIPE.toString())));
    }

    @Test
    @Transactional
    public void getDrinkRecipe() throws Exception {
        // Initialize the database
        drinkRecipeRepository.saveAndFlush(drinkRecipe);

        // Get the drinkRecipe
        restDrinkRecipeMockMvc.perform(get("/api/drinkRecipes/{id}", drinkRecipe.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(drinkRecipe.getId().intValue()))
                .andExpect(jsonPath("$.drinkRecipe").value(DEFAULT_DRINK_RECIPE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingDrinkRecipe() throws Exception {
        // Get the drinkRecipe
        restDrinkRecipeMockMvc.perform(get("/api/drinkRecipes/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDrinkRecipe() throws Exception {
        // Initialize the database
        drinkRecipeRepository.saveAndFlush(drinkRecipe);

        int databaseSizeBeforeUpdate = drinkRecipeRepository.findAll().size();

        // Update the drinkRecipe
        drinkRecipe.setDrinkRecipe(UPDATED_DRINK_RECIPE);

        restDrinkRecipeMockMvc.perform(put("/api/drinkRecipes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(drinkRecipe)))
                .andExpect(status().isOk());

        // Validate the DrinkRecipe in the database
        List<DrinkRecipe> drinkRecipes = drinkRecipeRepository.findAll();
        assertThat(drinkRecipes).hasSize(databaseSizeBeforeUpdate);
        DrinkRecipe testDrinkRecipe = drinkRecipes.get(drinkRecipes.size() - 1);
        assertThat(testDrinkRecipe.getDrinkRecipe()).isEqualTo(UPDATED_DRINK_RECIPE);
    }

    @Test
    @Transactional
    public void deleteDrinkRecipe() throws Exception {
        // Initialize the database
        drinkRecipeRepository.saveAndFlush(drinkRecipe);

        int databaseSizeBeforeDelete = drinkRecipeRepository.findAll().size();

        // Get the drinkRecipe
        restDrinkRecipeMockMvc.perform(delete("/api/drinkRecipes/{id}", drinkRecipe.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<DrinkRecipe> drinkRecipes = drinkRecipeRepository.findAll();
        assertThat(drinkRecipes).hasSize(databaseSizeBeforeDelete - 1);
    }
}