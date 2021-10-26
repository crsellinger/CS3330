/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superarraygenericsdemo;

/**
 *
 * @author Professor Wergeles
 * @param <E>
 */
public class SuperArray<E> {
    
    private E[] arr;
    
    public SuperArray(E[] arr){
        this.arr = arr;
    }
    
    public void displayArray(){
        String outString = ""; 
        
        for (E item : arr){
            outString += item +"\n";
        }
        
        System.out.printf("%s", outString); 
    }
}
