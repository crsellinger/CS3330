/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74vehicles;

/**
 *
 * @author Caleb Sellinger
 */
public class Vehicle {
    private String vin;
    private String make;
    private double price;
    private Category category;
    private String color;
    private int odometer = 0;
    private int version;
    public static int numOfVehicles = 0;
    
    //constructor1
    public Vehicle(){
        ++numOfVehicles;
        vin = "";
        make = "";
        version = 0;
    }
    
    //constructor2
    public Vehicle(String vin, String make){
        this();
        this.vin = vin;
        this.make = make;
    }
    
    //constructor3
    public Vehicle(String vin, String make, String color, int odometer, Category category, double price){
        this(vin, make);
        version = 1;
        this.color = color;
        this.odometer = odometer;
        this.category = category;
        this.price = price;
    }
    
    //Methods
    //setters
    public void setVin(String vin){
        this.vin = vin;
    }
    
    public void setMake(String make){
        this.make = make;
    }
    
    public void setPrice(double price){
        this.price = price;
        ++version;
    }
    
    public void setCategory(Category category){
        this.category = category;
    }
    
    public void setColor(String color){
        this.color = color;
        ++version;
    }
    
    public void setOdometer(int odometer){
        this.odometer = odometer;
        ++version;
    }
    
    //getters
    public String getVin(){
        return vin;
    }
    
    public String getMake(){
        return make;
    }
    
    public double getPrice(){
        return price;
    }
    
    public Category getCategory(){
        return category;
    }
    
    public String getColor(){
        return color;
    }
    
    public int getOdometer(){
        return odometer;
    }
    
    public int getVersion(){
        return version;
    }
}
