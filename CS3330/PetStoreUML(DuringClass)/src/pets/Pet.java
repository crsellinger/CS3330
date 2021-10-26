/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

/**
 *
 * @author Professor Wergeles
 */

//abstract classes can have 0 or more abstract methods
public abstract class Pet {
    private static int numOfPets = 0;

    private String name;
    private Integer age;
    private String type;
    private Gender gender;
    
    public Pet() {
        numOfPets++;
    }
    
    public Pet(String name, int age, String type, Gender gender) {
        this();
        this.name = name;
        this.age = age;
        this.type = type;
        this.gender = gender;
    }
    
    public static int getNumOfPets() {
        return numOfPets;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setGender(Gender gender){
        this.gender = gender;
    }
    
    public Gender getGender(){
        return gender;
    }
    
    public int birthday() {
        age++;
        return age;
    }
    
    /*abstract method:
    1) must make class abstract
    2) must end with semicolon bc the subclass/child class implements it
    3) must be implemented in all subclass with override annotation
    */
    public abstract String[] getCoreVaccines();
    
    public abstract String[] getNonCoreVaccines();
    
    @Override
    public String toString() {
        
        return String.format("Type: %s, Name: %s, Age: %d, Gender: " + gender, type, name, age);
        
    }
}
