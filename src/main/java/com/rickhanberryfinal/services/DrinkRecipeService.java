package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.Drinkrecipe;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Interface for managing Drinkrecipe.
 */
public interface DrinkrecipeService {

    /**
     * Save a drinkrecipe.
     * @return the persisted entity
     */
    public Drinkrecipe save(Drinkrecipe drinkrecipe);

    /**
     *  get all the drinkrecipes.
     *  @return the list of entities
     */
    public List<Drinkrecipe> findAll();

    /**
     *  get the "id" drinkrecipe.
     *  @return the entity
     */
    public Drinkrecipe findOne(Long id);

    /**
     *  delete the "id" drinkrecipe.
     */
    public void delete(Long id);
}
