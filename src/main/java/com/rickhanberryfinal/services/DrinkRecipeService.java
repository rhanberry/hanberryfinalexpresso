package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.DrinkRecipe;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Interface for managing Drinkrecipe.
 */
public interface DrinkRecipeService {

    /**
     * Save a drinkRecipe.
     * @return the persisted entity
     */
    public DrinkRecipe save(DrinkRecipe drinkRecipe);

    /**
     *  get all the drinkRecipes.
     *  @return the list of entities
     */
    public List<DrinkRecipe> findAll();

    /**
     *  get the "id" drinkRecipe.
     *  @return the entity
     */
    public DrinkRecipe findOne(Long id);

    /**
     *  delete the "id" drinkRecipe.
     */
    public void delete(Long id);
}