package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.Unitofmeasure;
import com.rickhanberryfinal.repository.UnitofmeasureRepository;
import com.rickhanberryfinal.services.UnitofmeasureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by rhanberry on 2/24/2016.
 *
 * Service Implementation for managing Unitofmeasure.
 */

@Service
@Transactional
public class UnitofmeasureSvcImpl implements UnitofmeasureService {


    @Autowired
    private UnitofmeasureRepository unitofmeasureRepository;

    /**
     * Save a unitofmeasure.
     * @return the persisted entity
     */
    public Unitofmeasure save(Unitofmeasure unitofmeasure) {
        Unitofmeasure result = unitofmeasureRepository.save(unitofmeasure);
        return result;
    }

    /**
     *  get all the unitofmeasures.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Unitofmeasure> findAll() {
        List<Unitofmeasure> result = unitofmeasureRepository.findAll();
        return result;
    }

    /**
     *  get one unitofmeasure by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Unitofmeasure findOne(Long id) {
        Unitofmeasure unitofmeasure = unitofmeasureRepository.findOne(id);
        return unitofmeasure;
    }

    /**
     *  delete the  unitofmeasure by id.
     */
    public void delete(Long id) {
        unitofmeasureRepository.delete(id);
    }
}
