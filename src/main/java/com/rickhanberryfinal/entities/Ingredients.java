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
    @Size(max = 50)
    @Column(name = "ingredient", length = 50, nullable = false)
    private String ingredient;

    @NotNull
    @Column(name = "ingredient_cost", nullable = false)
    private Double ingredientCost;

    @ManyToOne
    @JoinColumn(name = "unit_of_measure_id")
    private UnitOfMeasure unitOfMeasure;

    @ManyToMany(mappedBy = "ingredientss")
    @JsonIgnore
    private Set<DrinkRecipe> drinkRecipes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Double getIngredientCost() {
        return ingredientCost;
    }

    public void setIngredientCost(Double ingredientCost) {
        this.ingredientCost = ingredientCost;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Set<DrinkRecipe> getDrinkRecipes() {
        return drinkRecipes;
    }

    public void setDrinkRecipes(Set<DrinkRecipe> drinkRecipes) {
        this.drinkRecipes = drinkRecipes;
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
                ", ingredient='" + ingredient + "'" +
                ", ingredientCost='" + ingredientCost + "'" +
                '}';
    }
}
