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
 * @author rhanberry
 * This entity represents the baked good and its relations to its other components.
 */
@Entity
@Table(name = "baked_good")
public class BakedGood implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "baked_good", length = 50, nullable = false)
    private String bakedGood;

    @NotNull
    @Column(name = "baked_good_cost", nullable = false)
    private Double bakedGoodCost;

    @ManyToOne
    @JoinColumn(name = "bakery_category_id")
    private BakeryCategory bakeryCategory;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToMany
    @JoinTable(name = "baked_good_allergens",
            joinColumns = @JoinColumn(name="baked_goods_id", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="allergenss_id", referencedColumnName="ID"))
    private Set<Allergens> allergenss = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBakedGood() {
        return bakedGood;
    }

    public void setBakedGood(String bakedGood) {
        this.bakedGood = bakedGood;
    }

    public Double getBakedGoodCost() {
        return bakedGoodCost;
    }

    public void setBakedGoodCost(Double bakedGoodCost) {
        this.bakedGoodCost = bakedGoodCost;
    }

    public BakeryCategory getBakeryCategory() {
        return bakeryCategory;
    }

    public void setBakeryCategory(BakeryCategory bakeryCategory) {
        this.bakeryCategory = bakeryCategory;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Set<Allergens> getAllergenss() {
        return allergenss;
    }

    public void setAllergenss(Set<Allergens> allergenss) {
        this.allergenss = allergenss;
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
        BakedGood bakedGood = (BakedGood) o;
        if(bakedGood.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, bakedGood.id);
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
        return "BakedGood{" +
                "id=" + id +
                ", bakedGood='" + bakedGood + "'" +
                ", bakedGoodCost='" + bakedGoodCost + "'" +
                '}';
    }
}
