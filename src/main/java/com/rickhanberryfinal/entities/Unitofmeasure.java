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
 * Created by rhanberry on 2/24/2016.
 * Entity class for units of coffee ingredients
 */
@Entity
@Table(name = "unit_of_measure")
public class UnitOfMeasure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "unit_of_measure", length = 50, nullable = false)
    private String unitOfMeasure;

    @OneToMany(mappedBy = "unitOfMeasure")
    @JsonIgnore
    private Set<Ingredients> ingredientss = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Set<Ingredients> getIngredientss() {
        return ingredientss;
    }

    public void setIngredientss(Set<Ingredients> ingredientss) {
        this.ingredientss = ingredientss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UnitOfMeasure unitOfMeasure = (UnitOfMeasure) o;
        if(unitOfMeasure.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, unitOfMeasure.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "UnitOfMeasure{" +
                "id=" + id +
                ", unitOfMeasure='" + unitOfMeasure + "'" +
                '}';
    }
}
