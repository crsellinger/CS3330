/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasingletonexample;

/**
 *
 * @author Professor Wergeles
 */
public class JavaSingletonExample {
    
    public static void main(String[] args) {

        
        SingleThing s1 = SingleThing.getInstance();
        SingleThing s2 = SingleThing.getInstance();
        
        s1.setName("Bob");
        
        if(s1 == s2){
            System.out.println("Same object (s1 == s2)"); 
        }
        
//        if(example.s3 == s1){
//            System.out.println("Same object (example.s3 == s1"); 
//        }
        
        
        System.out.println("s1 filename: " + s1.getName()); 
        System.out.println("s2 filename: " + s2.getName()); 
//        System.out.println("example s3 filename: " + example.s3.getName());
    }
}