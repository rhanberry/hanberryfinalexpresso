package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA/SpringData Repository for the vendor entity
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long> {

}
