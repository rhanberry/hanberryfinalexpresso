package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rhanberry on 2/24/2016.
 *
 * Spring Data JPA repository for the UnitOfMeasure entity.
 */
@Repository
public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure,Long> {

}