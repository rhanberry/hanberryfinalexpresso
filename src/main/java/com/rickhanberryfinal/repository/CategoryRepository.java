package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA Repository for Category entity
 */
public interface CategoryRepository extends JpaRepository<Category,Long>{

}
