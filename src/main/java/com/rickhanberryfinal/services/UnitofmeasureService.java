package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.UnitOfMeasure;

import java.util.List;

/**
 * Created by rhanberry on 2/24/2016.
 *
 *  Service Interface for managing UnitOfMeasure entity.
 */
public interface UnitOfMeasureService {

    /**
     * Save a unitOfMeasure.
     * @return the persisted entity
     */
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure);

    /**
     *  get all the unitOfMeasures.
     *  @return the list of entities
     */
    public List<UnitOfMeasure> findAll();

    /**
     *  get the "id" unitOfMeasure.
     *  @return the entity
     */
    public UnitOfMeasure findOne(Long id);

    /**
     *  delete the "id" unitOfMeasure.
     */
    public void delete(Long id);
}