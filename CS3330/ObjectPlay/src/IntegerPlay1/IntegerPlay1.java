/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerPlay1;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class IntegerPlay1 {
    
    /**
     * @notes 
     */
    public static void main(String[] args) {
       Integer a = 1;
        
        
       
        a++;
        System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
        
        a--;
        System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
    }
}
