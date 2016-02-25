package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.Bakedgood;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Interface for managing Bakedgood.
 */
public interface BakedgoodService {

    /**
     * Save a bakedgood.
     * @return the persisted entity
     */
    public Bakedgood save(Bakedgood bakedgood);

    /**
     *  get all the bakedgoods.
     *  @return the list of entities
     */
    public List<Bakedgood> findAll();

    /**
     *  get the "id" bakedgood.
     *  @return the entity
     */
    public Bakedgood findOne(Long id);

    /**
     *  delete the "id" bakedgood.
     */
    public void delete(Long id);
}
