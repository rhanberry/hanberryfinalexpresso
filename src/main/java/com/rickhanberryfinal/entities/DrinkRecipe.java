package com.rickhanberryfinal.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by rhanberry on 2/22/2016.
 *@author rhanberry
 *
 * This is the entity that represents the whole coffee recipe.
 *
 */
@Entity
@Table(name = "drink_recipe")
public class DrinkRecipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "drink_recipe", length = 50, nullable = false)
    private String drinkRecipe;

    @ManyToMany
    @JoinTable(name = "drink_recipe_ingredients",
            joinColumns = @JoinColumn(name="drink_recipes_id", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="ingredientss_id", referencedColumnName="ID"))
    private Set<Ingredients> ingredientss = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrinkRecipe() {
        return drinkRecipe;
    }

    public void setDrinkRecipe(String drinkRecipe) {
        this.drinkRecipe = drinkRecipe;
    }

    public Set<Ingredients> getIngredientss() {
        return ingredientss;
    }

    public void setIngredientss(Set<Ingredients> ingredientss) {
        this.ingredientss = ingredientss;
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
        DrinkRecipe drinkRecipe = (DrinkRecipe) o;
        if(drinkRecipe.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, drinkRecipe.id);
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
        return "DrinkRecipe{" +
                "id=" + id +
                ", drinkRecipe='" + drinkRecipe + "'" +
                '}';
    }
}
