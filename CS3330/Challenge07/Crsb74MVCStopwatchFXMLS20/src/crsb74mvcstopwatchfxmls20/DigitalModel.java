/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74mvcstopwatchfxmls20;

import static java.lang.Math.floor;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author Caleb Sellinger
 */
public class DigitalModel extends AbstractModel{
    
    private double millis;
    private double seconds;
    private double min;
    private int clockElapsedCountForMillis;
    private int clockElapsedCountForMin;
    private int clockElapsedCountForSec;
    
    private String newString;
    
    //Constructor
    public DigitalModel(){
        millis = 0.0;
        seconds = 0.0;
        min = 0.0;
        clockElapsedCountForMillis = 0;
        clockElapsedCountForSec = 0;
        clockElapsedCountForMin = 0;
        secondsElapsed = 0.0;
        tickTimeInMillis = 0.001;
    }
    
    @Override
    public void updateMonitor(){
        super.updateMonitor();
        updateDigital();
    }
    
    public void updateDigital(){
        String oldString = newString;
        newString = getDigitalString();
        
        firePropertyChange("Digital", oldString, newString);
    }
    
    public String getDigitalString(){
        NumberFormat noDecimalPlace = new DecimalFormat("#00");
        secondsElapsed += tickTimeInMillis;
        millis = floor(secondsElapsed * 100) - (clockElapsedCountForMillis * 100);
        seconds = floor(secondsElapsed) - (clockElapsedCountForSec * 60);
        min = floor(secondsElapsed/60) - (clockElapsedCountForMin * 60);
        
        if (millis >= 100.0){
                ++clockElapsedCountForMillis;
        }
        if (seconds >= 60.0){
                ++clockElapsedCountForSec;
        }
        if (min >= 60.0){
                ++clockElapsedCountForMin;
        }
        
        return noDecimalPlace.format(min) +" min\n" + noDecimalPlace.format(seconds)
                    + " s\n" + noDecimalPlace.format(millis) + " cs";
    }
    
    @Override
    public void reset(){
        super.reset();
        clockElapsedCountForMillis = 0;
        clockElapsedCountForSec = 0;
        clockElapsedCountForMin = 0;
    }
}
