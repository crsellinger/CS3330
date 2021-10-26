/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74mvcstopwatchfxmls20;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author Caleb Sellinger
 */
public abstract class AbstractModel {
    
    protected KeyFrame keyframe;
    protected Timeline timeline;
    
    protected double secondsElapsed;
    protected double tickTimeInMillis;
    
    protected PropertyChangeSupport propertyChangeSupport;

    public AbstractModel()
    {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
    
    protected void setupMonitor(){
        keyframe = new KeyFrame(Duration.millis(1), (ActionEvent actionEvent) -> {
            updateMonitor();
        });
        timeline = new Timeline(keyframe);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    //Used for digital and analog model subclasses
    protected void updateMonitor(){
        
    }
    
    protected void start(){
        timeline.play();
    }
    
    protected void stop(){
        timeline.pause();
    }
    
    protected void reset(){
        secondsElapsed = 0.0;
    }
    
    protected boolean isRunning(){
        if (timeline != null){
            if (timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        
        return false;
    }
}
