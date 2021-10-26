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
public class Crsb74Vehicles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("3FA6P0LUXKR106257", "Ford");
        
        vehicle1.setColor("Gray");
        vehicle1.setOdometer(43075);
        vehicle1.setCategory(Category.SEDAN);
        vehicle1.setPrice(14999);
        
        Vehicle vehicle2 = new Vehicle("2LMPJ8L99KBL39829", "Lincoln", "Silver", 17259, Category.SUV, 37997);
        
        Vehicle vehicle3 = new Vehicle();
        
        vehicle3.setVin("1G1FB3DS6J0164204");
        vehicle3.setMake("Chevrolet");
        vehicle3.setColor("Bright Yellow");
        vehicle3.setOdometer(38601);
        vehicle3.setCategory(Category.CONVERTIBLE);
        vehicle3.setPrice(21970);
        vehicle3.setPrice(19350);
        
        //Print for Vehicle 1
        System.out.println("Vehicle 1:\nVIN Number: " + vehicle1.getVin() +
                           "\nMake: " + vehicle1.getMake() +
                           "\nColor: " + vehicle1.getColor() +
                           "\nCategory: " + vehicle1.getCategory() +
                           "\nOdometer: " + vehicle1.getOdometer() +
                           "\nPrice: " + vehicle1.getPrice() +
                           "\nVersion: " + vehicle1.getVersion());
        
        //Print for Vehicle 2
        System.out.println("\nVehicle 2:\nVIN Number: " + vehicle2.getVin() +
                           "\nMake: " + vehicle2.getMake() +
                           "\nColor: " + vehicle2.getColor() +
                           "\nCategory: " + vehicle2.getCategory() +
                           "\nOdometer: " + vehicle2.getOdometer() +
                           "\nPrice: " + vehicle2.getPrice() +
                           "\nVersion: " + vehicle2.getVersion());
        
        //Print for Vehicle 3
        System.out.println("\nVehicle 3:\nVIN Number: " + vehicle3.getVin() +
                           "\nMake: " + vehicle3.getMake() +
                           "\nColor: " + vehicle3.getColor() +
                           "\nCategory: " + vehicle3.getCategory() +
                           "\nOdometer: " + vehicle3.getOdometer() +
                           "\nPrice: " + vehicle3.getPrice() +
                           "\nVersion: " + vehicle3.getVersion());
        
        //Print for numOfVehicles
        System.out.println("\nNumber of Vehicles: " + Vehicle.numOfVehicles);
    }
}
