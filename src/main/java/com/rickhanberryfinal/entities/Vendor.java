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
 * This entity represents te baked good Vendors.
 */
@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "vendorname", length = 255, nullable = false)
    private String vendorname;
    
    @OneToMany(mappedBy = "vendor")
    @JsonIgnore
    private Set<Bakedgood> vendors = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorname() {
        return vendorname;
    }
    
    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public Set<Bakedgood> getVendors() {
        return vendors;
    }

    public void setVendors(Set<Bakedgood> bakedgoods) {
        this.vendors = bakedgoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vendor vendor = (Vendor) o;
        if(vendor.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, vendor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Vendor{" +
            "id=" + id +
            ", vendorname='" + vendorname + "'" +
            '}';
    }
}
