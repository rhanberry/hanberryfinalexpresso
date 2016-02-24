package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Allergens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA Repository for allergens entity
 */
@Repository
public interface AllergensRepository extends JpaRepository<Allergens,Long>{

}
