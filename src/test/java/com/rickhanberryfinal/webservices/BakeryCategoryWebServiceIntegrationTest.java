package com.rickhanberryfinal.webservices;


import com.rickhanberryfinal.HanberryFinalProjectApplication;
import com.rickhanberryfinal.entities.BakeryCategory;
import com.rickhanberryfinal.repository.BakeryCategoryRepository;
import com.rickhanberryfinal.services.BakeryCategoryService;
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
 * Test class for the BakeryCategoryWebService REST controller.
 *
 * @see BakeryCategoryWebService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HanberryFinalProjectApplication.class)
@WebAppConfiguration
@IntegrationTest
public class BakeryCategoryWebServiceIntegrationTest {

    private static final String DEFAULT_BAKERY_CATEGORY = "AAAAA";
    private static final String UPDATED_BAKERY_CATEGORY = "BBBBB";

    @Inject
    private BakeryCategoryRepository bakeryCategoryRepository;

    @Inject
    private BakeryCategoryService bakeryCategoryService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restBakeryCategoryMockMvc;

    private BakeryCategory bakeryCategory;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        BakeryCategoryWebService bakeryCategoryWebService = new BakeryCategoryWebService();
        ReflectionTestUtils.setField(bakeryCategoryWebService, "bakeryCategoryService", bakeryCategoryService);
        this.restBakeryCategoryMockMvc = MockMvcBuilders.standaloneSetup(bakeryCategoryWebService)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        bakeryCategory = new BakeryCategory();
        bakeryCategory.setBakeryCategory(DEFAULT_BAKERY_CATEGORY);
    }

    @Test
    @Transactional
    public void createBakeryCategory() throws Exception {
        int databaseSizeBeforeCreate = bakeryCategoryRepository.findAll().size();

        // Create the BakeryCategory

        restBakeryCategoryMockMvc.perform(post("/api/bakeryCategorys")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(bakeryCategory)))
                .andExpect(status().isCreated());

        // Validate the BakeryCategory in the database
        List<BakeryCategory> bakeryCategorys = bakeryCategoryRepository.findAll();
        assertThat(bakeryCategorys).hasSize(databaseSizeBeforeCreate + 1);
        BakeryCategory testBakeryCategory = bakeryCategorys.get(bakeryCategorys.size() - 1);
        assertThat(testBakeryCategory.getBakeryCategory()).isEqualTo(DEFAULT_BAKERY_CATEGORY);
    }

    @Test
    @Transactional
    public void checkBakeryCategoryIsRequired() throws Exception {
        int databaseSizeBeforeTest = bakeryCategoryRepository.findAll().size();
        // set the field null
        bakeryCategory.setBakeryCategory(null);

        // Create the BakeryCategory, which fails.

        restBakeryCategoryMockMvc.perform(post("/api/bakeryCategorys")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(bakeryCategory)))
                .andExpect(status().isBadRequest());

        List<BakeryCategory> bakeryCategorys = bakeryCategoryRepository.findAll();
        assertThat(bakeryCategorys).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBakeryCategorys() throws Exception {
        // Initialize the database
        bakeryCategoryRepository.saveAndFlush(bakeryCategory);

        // Get all the bakeryCategorys
        restBakeryCategoryMockMvc.perform(get("/api/bakeryCategorys?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(bakeryCategory.getId().intValue())))
                .andExpect(jsonPath("$.[*].bakeryCategory").value(hasItem(DEFAULT_BAKERY_CATEGORY.toString())));
    }

    @Test
    @Transactional
    public void getBakeryCategory() throws Exception {
        // Initialize the database
        bakeryCategoryRepository.saveAndFlush(bakeryCategory);

        // Get the bakeryCategory
        restBakeryCategoryMockMvc.perform(get("/api/bakeryCategorys/{id}", bakeryCategory.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(bakeryCategory.getId().intValue()))
                .andExpect(jsonPath("$.bakeryCategory").value(DEFAULT_BAKERY_CATEGORY.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBakeryCategory() throws Exception {
        // Get the bakeryCategory
        restBakeryCategoryMockMvc.perform(get("/api/bakeryCategorys/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBakeryCategory() throws Exception {
        // Initialize the database
        bakeryCategoryRepository.saveAndFlush(bakeryCategory);

        int databaseSizeBeforeUpdate = bakeryCategoryRepository.findAll().size();

        // Update the bakeryCategory
        bakeryCategory.setBakeryCategory(UPDATED_BAKERY_CATEGORY);

        restBakeryCategoryMockMvc.perform(put("/api/bakeryCategorys")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(bakeryCategory)))
                .andExpect(status().isOk());

        // Validate the BakeryCategory in the database
        List<BakeryCategory> bakeryCategorys = bakeryCategoryRepository.findAll();
        assertThat(bakeryCategorys).hasSize(databaseSizeBeforeUpdate);
        BakeryCategory testBakeryCategory = bakeryCategorys.get(bakeryCategorys.size() - 1);
        assertThat(testBakeryCategory.getBakeryCategory()).isEqualTo(UPDATED_BAKERY_CATEGORY);
    }

    @Test
    @Transactional
    public void deleteBakeryCategory() throws Exception {
        // Initialize the database
        bakeryCategoryRepository.saveAndFlush(bakeryCategory);

        int databaseSizeBeforeDelete = bakeryCategoryRepository.findAll().size();

        // Get the bakeryCategory
        restBakeryCategoryMockMvc.perform(delete("/api/bakeryCategorys/{id}", bakeryCategory.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<BakeryCategory> bakeryCategorys = bakeryCategoryRepository.findAll();
        assertThat(bakeryCategorys).hasSize(databaseSizeBeforeDelete - 1);
    }
}

