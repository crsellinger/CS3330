/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

/**
 *
 * @author Professor Wergeles
 */
public class Pet {
    //states for the class (blueprint)
    public String type; 
    private String name; 
    public int age; 
    public Gender gender; 
    
    public Pet() {
        this.age = 0;
    }
    
    public Pet(String type, String name){
        //Chaining constructor #1
        this();
        this.type = type + " Pet";
        this.name = name;
    }
    
    public Pet(String type, String name, int age, Gender gender) {
//        this.type = type; 
//        this.name = name;
        //Chaining constructor #2
        this(type, name);
        this.age = age; 
        this.gender = gender;
    }
    
    public void setName(String input){
        this.name = input; 
    }
    
    public String getName(){
        return this.name; 
    }
    
    public void birthday(){ //setter
        age++;
    }
    
    public int getAge(){    //getter
        return age;
    }
}