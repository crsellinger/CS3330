/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74fxmlcpumonitors20;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Caleb Sellinger
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label digitalRead;
    
    @FXML
    private Button startStop;
    
    @FXML
    private Button recordReset;
    
    @FXML
    private ImageView hand;
    
    private Timeline timeline;
    private KeyFrame keyframe;
    
    private double handAngle = 0.0;
    
    @FXML
    private LineChart<String, Number> lineChart;
    private XYChart.Series<String, Number> log = new XYChart.Series();
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    
    NumberFormat format = new DecimalFormat("#00.00");
    
    private int recordCount = 0;
    
    @FXML
    private void startStopButton(ActionEvent event){
        
        if (isRunning() == false){  //Start
            keyframe = new KeyFrame(Duration.millis(10), (ActionEvent actionEvent) -> {
            digitalRead.setText(format.format((this.getCPUUsage()) * 100) + "%");
            handAngle = this.getCPUUsage() * 304;
            hand.setRotate(handAngle - 152);
            });
            
            timeline = new Timeline(keyframe);
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
            startStop.setText("Stop");
            recordReset.setText("Record");
        }
        else {  //Stop
            timeline.stop();
            startStop.setText("Start");
            recordReset.setText("Reset");
        }
    }
    
    @FXML
    private void recordResetButton(ActionEvent event){
        if (isRunning() == false){  //Reset
            recordReset.setText("Record");
            hand.setRotate(-152);
            recordCount = 0;
            digitalRead.setText("00.00%");
            log.getData().clear();
        }
        else{   //Record
            recordCount += 1;
            log.getData().add(new XYChart.Data(Integer.toString(recordCount), (this.getCPUUsage()*100)));
        }
    }
    
    public boolean isRunning(){
        if (timeline != null){
            if (timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        return false;
    }
    
    public double getCPUUsage() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        double value = 0;
        
        for(Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            
            if (method.getName().startsWith("getSystemCpuLoad") && Modifier.isPublic(method.getModifiers())) {
                try {
                    value = (double) method.invoke(operatingSystemMXBean);
                } catch (Exception e) {
                    value = 0;
                }
                return value;
            }
        }
        return value;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);
        lineChart.getData().add(log);
        lineChart.setAnimated(false);
    }    
    
}
