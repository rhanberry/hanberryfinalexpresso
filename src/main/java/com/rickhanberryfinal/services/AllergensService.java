package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.Allergens;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 *
 * Service Interface for managing Allergens.
 */

public interface AllergensService {

    /**
     * Save allergen.
     * @return the persisted entity
     */
    public Allergens save(Allergens allergens);

    /**
     *  get all the allergens.
     *  @return the list of entities
     */
    public List<Allergens> findAll();

    /**
     *  get allergen by id.
     *  @return the entity
     */
    public Allergens findOne(Long id);

    /**
     *  delete allergen by id.
     */
    public void delete(Long id);
}

