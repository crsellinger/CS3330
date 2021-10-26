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
public class Cat extends Pet{
    
    public Cat(String name, int age, Gender gender){
        //gets constructer from Pet class
        super("Cat", name, age, gender);
    }
    
    public void meow(int num){
        for (int i = 0; i < num; i++){
            System.out.println("Meow.");
        }
    }
    
    //only meows once, by invoking method above
    //using polymorphism
    public void meow(){
        meow(1);
    }
    
    //Using polymorphism, remember to document each method
    //invocation and its parameter list
    public String meow(String noise){
        return noise;
    }
    
    //getAge is already in the superclass
    //and each method has the same signature
    //therefore, use @Overrride to override superclass method
    @Override
    public int getAge(){
        return age * 7;
    }
}
