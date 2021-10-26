/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcstopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class StopwatchModel {
    //pulled from Controller origianlly,
    //all code in the model should be data used for the view
    private double tickTimeInSeconds;
    private double angleDeltaPerSeconds;
    
    private double secondsElapsed;
    
    private Timeline timeline;
    private KeyFrame keyframe;
    
    //Constructor
    public StopwatchModel(){
        tickTimeInSeconds = 0.01;
        angleDeltaPerSeconds = 6.0;
        secondsElapsed = 0.0;
    }
    
    public void setupTimer(KeyFrame keyframe) {
        this.keyframe = keyframe;
        timeline = new Timeline(keyframe);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    public double calculateRotation() {
        secondsElapsed += tickTimeInSeconds;
        return secondsElapsed * angleDeltaPerSeconds;
        //Breaks MVC architecture
//        handImageView.setRotate(rotation);
    }
    
    public void start() {
        timeline.play();
    }
    
    public void setTickTimeInSeconds(Double tickTimeInSeconds) {
        this.tickTimeInSeconds = tickTimeInSeconds;
        setupTimer(keyframe);
    }
    
    public double getTickTimeInSeconds(){
        return tickTimeInSeconds;
    }
}
