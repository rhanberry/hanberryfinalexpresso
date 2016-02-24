package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.DrinkRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rhanberry on 2/23/2016.
 * Jpa Repository for Category Entity
 */
@Repository
public interface DrinkRecipeRepository extends JpaRepository<DrinkRecipe,Long> {

}
