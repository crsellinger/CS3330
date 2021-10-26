/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

/**
 *
 * @author Caleb
 */
public interface TrainedDog {
    //By default, these methods are public and abstract
    //methods in interface have to be public
    void sit();
    void stand();
    String spreak();
    String bark(int numBarks);
}
