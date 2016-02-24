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
@Table(name = "drinkrecipe")
public class Drinkrecipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "drinkname", length = 255, nullable = false)
    private String drinkname;

    @ManyToMany
    @JoinTable(name = "drinkrecipe_ingname",
            joinColumns = @JoinColumn(name="drinkrecipes_id", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="ingnames_id", referencedColumnName="ID"))
    private Set<Ingredients> ingnames = new HashSet<>();

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

    public Set<Ingredients> getIngnames() {
        return ingnames;
    }

    public void setIngnames(Set<Ingredients> ingredientss) {
        this.ingnames = ingredientss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Drinkrecipe drinkrecipe = (Drinkrecipe) o;
        if(drinkrecipe.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, drinkrecipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Drinkrecipe{" +
                "id=" + id +
                ", drinkname='" + drinkname + "'" +
                '}';
    }
}
