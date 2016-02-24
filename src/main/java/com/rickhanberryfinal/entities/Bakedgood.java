package com.rickhanberryfinal.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by rhanberry on 2/22/2016.
 * @author rhanberry
 * This entity represents the baked good and its relations to its other components.
 */
@Entity
@Table(name = "bakedgood")
public class Bakedgood implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "bakedgoodname", length = 255, nullable = false)
    private String bakedgoodname;
    
    @NotNull
    @Column(name = "bakeryprice", nullable = false)
    private Double bakeryprice;
    
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "allergen_id")
    private Allergen allergen;

    @ManyToOne
    @JoinColumn(name = "categorys_id")
    private Category categorys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBakedgoodname() {
        return bakedgoodname;
    }
    
    public void setBakedgoodname(String bakedgoodname) {
        this.bakedgoodname = bakedgoodname;
    }

    public Double getBakeryprice() {
        return bakeryprice;
    }
    
    public void setBakeryprice(Double bakeryprice) {
        this.bakeryprice = bakeryprice;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Allergen getAllergen() {
        return allergen;
    }

    public void setAllergen(Allergen allergen) {
        this.allergen = allergen;
    }

    public Category getCategorys() {
        return categorys;
    }

    public void setCategorys(Category category) {
        this.categorys = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bakedgood bakedgood = (Bakedgood) o;
        if(bakedgood.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, bakedgood.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Bakedgood{" +
            "id=" + id +
            ", bakedgoodname='" + bakedgoodname + "'" +
            ", bakeryprice='" + bakeryprice + "'" +
            '}';
    }
}
