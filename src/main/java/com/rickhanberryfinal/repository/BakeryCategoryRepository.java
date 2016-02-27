package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.BakeryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA Repository for BakeryCategory entity
 */
@Repository
public interface BakeryCategoryRepository extends JpaRepository<BakeryCategory,Long>{

}
