package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.HanberryFinalProjectApplication;
import com.rickhanberryfinal.entities.Allergens;
import com.rickhanberryfinal.repository.AllergensRepository;
import com.rickhanberryfinal.services.AllergensService;
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
 * Test class for the AllergensWebService REST controller.
 *
 * @see AllergensWebService
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HanberryFinalProjectApplication.class)
@WebAppConfiguration
@IntegrationTest
public class AllergensWebServiceIntegrationTest {

    private static final String DEFAULT_ALLERGEN = "AAAAA";
    private static final String UPDATED_ALLERGEN = "BBBBB";

    @Inject
    private AllergensRepository allergensRepository;

    @Inject
    private AllergensService allergensService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restAllergensMockMvc;

    private Allergens allergens;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        AllergensWebService allergensWebService = new AllergensWebService();
        ReflectionTestUtils.setField(allergensWebService, "allergensService", allergensService);
        this.restAllergensMockMvc = MockMvcBuilders.standaloneSetup(allergensWebService)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        allergens = new Allergens();
        allergens.setAllergen(DEFAULT_ALLERGEN);
    }

    @Test
    @Transactional
    public void createAllergens() throws Exception {
        int databaseSizeBeforeCreate = allergensRepository.findAll().size();

        // Create the Allergens

        restAllergensMockMvc.perform(post("/api/allergenss")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(allergens)))
                .andExpect(status().isCreated());

        // Validate the Allergens in the database
        List<Allergens> allergenss = allergensRepository.findAll();
        assertThat(allergenss).hasSize(databaseSizeBeforeCreate + 1);
        Allergens testAllergens = allergenss.get(allergenss.size() - 1);
        assertThat(testAllergens.getAllergen()).isEqualTo(DEFAULT_ALLERGEN);
    }

    @Test
    @Transactional
    public void checkAllergenIsRequired() throws Exception {
        int databaseSizeBeforeTest = allergensRepository.findAll().size();
        // set the field null
        allergens.setAllergen(null);

        // Create the Allergens, which fails.

        restAllergensMockMvc.perform(post("/api/allergenss")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(allergens)))
                .andExpect(status().isBadRequest());

        List<Allergens> allergenss = allergensRepository.findAll();
        assertThat(allergenss).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAllergenss() throws Exception {
        // Initialize the database
        allergensRepository.saveAndFlush(allergens);

        // Get all the allergenss
        restAllergensMockMvc.perform(get("/api/allergenss?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(allergens.getId().intValue())))
                .andExpect(jsonPath("$.[*].allergen").value(hasItem(DEFAULT_ALLERGEN.toString())));
    }

    @Test
    @Transactional
    public void getAllergens() throws Exception {
        // Initialize the database
        allergensRepository.saveAndFlush(allergens);

        // Get the allergens
        restAllergensMockMvc.perform(get("/api/allergenss/{id}", allergens.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(allergens.getId().intValue()))
                .andExpect(jsonPath("$.allergen").value(DEFAULT_ALLERGEN.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingAllergens() throws Exception {
        // Get the allergens
        restAllergensMockMvc.perform(get("/api/allergenss/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAllergens() throws Exception {
        // Initialize the database
        allergensRepository.saveAndFlush(allergens);

        int databaseSizeBeforeUpdate = allergensRepository.findAll().size();

        // Update the allergens
        allergens.setAllergen(UPDATED_ALLERGEN);

        restAllergensMockMvc.perform(put("/api/allergenss")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(allergens)))
                .andExpect(status().isOk());

        // Validate the Allergens in the database
        List<Allergens> allergenss = allergensRepository.findAll();
        assertThat(allergenss).hasSize(databaseSizeBeforeUpdate);
        Allergens testAllergens = allergenss.get(allergenss.size() - 1);
        assertThat(testAllergens.getAllergen()).isEqualTo(UPDATED_ALLERGEN);
    }

    @Test
    @Transactional
    public void deleteAllergens() throws Exception {
        // Initialize the database
        allergensRepository.saveAndFlush(allergens);

        int databaseSizeBeforeDelete = allergensRepository.findAll().size();

        // Get the allergens
        restAllergensMockMvc.perform(delete("/api/allergenss/{id}", allergens.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Allergens> allergenss = allergensRepository.findAll();
        assertThat(allergenss).hasSize(databaseSizeBeforeDelete - 1);
    }
}
