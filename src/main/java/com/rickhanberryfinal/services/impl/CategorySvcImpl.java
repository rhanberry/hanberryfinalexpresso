package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.Category;
import com.rickhanberryfinal.repository.CategoryRepository;
import com.rickhanberryfinal.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Implementation for managing Category.
 */
@Service
@Transactional
public class CategorySvcImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Save a category.
     * @return the persisted entity
     */
    public Category save(Category category) {
        Category result = categoryRepository.save(category);
        return result;
    }

    /**
     *  get all the categorys.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        List<Category> result = categoryRepository.findAll();
        return result;
    }

    /**
     *  get one category by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Category findOne(Long id) {
        Category category = categoryRepository.findOne(id);
        return category;
    }

    /**
     *  delete the  category by id.
     */
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
