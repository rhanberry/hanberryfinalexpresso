package com.rickhanberryfinal.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

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
    @Min(value = 0)
    @Column(name = "ingredientprice", nullable = false)
    private Double ingredientprice;

    @NotNull
    @Size(max = 255)
    @Column(name = "ingredientunit", length = 255, nullable = false)
    private String ingredientunit;

    @ManyToOne
    @JoinColumn(name = "ingredients_id")
    private DrinkRecipe ingredients;

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

    public Double getIngredientprice() {
        return ingredientprice;
    }

    public void setIngredientprice(Double ingredientprice) {
        this.ingredientprice = ingredientprice;
    }

    public String getIngredientunit() {
        return ingredientunit;
    }

    public void setIngredientunit(String ingredientunit) {
        this.ingredientunit = ingredientunit;
    }

    public DrinkRecipe getIngredients() {
        return ingredients;
    }

    public void setIngredients(DrinkRecipe drinkRecipe) {
        this.ingredients = drinkRecipe;
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
                ", ingredientprice='" + ingredientprice + "'" +
                ", ingredientunit='" + ingredientunit + "'" +
                '}';
    }

}
