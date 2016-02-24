package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.Drinkrecipe;
import com.rickhanberryfinal.repository.DrinkrecipeRepository;
import com.rickhanberryfinal.services.DrinkrecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Implementation for managing Drinkrecipe.
 */
@Service
@Transactional
public class DrinkrecipeSvcImpl implements DrinkrecipeService {


    @Inject
    private DrinkrecipeRepository drinkrecipeRepository;

    /**
     * Save a drinkrecipe.
     * @return the persisted entity
     */
    public Drinkrecipe save(Drinkrecipe drinkrecipe) {
        Drinkrecipe result = drinkrecipeRepository.save(drinkrecipe);
        return result;
    }

    /**
     *  get all the drinkrecipes.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Drinkrecipe> findAll() {
        List<Drinkrecipe> result = drinkrecipeRepository.findAllWithEagerRelationships();
        return result;
    }

    /**
     *  get one drinkrecipe by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Drinkrecipe findOne(Long id) {
        Drinkrecipe drinkrecipe = drinkrecipeRepository.findOneWithEagerRelationships(id);
        return drinkrecipe;
    }

    /**
     *  delete the  drinkrecipe by id.
     */
    public void delete(Long id) {
        drinkrecipeRepository.delete(id);
    }
}