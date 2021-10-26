/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvccpumonitorfxml;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DecimalFormat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class Model extends AbstractModel{ 
    
    private Timeline timeline;
    private KeyFrame keyFrame;
    
    private double tickTimeInSeconds; //Change resolution
    private double cpu;
    private double angle; 
    private String cpuString; 
    
    public Model(){
        tickTimeInSeconds = 0.1;
        cpu = 0;
    }
    
    public void setupMonitor() {    //changed from private to public so controller can access it    
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
                updateMonitor(); 
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
          
    private void updateMonitor() {
        double cpu = getCpu();
        updateAnalog(cpu);  //added in class
        updateDigital(cpu); //added in class
        //hand.setRotate(model.calculateRotation(cpu));
        //cpuLabel.setText(model.getCPUString(cpu) + "%");
    }
   
    public void updateAnalog(double cpu){
        double oldAngle = angle; 
        angle = calculateRotation(cpu); 
        
        //sends update to controller to notify view
        firePropertyChange("Analog", oldAngle, angle);
    }
    public void updateDigital(double cpu){
        String oldString = cpuString; 
        cpuString = getCPUString(cpu);
        
        firePropertyChange("Digital", oldString, cpuString);
    }
    
    public String getCPUString(double cpu) {
        DecimalFormat formatter = new DecimalFormat("00.00");
        return formatter.format(cpu * 100);
    }
    
    public double calculateRotation(double cpu){ 
        return cpu * 360;
    }
    
    public void start() {
        timeline.play();
    }
    
    public void stop() {
        timeline.stop();
    }
    
    public void reset() {
        timeline.stop();
        cpu = 0.0; 
    }
    
    public double getCpu(){
        cpu = getCPUUsage(); 
        return cpu; 
    }
    
    public Timeline getTimeLine(){
        return timeline; 
    }
    public void setTimeLine(Timeline timeline){
        this.timeline = timeline; 
    }
    public KeyFrame getKeyFrame(){
        return keyFrame; 
    }
    public void setKeyFrame(KeyFrame keyFrame){
        this.keyFrame = keyFrame; 
    }
    public double getTickTimeInSeconds(){
        return tickTimeInSeconds; 
    }
    
    public boolean isRunnning(){
        if(timeline != null){
            if(timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        return false;
    }
        
    private static double getCPUUsage() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        double value = 0;
        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getName().startsWith("getSystemCpuLoad")
                    && Modifier.isPublic(method.getModifiers())) {
                try {
                    value = (double) method.invoke(operatingSystemMXBean);
                } catch (Exception e) {
                    value = 0;
                }
                
                if(Double.isNaN(value)) value = Math.random(); 
                
                return value;
            }
        }
        return value;
    } 
}