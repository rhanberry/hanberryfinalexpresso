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
     * Save a allergens.
     * @return the persisted entity
     */
    public Allergens save(Allergens allergens);

    /**
     *  get all the allergenss.
     *  @return the list of entities
     */
    public List<Allergens> findAll();

    /**
     *  get the "id" allergens.
     *  @return the entity
     */
    public Allergens findOne(Long id);

    /**
     *  delete the "id" allergens.
     */
    public void delete(Long id);
}

