/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadplayground;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 *
 * @author Professor Wergeles
 */
public class CounterThread2 extends Thread{
    
    public Boolean stop = false; 
    
    private Integer countTo = 0; 
    private TextArea textArea; 
    
    public CounterThread2(Integer countTo, TextArea textArea){
        this.countTo = countTo; 
        this.textArea = textArea; 
    }
    
    @Override
    public void run(){
        for(int k = 0; k < countTo; k++){
            String message = "k = " + k;
            
            //update for main method
            Platform.runLater(() -> {
                textArea.appendText(message + "\n");
            });
            
            System.out.println(message); 
            
            if(stop){
                return; 
            }

            //sleep() method is not guaranteed, so must surround with try-catch statement
            try {
                //class method using super class
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CounterThread2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
