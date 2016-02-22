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
    @Size(max = 255)
    @Column(name = "drinkname", length = 255, nullable = false)
    private String drinkname;

    @OneToMany(mappedBy = "ingredients")
    private Set<Ingredients> ingredientss = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrinkname() {
        return drinkname;
    }

    public void setDrinkname(String drinkname) {
        this.drinkname = drinkname;
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
        DrinkRecipe drinkRecipe = (DrinkRecipe) o;
        if(drinkRecipe.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, drinkRecipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DrinkRecipe{" +
                "id=" + id +
                ", drinkname='" + drinkname + "'" +
                '}';
    }
}
