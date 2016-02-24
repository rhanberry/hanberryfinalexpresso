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
 * This entity class defines the components and relations of the coffee drink ingredients
 *
 */

@Entity
@Table(name = "ingredients")
public class Ingredients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "ingredientname", length = 255, nullable = false)
    private String ingredientname;

    @NotNull
    @Column(name = "ingredientcost", nullable = false)
    private Double ingredientcost;

    @ManyToOne
    @JoinColumn(name = "ingredientunit_id")
    private Unitofmeasure ingredientunit;

    @ManyToMany(mappedBy = "ingnames")
    @JsonIgnore
    private Set<Drinkrecipe> ingnames = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientname() {
        return ingredientname;
    }

    public void setIngredientname(String ingredientname) {
        this.ingredientname = ingredientname;
    }

    public Double getIngredientcost() {
        return ingredientcost;
    }

    public void setIngredientcost(Double ingredientcost) {
        this.ingredientcost = ingredientcost;
    }

    public Unitofmeasure getIngredientunit() {
        return ingredientunit;
    }

    public void setIngredientunit(Unitofmeasure unitofmeasure) {
        this.ingredientunit = unitofmeasure;
    }

    public Set<Drinkrecipe> getIngnames() {
        return ingnames;
    }

    public void setIngnames(Set<Drinkrecipe> drinkrecipes) {
        this.ingnames = drinkrecipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ingredients ingredients = (Ingredients) o;
        if(ingredients.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, ingredients.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", ingredientname='" + ingredientname + "'" +
                ", ingredientcost='" + ingredientcost + "'" +
                '}';
    }
}