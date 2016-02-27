package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.DrinkRecipe;
import com.rickhanberryfinal.repository.DrinkRecipeRepository;
import com.rickhanberryfinal.services.DrinkRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Implementation for managing Drinkrecipe.
 */
@Service
@Transactional
public class DrinkRecipeServiceImpl implements DrinkRecipeService {


    @Autowired
    private DrinkRecipeRepository drinkRecipeRepository;

    /**
     * Save a drinkRecipe.
     * @return the persisted entity
     */
    public DrinkRecipe save(DrinkRecipe drinkRecipe) {
        DrinkRecipe result = drinkRecipeRepository.save(drinkRecipe);
        return result;
    }

    /**
     *  get all the drinkRecipes.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<DrinkRecipe> findAll() {
        List<DrinkRecipe> result = drinkRecipeRepository.findAllWithEagerRelationships();
        return result;
    }

    /**
     *  get one drinkRecipe by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public DrinkRecipe findOne(Long id) {
        DrinkRecipe drinkRecipe = drinkRecipeRepository.findOneWithEagerRelationships(id);
        return drinkRecipe;
    }

    /**
     *  delete the  drinkRecipe by id.
     */
    public void delete(Long id) {
        drinkRecipeRepository.delete(id);
    }
}
