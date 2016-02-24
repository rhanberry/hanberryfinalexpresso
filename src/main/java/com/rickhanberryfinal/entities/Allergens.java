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
 * A Allergens.
 */
@Entity
@Table(name = "allergens")
public class Allergens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "allergens", length = 255, nullable = false)
    private String allergens;

    @OneToMany(mappedBy = "allergen")
    private Set<Bakedgood> allergens = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public Set<Bakedgood> getAllergens() {
        return allergens;
    }

    public void setAllergens(Set<Bakedgood> bakedgoods) {
        this.allergens = bakedgoods;
    }

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

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Allergens{" +
            "id=" + id +
            ", allergens='" + allergens + "'" +
            '}';
    }
}
