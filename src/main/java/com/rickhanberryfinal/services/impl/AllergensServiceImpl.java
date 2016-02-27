package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.Allergens;
import com.rickhanberryfinal.repository.AllergensRepository;
import com.rickhanberryfinal.services.AllergensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * Created by rhanberry on 2/23/2016.
 * Service Implementation for managing Allergens.
 */

@Service
@Transactional
public class AllergensServiceImpl implements AllergensService{


    @Autowired
    private AllergensRepository allergensRepository;

    /**
     * Save a allergens.
     * @return the persisted entity
     */
    public Allergens save(Allergens allergens) {
        Allergens result = allergensRepository.save(allergens);
        return result;
    }

    /**
     *  get all the allergenss.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Allergens> findAll() {
        List<Allergens> result = allergensRepository.findAll();
        return result;
    }

    /**
     *  get one allergens by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Allergens findOne(Long id) {
        Allergens allergens = allergensRepository.findOne(id);
        return allergens;
    }

    /**
     *  delete the  allergens by id.
     */
    public void delete(Long id) {
        allergensRepository.delete(id);
    }
}

