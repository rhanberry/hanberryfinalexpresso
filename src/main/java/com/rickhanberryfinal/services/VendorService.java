package com.rickhanberryfinal.services;

import com.rickhanberryfinal.entities.Vendor;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 *
 * Service Interface for managing Vendor.
 */
public interface VendorService {

    /**
     * Save a vendor.
     * @return the persisted entity
     */
    public Vendor save(Vendor vendor);

    /**
     *  get all the vendors.
     *  @return the list of entities
     */
    public List<Vendor> findAll();

    /**
     *  get the "id" vendor.
     *  @return the entity
     */
    public Vendor findOne(Long id);

    /**
     *  delete the "id" vendor.
     */
    public void delete(Long id);
}
