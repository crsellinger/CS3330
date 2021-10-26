/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerPlay2;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class IntegerPlay2 {
    
    /**
     * @notes 
     */
    public static void main(String[] args) {
        
        Integer a = 1;
        Integer b = 1;
        Integer c = 2;
        
        System.out.println("a " + System.identityHashCode(a) + " " + a.toString());
        System.out.println("b " + System.identityHashCode(b) + " " + b.toString());
        System.out.println("c " + System.identityHashCode(c) + " " + c.toString());
        
        a = a + 3;
  
        System.out.println("a " + System.identityHashCode(a) + " " + a.toString());
        System.out.println("b " + System.identityHashCode(b) + " " + b.toString());
        System.out.println("c " + System.identityHashCode(c) + " " + c.toString());
  
                
        if (a.equals(b)) {
            
            System.out.println("a equals b"); 
            
        } else {

            System.out.println("a DOES NOT b"); 
            
        }
    }
}
