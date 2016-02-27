package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.BakedGood;
import com.rickhanberryfinal.repository.BakedGoodRepository;
import com.rickhanberryfinal.services.BakedGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * Service Implementation for managing BakedGood.
 *
 * Created by rhanberry on 2/23/2016.
 */
@Service
@Transactional
public class BakedGoodServiceImpl implements BakedGoodService{


    @Autowired
    private BakedGoodRepository bakedGoodRepository;

    /**
     * Save a bakedGood.
     * @return the persisted entity
     */
    public BakedGood save(BakedGood bakedGood) {
        BakedGood result = bakedGoodRepository.save(bakedGood);
        return result;
    }

    /**
     *  get all the bakedGoods.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<BakedGood> findAll() {
        List<BakedGood> result = bakedGoodRepository.findAllWithEagerRelationships();
        return result;
    }

    /**
     *  get one bakedGood by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public BakedGood findOne(Long id) {
        BakedGood bakedGood = bakedGoodRepository.findOneWithEagerRelationships(id);
        return bakedGood;
    }

    /**
     *  delete the  bakedGood by id.
     */
    public void delete(Long id) {
        bakedGoodRepository.delete(id);
    }
}