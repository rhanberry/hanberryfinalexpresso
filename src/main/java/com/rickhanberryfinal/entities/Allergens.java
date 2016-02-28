package com.rickhanberryfinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by rhanberry on 2/22/2016.
 * @author rhanberry
 * This entity class defines the components and relations of the allergens in baked goods
 *
 */
@Entity
@Table(name = "allergens")
public class Allergens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "allergen", length = 50, nullable = false)
    private String allergen;

    @ManyToMany(mappedBy = "allergenss")
    @JsonIgnore
    private Set<BakedGood> bakedGoods = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllergen() {
        return allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }

    public Set<BakedGood> getBakedGoods() {
        return bakedGoods;
    }

    public void setBakedGoods(Set<BakedGood> bakedGoods) {
        this.bakedGoods = bakedGoods;
    }

    /**
     * @param   o   the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Allergens allergens = (Allergens) o;
        if(allergens.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, allergens.id);
    }

    /**
     *
     * @return a hashcode value for the object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /**
     *
     *@return a string representation of the object
     */
    @Override
    public String toString() {
        return "Allergens{" +
                "id=" + id +
                ", allergen='" + allergen + "'" +
                '}';
    }
}
