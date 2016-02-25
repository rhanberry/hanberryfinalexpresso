package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.Allergen;
import com.rickhanberryfinal.repository.AllergenRepository;
import com.rickhanberryfinal.services.AllergenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * Created by rhanberry on 2/23/2016.
 * Service Implementation for managing Allergen.
 */

@Service
@Transactional
public class AllergenSvcImpl implements AllergenService{


    @Autowired
    private AllergenRepository allergenRepository;

    /**
     * Save a allergen.
     * @return the persisted entity
     */
    public Allergen save(Allergen allergen) {
        Allergen result = allergenRepository.save(allergen);
        return result;
    }

    /**
     *  get all the allergens.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Allergen> findAll() {
        List<Allergen> result = allergenRepository.findAll();
        return result;
    }

    /**
     *  get one allergen by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Allergen findOne(Long id) {
        Allergen allergen = allergenRepository.findOne(id);
        return allergen;
    }

    /**
     *  delete the  allergen by id.
     */
    public void delete(Long id) {
        allergenRepository.delete(id);
    }
}
