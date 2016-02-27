package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.BakeryCategory;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Interface for managing BakeryCategory.
 */
public interface BakeryCategoryService {

    /**
     * Save a bakeryCategory.
     * @return the persisted entity
     */
    public BakeryCategory save(BakeryCategory bakeryCategory);

    /**
     *  get all the bakeryCategorys.
     *  @return the list of entities
     */
    public List<BakeryCategory> findAll();

    /**
     *  get the "id" bakeryCategory.
     *  @return the entity
     */
    public BakeryCategory findOne(Long id);

    /**
     *  delete the "id" bakeryCategory.
     */
    public void delete(Long id);
}
