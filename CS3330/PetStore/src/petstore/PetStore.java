/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

//import static petstore.Gender.FEMALE;
//import static petstore.Gender.MALE;

import java.util.ArrayList;
import static petstore.Gender.*; 

/**
 *
 * @author Professor Wergeles
 */
public class PetStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //no arg constructor call
        Pet pet = new Pet();
        pet.setName("Maggie");
        pet.age = 3;
        pet.gender = Gender.FEMALE;
        pet.type = "Dog";
        
        //constructor call with parameters
        Pet pet2 = new Pet("Cat", "Kitty!", 2, Gender.FEMALE);
        
        System.out.println("pet Name = " + pet.getName());
        System.out.println("pet2 Name = " + pet2.getName());        
        Dog dog = new Dog("Fido", 3, MALE);
        
        System.out.println(dog.getName() + " is " + dog.getAge() + " years old.");
        
        dog.birthday();
        
        System.out.println(dog.getName() + " is " + dog.getAge() + " years old.");
        
        Dog dog2 = new Dog("Halo", 11, Gender.FEMALE);
        
        dog2.birthday();
        
        System.out.println(dog2.getName() + " is " + dog2.getAge() + " years old.");
        
        //Class 05
        Cat cat = new Cat("Susan", 2, Gender.FEMALE);
        
        //cat is a subclass of Pet, an implicit cast is used
        //all cats are pets because Cat extends Pet
        Pet pet3 = cat;
        
        //Not all Pets are of type Cat, so an explicit cast must occur
        //Cat cat2 = pet3;
        //So cat2 must be of type Cat if the subclass is of type superclass
        Cat cat2 = (Cat) pet3;
        
        //Logic test to make sure cat3 is of type Cat
        if (pet3 instanceof Cat){
            Cat cat3 = (Cat) pet3;
        }
        
        cat2.meow();
        cat2.meow(3);
        
        Pet test = new Pet("Cat", "No", 2, Gender.FEMALE);
        
        }   
}