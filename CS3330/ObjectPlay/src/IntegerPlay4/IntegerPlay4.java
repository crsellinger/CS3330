/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerPlay4;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class IntegerPlay4 {
    
    /**
     * @notes
     * 1) Java handles pointers for you, making efficient use of memory addresses
     * using Object Interning
     * 
     * 2) 
     */
    public static void main(String[] args) {
        
        //Objects, 'a' and 'b' stores the reference to -140
        Integer a = -140;
        Integer b = -140;
        
        //Primitive data types
        int c = -140;
        int d = -140;
        
        for (int step = 0; step < 300; step++) {
            
            a++;
            b++;
            
            c++;
            d++;
            
            System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
            System.out.println("b: " + b + " ("+System.identityHashCode(b)+")");
            System.out.println("c: " + c + " ("+System.identityHashCode(c)+")");
            System.out.println("d: " + d + " ("+System.identityHashCode(d)+")");
            
            if (a == b) System.out.println("a == b");
            else  System.out.println("a != b");
            
            if (a == c) System.out.println("a == c");
            else  System.out.println("a != c");
            

            if (a == d) System.out.println("a == d");
            else  System.out.println("a != d");
            

            System.out.println("----------------------");
        }
    }
}
