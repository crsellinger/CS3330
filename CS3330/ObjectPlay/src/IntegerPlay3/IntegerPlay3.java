/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerPlay3;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class IntegerPlay3 {
    
    /**
     * @notes
     * Integer class uses predefined memory locations for values inside of its range
     * otherwise it will allocate new memory locations
     * Object Interning: object pool that contains objects (pointers) of the same type
     */
    public static void main(String[] args) {
        //Dog dog = new Dog();
        //int x = 0;
        Integer x = -128;
        
        Integer y = -129;
        
        System.out.println("x " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y " + System.identityHashCode(y) + " " + y.toString());

        y = y + 1;
        
        System.out.println("x " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y " + System.identityHashCode(y) + " " + y.toString());

        //checks to see if same address
        //Integer object range is -128 to 128, anything outside of this
        //is will change the memory addresses of objects
        if (x == y) {
            System.out.println("They are the same object"); 
        } else {
            System.out.println("They are different objects"); 
        }
        
        //checks to see if same value
        if (x.equals(y)) {
            System.out.println("They are the same value"); 
        } else {
            System.out.println("They are the different values");
        }
    }
}
