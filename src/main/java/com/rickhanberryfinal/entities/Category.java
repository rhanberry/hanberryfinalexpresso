package com.rickhanberryfinal.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * Created by rhanberry on 2/22/2016.
 * @author rhanberry
 * This entity represents the baked good category.
 */

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "bakerycategory", length = 255, nullable = false)
    private String bakerycategory;

    @OneToMany(mappedBy = "bakcat")
    private Set<Bakedgood> bakcats = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBakerycategory() {
        return bakerycategory;
    }

    public void setBakerycategory(String bakerycategory) {
        this.bakerycategory = bakerycategory;
    }

    public Set<Bakedgood> getBakcats() {
        return bakcats;
    }

    public void setBakcats(Set<Bakedgood> bakedgoods) {
        this.bakcats = bakedgoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        if(category.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", bakerycategory='" + bakerycategory + "'" +
                '}';
    }
}