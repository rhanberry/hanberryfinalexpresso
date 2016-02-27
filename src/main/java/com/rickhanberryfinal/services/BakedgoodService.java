package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.BakedGood;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Service Interface for managing BakedGood.
 */
public interface BakedGoodService {

    /**
     * Save a bakedGood.
     * @return the persisted entity
     */
    public BakedGood save(BakedGood bakedGood);

    /**
     *  get all the bakedGoods.
     *  @return the list of entities
     */
    public List<BakedGood> findAll();

    /**
     *  get the "id" bakedGood.
     *  @return the entity
     */
    public BakedGood findOne(Long id);

    /**
     *  delete the "id" bakedGood.
     */
    public void delete(Long id);
}