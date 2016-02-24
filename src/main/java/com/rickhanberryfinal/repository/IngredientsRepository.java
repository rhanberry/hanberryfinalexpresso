package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA/Spring Data Repository for Ingredients
 */
public interface IngredientsRepository extends JpaRepository<Ingredients,Long>{

}
