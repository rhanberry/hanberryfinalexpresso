package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.Vendor;
import com.rickhanberryfinal.repository.VendorRepository;
import com.rickhanberryfinal.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 *
 * Service Implementation for managing Vendor.
 */
@Service
@Transactional
public class VendorSvcImpl implements VendorService {


    @Autowired
    private VendorRepository vendorRepository;

    /**
     * Save a vendor.
     * @return the persisted entity
     */
    public Vendor save(Vendor vendor) {
        Vendor result = vendorRepository.save(vendor);
        return result;
    }

    /**
     *  get all the vendors.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Vendor> findAll() {
        List<Vendor> result = vendorRepository.findAll();
        return result;
    }

    /**
     *  get one vendor by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Vendor findOne(Long id) {
        Vendor vendor = vendorRepository.findOne(id);
        return vendor;
    }

    /**
     *  delete the  vendor by id.
     */
    public void delete(Long id) {
        vendorRepository.delete(id);
    }
}
