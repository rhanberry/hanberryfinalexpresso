package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.Bakedgood;
import com.rickhanberryfinal.repository.BakedgoodRepository;
import com.rickhanberryfinal.services.BakedgoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 */
@Service
@Transactional
public class BakedgoodSvcImpl implements BakedgoodService {


    @Autowired
    private BakedgoodRepository bakedgoodRepository;

    /**
     * Save a bakedgood.
     * @return the persisted entity
     */
    public Bakedgood save(Bakedgood bakedgood) {
        Bakedgood result = bakedgoodRepository.save(bakedgood);
        return result;
    }

    /**
     *  get all the bakedgoods.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Bakedgood> findAll() {
        List<Bakedgood> result = bakedgoodRepository.findAllWithEagerRelationships();
        return result;
    }

    /**
     *  get one bakedgood by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Bakedgood findOne(Long id) {
        Bakedgood bakedgood = bakedgoodRepository.findOneWithEagerRelationships(id);
        return bakedgood;
    }

    /**
     *  delete the  bakedgood by id.
     */
    public void delete(Long id) {
        bakedgoodRepository.delete(id);
    }
}
