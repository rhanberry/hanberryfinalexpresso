package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.Ingredients;
import com.rickhanberryfinal.repository.IngredientsRepository;
import com.rickhanberryfinal.services.IngredientsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Implementation for managing Ingredients.
 */
@Service
@Transactional
public class IngredientsSvcImpl implements IngredientsService {


    @Autowired
    private IngredientsRepository ingredientsRepository;

    /**
     * Save a ingredients.
     * @return the persisted entity
     */
    public Ingredients save(Ingredients ingredients) {
        Ingredients result = ingredientsRepository.save(ingredients);
        return result;
    }

    /**
     *  get all the ingredientss.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Ingredients> findAll() {
        List<Ingredients> result = ingredientsRepository.findAll();
        return result;
    }

    /**
     *  get one ingredients by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Ingredients findOne(Long id) {
        Ingredients ingredients = ingredientsRepository.findOne(id);
        return ingredients;
    }

    /**
     *  delete the  ingredients by id.
     */
    public void delete(Long id) {
        ingredientsRepository.delete(id);
    }
}

