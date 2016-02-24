package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Drinkrecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * Jpa Repository for Category Entity
 */
public interface DrinkrecipeRepository extends JpaRepository<Drinkrecipe,Long> {

    @Query("select distinct drinkrecipe from Drinkrecipe drinkrecipe left join fetch drinkrecipe.ingnames")
    List<Drinkrecipe> findAllWithEagerRelationships();

    @Query("select drinkrecipe from Drinkrecipe drinkrecipe left join fetch drinkrecipe.ingnames where drinkrecipe.id =:id")
    Drinkrecipe findOneWithEagerRelationships(@Param("id") Long id);

}
