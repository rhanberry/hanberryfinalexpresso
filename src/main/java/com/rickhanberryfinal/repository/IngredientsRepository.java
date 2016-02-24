package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA/Spring Data Repository for Ingredients
 */
@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients,Long>{

}
