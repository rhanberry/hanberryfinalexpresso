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
@Table(name = "allergen")
public class Allergen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "allergenname", length = 255, nullable = false)
    private String allergenname;

    @ManyToMany(mappedBy = "bakallergens")
    @JsonIgnore
    private Set<Bakedgood> bakallergens = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllergenname() {
        return allergenname;
    }

    public void setAllergenname(String allergenname) {
        this.allergenname = allergenname;
    }

    public Set<Bakedgood> getBakallergens() {
        return bakallergens;
    }

    public void setBakallergens(Set<Bakedgood> bakedgoods) {
        this.bakallergens = bakedgoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Allergen allergen = (Allergen) o;
        if(allergen.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, allergen.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Allergen{" +
                "id=" + id +
                ", allergenname='" + allergenname + "'" +
                '}';
    }
}
