package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.UnitOfMeasure;
import com.rickhanberryfinal.repository.UnitOfMeasureRepository;
import com.rickhanberryfinal.services.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rhanberry on 2/24/2016.
 *
 * Service Implementation for managing UnitOfMeasure.
 */

@Service
@Transactional
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService{


    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    /**
     * Save a unitOfMeasure.
     * @return the persisted entity
     */
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        UnitOfMeasure result = unitOfMeasureRepository.save(unitOfMeasure);
        return result;
    }

    /**
     *  get all the unitOfMeasures.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<UnitOfMeasure> findAll() {
        List<UnitOfMeasure> result = unitOfMeasureRepository.findAll();
        return result;
    }

    /**
     *  get one unitOfMeasure by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public UnitOfMeasure findOne(Long id) {
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findOne(id);
        return unitOfMeasure;
    }

    /**
     *  delete the  unitOfMeasure by id.
     */
    public void delete(Long id) {
        unitOfMeasureRepository.delete(id);
    }
}
