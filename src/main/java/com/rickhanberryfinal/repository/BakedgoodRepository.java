package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Bakedgood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA Repository for bakedgood entity
 */
public interface BakedgoodRepository extends JpaRepository<Bakedgood,Long>{

}
