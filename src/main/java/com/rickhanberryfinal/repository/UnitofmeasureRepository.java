package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Unitofmeasure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rhanberry on 2/24/2016.
 *
 * Spring Data JPA repository for the Unitofmeasure entity.
 */
public interface UnitofmeasureRepository extends JpaRepository<Unitofmeasure,Long> {

}