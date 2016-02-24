package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA/SpringData Repository for the vendor entity
 */
public interface VendorRepository extends JpaRepository<Vendor,Long> {

}
