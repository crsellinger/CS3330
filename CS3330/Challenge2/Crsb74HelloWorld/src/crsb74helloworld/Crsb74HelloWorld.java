/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74helloworld;

/**
 *
 * @author Caleb Sellinger
 * REFERENCES: 
 * 1) https://www.javatpoint.com/java-get-current-date for getting current system data and time and formatting
 * 2) https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html for further formatting
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Crsb74HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String myPawprint = "crsb74";
        System.out.println("Hello World!");
        invokeMe(myPawprint);
    }
    public static void invokeMe(String x){
        DateTimeFormatter config = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        LocalDateTime time = LocalDateTime.now();
        System.out.println("My PawPrint is " + x);
        System.out.println("Today's date is " + config.format(time) + "\n");
    }
}
