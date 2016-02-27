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
@Table(name = "bakery_category")
public class BakeryCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "bakery_category", length = 50, nullable = false)
    private String bakeryCategory;

    @OneToMany(mappedBy = "bakeryCategory")
    private Set<BakedGood> bakedGoods = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBakeryCategory() {
        return bakeryCategory;
    }

    public void setBakeryCategory(String bakeryCategory) {
        this.bakeryCategory = bakeryCategory;
    }

    public Set<BakedGood> getBakedGoods() {
        return bakedGoods;
    }

    public void setBakedGoods(Set<BakedGood> bakedGoods) {
        this.bakedGoods = bakedGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BakeryCategory bakeryCategory = (BakeryCategory) o;
        if(bakeryCategory.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, bakeryCategory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "BakeryCategory{" +
                "id=" + id +
                ", bakeryCategory='" + bakeryCategory + "'" +
                '}';
    }
}