package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.Ingredients;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 *
 * Service Interface for managing Ingredients.
 */
public interface IngredientsService {

    /**
     * Save a ingredients.
     * @return the persisted entity
     */
    public Ingredients save(Ingredients ingredients);

    /**
     *  get all the ingredientss.
     *  @return the list of entities
     */
    public List<Ingredients> findAll();

    /**
     *  get the "id" ingredients.
     *  @return the entity
     */
    public Ingredients findOne(Long id);

    /**
     *  delete the "id" ingredients.
     */
    public void delete(Long id);
}

