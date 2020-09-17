/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;
import entities.Car;
/**
 *
 * @author Noeel
 */


public class CarDTO {
    private Long id;
    private int year;
    private String make;
    private String model;
    private double price;

    public CarDTO(Car car) {
        this.id = car.getId();
        this.year = car.getYear();
        this.make = car.getMake();
        this.model = car.getModel();
        this.price = car.getPrice();
    }

    public CarDTO() {
    }

    
    
    
    
    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
    
    
    
    
    
    
}
