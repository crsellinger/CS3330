/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74languagebasicss20;

/**
 *
 * @author Caleb Sellinger
 * References:
 *  1)https://www.javatpoint.com/java-integer-parseint-method
 *      for parsing date/time string and storing as integer value (lines 37,38)
 * 2)https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 *      for formatting date/time (line 27)
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Crsb74LanguageBasicsS20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateTimeFormatter parsedHour = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter parsedMin = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        LocalDateTime time = LocalDateTime.now();
        char c1 = 'D';
        char c2 = 68;
        short qualityScore = 89;
        float weight = 154.7f;
        float height = 70.87f;
        boolean sunny = true;
        boolean warm = false;
        int hour = Integer.parseInt(parsedHour.format(time));
        int minute = Integer.parseInt(parsedMin.format(time));
        String greeting = "Hello";
        String myPawPrint = "crsb74";
        
        //Comparing c1 and c2
        if (c1 == c2){
            System.out.println(c1 + " and " + c2 + " are the same.");
        }
        else{
            System.out.println(c1 + " and " + c2 + " are NOT the same.");
        }
        
        //qualityScore
        if (qualityScore >= 0 && qualityScore <= 60){
            System.out.println("The quality is bad.");
        }
        else{
            System.out.println("Good quality.");
        }
        
        //BMI
        double bmi = (weight * 703) / (height * height);
        System.out.printf("My BMI = " + "%.2f\n", bmi);
        
        //sunny and warm outputs
        if (sunny && warm == true){
            System.out.println("Go hiking.");
        }
        else if (sunny == false && warm == true){
            System.out.println("Go barbeque.");
        }
        else{
            System.out.println("Stay home.");
        }
        
        //switch cases for hour and minute
        switch (hour){
            case 5: case 6: case 7: case 8: case 9: case 10:
                System.out.println("The current time is " + hour + ":" + minute + " in the MORNING.");
                break;
            
            case 11: case 12: case 13: case 14: case 15: case 16:
                System.out.println("The current time is " + hour + ":" + minute + " in the AFTERNOON.");
                break;
            
            case 17: case 18: case 19: case 20: case 21: case 22:
                System.out.println("The current time is " + hour + ":" + minute + " in the NIGHT.");
                break;
            
            case 1: case 2: case 3: case 4: case 23:
                System.out.println("You have the wrong time.");
        }
        
        //Counting in a for loop
        for (int count = 3; count <= 9; count++){
            if ( count % 2 == 0){
                System.out.println("Count: " + count);
            }
        }
        
        //Counting using while loop
        int countDown = 3;
        while (countDown > 0){
            System.out.println("Count Down: " + countDown);
            countDown--;
        }
        System.out.println("Houston, we have a lift off!");
        
        //invokeMe() method call
        invokeMe(greeting, myPawPrint);
        System.out.print(dateTime.format(time) + "\n");
    }
    
    //invokeMe() method
    public static void invokeMe(String greeting, String myPawPrint){
        System.out.print(greeting + ", my pawprint is " + myPawPrint + " and today's date is ");
    }
}
