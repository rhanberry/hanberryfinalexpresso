package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.HanberryFinalProjectApplication;
import com.rickhanberryfinal.entities.UnitOfMeasure;
import com.rickhanberryfinal.repository.UnitOfMeasureRepository;
import com.rickhanberryfinal.services.UnitOfMeasureService;
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
 * Test class for the UnitOfMeasureWebService REST controller.
 *
 * @see UnitOfMeasureWebService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HanberryFinalProjectApplication.class)
@WebAppConfiguration
@IntegrationTest
public class UnitOfMeasureWebServiceIntegrationTest {

    private static final String DEFAULT_UNIT_OF_MEASURE = "AAAAA";
    private static final String UPDATED_UNIT_OF_MEASURE = "BBBBB";

    @Inject
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Inject
    private UnitOfMeasureService unitOfMeasureService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restUnitOfMeasureMockMvc;

    private UnitOfMeasure unitOfMeasure;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        UnitOfMeasureWebService unitOfMeasureWebService = new UnitOfMeasureWebService();
        ReflectionTestUtils.setField(unitOfMeasureWebService, "unitOfMeasureService", unitOfMeasureService);
        this.restUnitOfMeasureMockMvc = MockMvcBuilders.standaloneSetup(unitOfMeasureWebService)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setUnitOfMeasure(DEFAULT_UNIT_OF_MEASURE);
    }

    @Test
    @Transactional
    public void createUnitOfMeasure() throws Exception {
        int databaseSizeBeforeCreate = unitOfMeasureRepository.findAll().size();

        // Create the UnitOfMeasure

        restUnitOfMeasureMockMvc.perform(post("/api/unitOfMeasures")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(unitOfMeasure)))
                .andExpect(status().isCreated());

        // Validate the UnitOfMeasure in the database
        List<UnitOfMeasure> unitOfMeasures = unitOfMeasureRepository.findAll();
        assertThat(unitOfMeasures).hasSize(databaseSizeBeforeCreate + 1);
        UnitOfMeasure testUnitOfMeasure = unitOfMeasures.get(unitOfMeasures.size() - 1);
        assertThat(testUnitOfMeasure.getUnitOfMeasure()).isEqualTo(DEFAULT_UNIT_OF_MEASURE);
    }

    @Test
    @Transactional
    public void checkUnitOfMeasureIsRequired() throws Exception {
        int databaseSizeBeforeTest = unitOfMeasureRepository.findAll().size();
        // set the field null
        unitOfMeasure.setUnitOfMeasure(null);

        // Create the UnitOfMeasure, which fails.

        restUnitOfMeasureMockMvc.perform(post("/api/unitOfMeasures")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(unitOfMeasure)))
                .andExpect(status().isBadRequest());

        List<UnitOfMeasure> unitOfMeasures = unitOfMeasureRepository.findAll();
        assertThat(unitOfMeasures).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllUnitOfMeasures() throws Exception {
        // Initialize the database
        unitOfMeasureRepository.saveAndFlush(unitOfMeasure);

        // Get all the unitOfMeasures
        restUnitOfMeasureMockMvc.perform(get("/api/unitOfMeasures?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(unitOfMeasure.getId().intValue())))
                .andExpect(jsonPath("$.[*].unitOfMeasure").value(hasItem(DEFAULT_UNIT_OF_MEASURE.toString())));
    }

    @Test
    @Transactional
    public void getUnitOfMeasure() throws Exception {
        // Initialize the database
        unitOfMeasureRepository.saveAndFlush(unitOfMeasure);

        // Get the unitOfMeasure
        restUnitOfMeasureMockMvc.perform(get("/api/unitOfMeasures/{id}", unitOfMeasure.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(unitOfMeasure.getId().intValue()))
                .andExpect(jsonPath("$.unitOfMeasure").value(DEFAULT_UNIT_OF_MEASURE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingUnitOfMeasure() throws Exception {
        // Get the unitOfMeasure
        restUnitOfMeasureMockMvc.perform(get("/api/unitOfMeasures/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUnitOfMeasure() throws Exception {
        // Initialize the database
        unitOfMeasureRepository.saveAndFlush(unitOfMeasure);

        int databaseSizeBeforeUpdate = unitOfMeasureRepository.findAll().size();

        // Update the unitOfMeasure
        unitOfMeasure.setUnitOfMeasure(UPDATED_UNIT_OF_MEASURE);

        restUnitOfMeasureMockMvc.perform(put("/api/unitOfMeasures")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(unitOfMeasure)))
                .andExpect(status().isOk());

        // Validate the UnitOfMeasure in the database
        List<UnitOfMeasure> unitOfMeasures = unitOfMeasureRepository.findAll();
        assertThat(unitOfMeasures).hasSize(databaseSizeBeforeUpdate);
        UnitOfMeasure testUnitOfMeasure = unitOfMeasures.get(unitOfMeasures.size() - 1);
        assertThat(testUnitOfMeasure.getUnitOfMeasure()).isEqualTo(UPDATED_UNIT_OF_MEASURE);
    }

    @Test
    @Transactional
    public void deleteUnitOfMeasure() throws Exception {
        // Initialize the database
        unitOfMeasureRepository.saveAndFlush(unitOfMeasure);

        int databaseSizeBeforeDelete = unitOfMeasureRepository.findAll().size();

        // Get the unitOfMeasure
        restUnitOfMeasureMockMvc.perform(delete("/api/unitOfMeasures/{id}", unitOfMeasure.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<UnitOfMeasure> unitOfMeasures = unitOfMeasureRepository.findAll();
        assertThat(unitOfMeasures).hasSize(databaseSizeBeforeDelete - 1);
    }
}

