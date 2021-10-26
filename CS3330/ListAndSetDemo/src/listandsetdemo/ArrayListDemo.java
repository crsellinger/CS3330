/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listandsetdemo;

import java.util.ArrayList;



/**
 *
 * @author Professor Wergeles
 */
public class ArrayListDemo {
    
    public static void main(String[] args){
        
        //ArrayList that stores Strings
        ArrayList<String> al = new ArrayList<>();
        
        System.out.println("Initial Size of array list: " + al.size());
        
        
        al.add("Cherry");
        al.add("Apple");
        al.add("Banana");
        al.add("Date");
        
        System.out.println("Contents of array list: " + al);
        
        al.add(2, "Strawberry");
        al.add("Blueberry");
        
        System.out.println("Contents of array list: " + al);
        
        System.out.println("Size of array list after additions: " + al.size()); 
        
        System.out.println("Iterate through list and print items"); 
        
        //Prints all elements in ArrayList al
        for (String item: al){
            System.out.println(item);
        }
        
        
        
//        System.out.println("Contents of array list: " + al);
//        
//        
//        
//        System.out.println("Contents of array list: " + al);
//        
//        System.out.println("Size of array list after deletions: "+ al.size()); 
//        
//        
//        
//        System.out.println("Fist: " + first); 
        
         
    }
}
