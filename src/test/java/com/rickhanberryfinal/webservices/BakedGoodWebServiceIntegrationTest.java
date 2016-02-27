package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.HanberryFinalProjectApplication;
import com.rickhanberryfinal.entities.BakedGood;
import com.rickhanberryfinal.repository.BakedGoodRepository;
import com.rickhanberryfinal.services.BakedGoodService;
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
 * Test class for the BakedGoodWebService REST controller.
 *
 * @see BakedGoodWebService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HanberryFinalProjectApplication.class)
@WebAppConfiguration
@IntegrationTest
public class BakedGoodWebServiceIntegrationTest {

    private static final String DEFAULT_BAKED_GOOD = "AAAAA";
    private static final String UPDATED_BAKED_GOOD = "BBBBB";

    private static final Double DEFAULT_BAKED_GOOD_COST = 1D;
    private static final Double UPDATED_BAKED_GOOD_COST = 2D;

    @Inject
    private BakedGoodRepository bakedGoodRepository;

    @Inject
    private BakedGoodService bakedGoodService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restBakedGoodMockMvc;

    private BakedGood bakedGood;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        BakedGoodWebService bakedGoodWebService = new BakedGoodWebService();
        ReflectionTestUtils.setField(bakedGoodWebService, "bakedGoodService", bakedGoodService);
        this.restBakedGoodMockMvc = MockMvcBuilders.standaloneSetup(bakedGoodWebService)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        bakedGood = new BakedGood();
        bakedGood.setBakedGood(DEFAULT_BAKED_GOOD);
        bakedGood.setBakedGoodCost(DEFAULT_BAKED_GOOD_COST);
    }

    @Test
    @Transactional
    public void createBakedGood() throws Exception {
        int databaseSizeBeforeCreate = bakedGoodRepository.findAll().size();

        // Create the BakedGood

        restBakedGoodMockMvc.perform(post("/api/bakedGoods")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(bakedGood)))
                .andExpect(status().isCreated());

        // Validate the BakedGood in the database
        List<BakedGood> bakedGoods = bakedGoodRepository.findAll();
        assertThat(bakedGoods).hasSize(databaseSizeBeforeCreate + 1);
        BakedGood testBakedGood = bakedGoods.get(bakedGoods.size() - 1);
        assertThat(testBakedGood.getBakedGood()).isEqualTo(DEFAULT_BAKED_GOOD);
        assertThat(testBakedGood.getBakedGoodCost()).isEqualTo(DEFAULT_BAKED_GOOD_COST);
    }

    @Test
    @Transactional
    public void checkBakedGoodIsRequired() throws Exception {
        int databaseSizeBeforeTest = bakedGoodRepository.findAll().size();
        // set the field null
        bakedGood.setBakedGood(null);

        // Create the BakedGood, which fails.

        restBakedGoodMockMvc.perform(post("/api/bakedGoods")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(bakedGood)))
                .andExpect(status().isBadRequest());

        List<BakedGood> bakedGoods = bakedGoodRepository.findAll();
        assertThat(bakedGoods).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkBakedGoodCostIsRequired() throws Exception {
        int databaseSizeBeforeTest = bakedGoodRepository.findAll().size();
        // set the field null
        bakedGood.setBakedGoodCost(null);

        // Create the BakedGood, which fails.

        restBakedGoodMockMvc.perform(post("/api/bakedGoods")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(bakedGood)))
                .andExpect(status().isBadRequest());

        List<BakedGood> bakedGoods = bakedGoodRepository.findAll();
        assertThat(bakedGoods).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBakedGoods() throws Exception {
        // Initialize the database
        bakedGoodRepository.saveAndFlush(bakedGood);

        // Get all the bakedGoods
        restBakedGoodMockMvc.perform(get("/api/bakedGoods?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(bakedGood.getId().intValue())))
                .andExpect(jsonPath("$.[*].bakedGood").value(hasItem(DEFAULT_BAKED_GOOD.toString())))
                .andExpect(jsonPath("$.[*].bakedGoodCost").value(hasItem(DEFAULT_BAKED_GOOD_COST.doubleValue())));
    }

    @Test
    @Transactional
    public void getBakedGood() throws Exception {
        // Initialize the database
        bakedGoodRepository.saveAndFlush(bakedGood);

        // Get the bakedGood
        restBakedGoodMockMvc.perform(get("/api/bakedGoods/{id}", bakedGood.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(bakedGood.getId().intValue()))
                .andExpect(jsonPath("$.bakedGood").value(DEFAULT_BAKED_GOOD.toString()))
                .andExpect(jsonPath("$.bakedGoodCost").value(DEFAULT_BAKED_GOOD_COST.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingBakedGood() throws Exception {
        // Get the bakedGood
        restBakedGoodMockMvc.perform(get("/api/bakedGoods/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBakedGood() throws Exception {
        // Initialize the database
        bakedGoodRepository.saveAndFlush(bakedGood);

        int databaseSizeBeforeUpdate = bakedGoodRepository.findAll().size();

        // Update the bakedGood
        bakedGood.setBakedGood(UPDATED_BAKED_GOOD);
        bakedGood.setBakedGoodCost(UPDATED_BAKED_GOOD_COST);

        restBakedGoodMockMvc.perform(put("/api/bakedGoods")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(bakedGood)))
                .andExpect(status().isOk());

        // Validate the BakedGood in the database
        List<BakedGood> bakedGoods = bakedGoodRepository.findAll();
        assertThat(bakedGoods).hasSize(databaseSizeBeforeUpdate);
        BakedGood testBakedGood = bakedGoods.get(bakedGoods.size() - 1);
        assertThat(testBakedGood.getBakedGood()).isEqualTo(UPDATED_BAKED_GOOD);
        assertThat(testBakedGood.getBakedGoodCost()).isEqualTo(UPDATED_BAKED_GOOD_COST);
    }

    @Test
    @Transactional
    public void deleteBakedGood() throws Exception {
        // Initialize the database
        bakedGoodRepository.saveAndFlush(bakedGood);

        int databaseSizeBeforeDelete = bakedGoodRepository.findAll().size();

        // Get the bakedGood
        restBakedGoodMockMvc.perform(delete("/api/bakedGoods/{id}", bakedGood.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<BakedGood> bakedGoods = bakedGoodRepository.findAll();
        assertThat(bakedGoods).hasSize(databaseSizeBeforeDelete - 1);
    }
}

