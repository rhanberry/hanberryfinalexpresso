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
@Table(name = "unitofmeasure")
public class Unitofmeasure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "unit", length = 255, nullable = false)
    private String unit;

    @OneToMany(mappedBy = "ingredientunit")
    @JsonIgnore
    private Set<Ingredients> ingredientunits = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Set<Ingredients> getIngredientunits() {
        return ingredientunits;
    }

    public void setIngredientunits(Set<Ingredients> ingredientss) {
        this.ingredientunits = ingredientss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Unitofmeasure unitofmeasure = (Unitofmeasure) o;
        if(unitofmeasure.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, unitofmeasure.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Unitofmeasure{" +
                "id=" + id +
                ", unit='" + unit + "'" +
                '}';
    }
}
