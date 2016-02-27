package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.BakeryCategory;
import com.rickhanberryfinal.repository.BakeryCategoryRepository;
import com.rickhanberryfinal.services.BakeryCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Implementation for managing BakeryCategory.
 */
@Service
@Transactional
public class BakeryCategoryServiceImpl implements BakeryCategoryService{


    @Autowired
    private BakeryCategoryRepository bakeryCategoryRepository;

    /**
     * Save a bakeryCategory.
     * @return the persisted entity
     */
    public BakeryCategory save(BakeryCategory bakeryCategory) {
        BakeryCategory result = bakeryCategoryRepository.save(bakeryCategory);
        return result;
    }

    /**
     *  get all the bakeryCategorys.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<BakeryCategory> findAll() {
        List<BakeryCategory> result = bakeryCategoryRepository.findAll();
        return result;
    }

    /**
     *  get one bakeryCategory by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public BakeryCategory findOne(Long id) {
        BakeryCategory bakeryCategory = bakeryCategoryRepository.findOne(id);
        return bakeryCategory;
    }

    /**
     *  delete the  bakeryCategory by id.
     */
    public void delete(Long id) {
        bakeryCategoryRepository.delete(id);
    }
}

