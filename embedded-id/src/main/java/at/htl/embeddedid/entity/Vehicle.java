package at.htl.embeddedid.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;

    private String brand;

    private String model;

    public Vehicle() {
    }

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    //region getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%d, %s %s",getId(),getBrand(),getModel());
    }
}
