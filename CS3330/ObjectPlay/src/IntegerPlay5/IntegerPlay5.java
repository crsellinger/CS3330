/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerPlay5;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class IntegerPlay5 {
    
    /**
     * @notes  
     */
    public static void main(String[] args) {
        
        Integer a = 100; //because value is within the range, memory location is in the object pool
        
        Integer b = new Integer(100);   //allocates a new memory location outside of pool for the value 100

        System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
        System.out.println("b: " + b + " ("+System.identityHashCode(b)+")");
        
        //compares the reference, so this statement will fail due to how the objects
        //were created, even though the values are the same
        if (a == b) System.out.println("a == b");
        else System.out.println("a != b");
        
        //This statement doesnt work with primitive data types, as they cannot have
        //methods associated with them
        if (a.equals(b)) System.out.println("a equals b");
        else System.out.println("a doesn't equal b");
    }
}
