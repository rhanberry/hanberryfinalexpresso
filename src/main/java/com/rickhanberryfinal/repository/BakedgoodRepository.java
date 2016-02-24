package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Bakedgood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA Repository for bakedgood entity
 */
@Repository
public interface BakedgoodRepository extends JpaRepository<Bakedgood,Long>{

}
