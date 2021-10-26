/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

/**
 *
 * @author Caleb
 */
public class Dog extends Pet {
    
    //class field (static field); reference with class name
    private static int numOfDogsCreated = 0;
    
    //instance field (non-static field); reference with object (instance of class)
    private int id = 0;
    
    //Constant class field
    private static final String GENUS = "Canis";
    
    //instance field
    private String position = "standing";
    
    public Dog(String name, int age, Gender gender){
        super("Dog", name, age, gender);
        id = ++numOfDogsCreated;
    }
    
    public static String getGenus(){
        return GENUS;
    }
    
    //override a method in Pet.java
//    @Override
//    public void birthday(){
//        age *= 7;
//    }
    
    //Override a method in Pet.java
    //Example of Polymorphism
    @Override
    public int getAge(){
        return age * 7;
    }
    
    public void bark(int num){
        for (int i = 0; i < num; i++){
            System.out.println("Bark!");
        }
    }
    
    //only changes output in one spot
    //using polymorphism; difference in methods
    //is the number of parameter for each invocation
    public void bark(){
        //can use this.bark(), but is unnecessary
        bark(1);
    }
}
