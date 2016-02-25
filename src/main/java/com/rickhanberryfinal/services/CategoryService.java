package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.Category;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Interface for managing Category.
 */
public interface CategoryService {

    /**
     * Save a category.
     * @return the persisted entity
     */
    public Category save(Category category);

    /**
     *  get all the categorys.
     *  @return the list of entities
     */
    public List<Category> findAll();

    /**
     *  get the "id" category.
     *  @return the entity
     */
    public Category findOne(Long id);

    /**
     *  delete the "id" category.
     */
    public void delete(Long id);

}
