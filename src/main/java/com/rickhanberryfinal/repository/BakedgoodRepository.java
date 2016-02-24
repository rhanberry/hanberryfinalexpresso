package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.Bakedgood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rhanberry on 2/23/2016.
 * JPA Repository for bakedgood entity
 */
@Repository
public interface BakedgoodRepository extends JpaRepository<Bakedgood,Long> {

    @Query("select distinct bakedgood from Bakedgood bakedgood left join fetch bakedgood.bakallergens")
    List<Bakedgood> findAllWithEagerRelationships();

    @Query("select bakedgood from Bakedgood bakedgood left join fetch bakedgood.bakallergens where bakedgood.id =:id")
    Bakedgood findOneWithEagerRelationships(@Param("id") Long id);

}
