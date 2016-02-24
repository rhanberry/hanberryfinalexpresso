package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.Unitofmeasure;

import java.util.List;

/**
 * Created by rhanberry on 2/24/2016.
 *
 *  Service Interface for managing Unitofmeasure entity.
 */
public interface UnitofmeasureService {

    /**
     * Save a unitofmeasure.
     * @return the persisted entity
     */
    public Unitofmeasure save(Unitofmeasure unitofmeasure);

    /**
     *  get all the unitofmeasures.
     *  @return the list of entities
     */
    public List<Unitofmeasure> findAll();

    /**
     *  get the "id" unitofmeasure.
     *  @return the entity
     */
    public Unitofmeasure findOne(Long id);

    /**
     *  delete the "id" unitofmeasure.
     */
    public void delete(Long id);
}