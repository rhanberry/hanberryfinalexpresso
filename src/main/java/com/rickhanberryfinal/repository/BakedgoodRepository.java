package com.rickhanberryfinal.repository;

import com.rickhanberryfinal.entities.BakedGood;
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
public interface BakedGoodRepository extends JpaRepository<BakedGood,Long> {

    @Query("select distinct bakedGood from BakedGood bakedGood left join fetch bakedGood.allergenss")
    List<BakedGood> findAllWithEagerRelationships();

    @Query("select bakedGood from BakedGood bakedGood left join fetch bakedGood.allergenss where bakedGood.id =:id")
    BakedGood findOneWithEagerRelationships(@Param("id") Long id);

}
