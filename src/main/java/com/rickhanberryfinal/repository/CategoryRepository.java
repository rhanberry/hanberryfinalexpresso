package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA Repository for Category entity
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

}
