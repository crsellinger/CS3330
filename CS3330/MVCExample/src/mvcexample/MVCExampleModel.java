/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexample;

import java.util.ArrayList;

/**
 *
 * @author Professor Wergeles
 */
public class MVCExampleModel {
    //This class stores data
    
    private ArrayList<String> people;
    
    public MVCExampleModel(){
        people = new ArrayList<>();
    }
    
    //setters
    public boolean addPerson(String person){
        return people.add(person);  //add() method returns boolean, use this to notify controller
                                    //and update view
    }
    
    public boolean deleteEveryone(){
        people.clear();
        
        return people.isEmpty();    //isEmpty() method returns boolean, use this to notify controller
                                    //and update view
    }
    
    //getters
    public ArrayList<String> getEveryone(){
        return people;
    }
    
}