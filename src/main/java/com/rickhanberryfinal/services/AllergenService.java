package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.Allergen;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 *
 * Service Interface for managing Allergen.
 */

public interface AllergenService {

    /**
     * Save an allergen.
     * @return the persisted entity
     */
    public Allergen save(Allergen allergen);

    /**
     *  Get all the allergens.
     *  @return the list of entities
     */
    public List<Allergen> findAll();

    /**
     *  Get allergen by id.
     *  @return the entity
     */
    public Allergen findOne(Long id);

    /**
     *  Delete allergen by id.
     */
    public void delete(Long id);

}
