package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.DrinkRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Jpa Repository for BakeryCategory Entity
 */
@Repository
public interface DrinkRecipeRepository extends JpaRepository<DrinkRecipe,Long> {

    @Query("select distinct drinkRecipe from DrinkRecipe drinkRecipe left join fetch drinkRecipe.ingredientss")
    List<DrinkRecipe> findAllWithEagerRelationships();

    @Query("select drinkRecipe from DrinkRecipe drinkRecipe left join fetch drinkRecipe.ingredientss where drinkRecipe.id =:id")
    DrinkRecipe findOneWithEagerRelationships(@Param("id") Long id);

}

