/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74mvcstopwatchfxmls20;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

/**
 *
 * @author Caleb Sellinger
 */
public class AnalogModel extends AbstractModel{
    
    private double angleDeltaPerSec;
    private double angle;
    
    //Constructor
    public AnalogModel(){
        secondsElapsed = 0.0;
        tickTimeInMillis = 0.001;
        angleDeltaPerSec = 6.0;
    }
    
    @Override
    public void updateMonitor(){
        super.updateMonitor();
        updateAnalog();
    }
    
    public void updateAnalog(){
        double oldAngle = angle; 
        angle = calculateRotation(); 
        
        firePropertyChange("Analog", oldAngle, angle);
    }
    
    public double calculateRotation(){
        secondsElapsed += tickTimeInMillis;
        return secondsElapsed * angleDeltaPerSec;
    }
}
