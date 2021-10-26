/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74mvcstopwatchfxmls20;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Caleb Sellinger
 */
public class FXMLDocumentController implements Initializable, PropertyChangeListener {
    
    @FXML
    private ImageView hand;
    
    @FXML
    private Label digitalClock;
    
    @FXML
    private Label recordedTime;
    
    @FXML
    private Button startStop;
    
    @FXML
    private Button recordReset;
    
    @FXML
    private Button about;
    
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    
    private String record;
    
    private AnalogModel analogModel;
    private DigitalModel digitalModel;
    private RecordModel recordModel;
    
    @FXML
    private void startStopButton(ActionEvent event){
        
        if (digitalModel.isRunning() == false){  //Start
            analogModel.start();
            digitalModel.start();
            recordModel.start();
            startStop.setText("Stop");
            recordReset.setText("Record");
        }
        else {  //Stop
            analogModel.stop();
            digitalModel.stop();
            recordModel.stop();
            startStop.setText("Start");
            recordReset.setText("Reset");
        }
    }
    
    @FXML
    private void recordReset(ActionEvent event){
        
        if (digitalModel.isRunning() == false){      //Reset
                recordReset.setText("Record");
                hand.setRotate(0);
                analogModel.reset();
                digitalModel.reset();
                recordModel.reset();
                digitalClock.setText("00 min\n00 s\n00 cs");
                recordedTime.setText("00:00.00");
            }
            else{   //Record
                recordedTime.setText(record);
                recordModel.plotGraph();
            }
        recordModel.setLastRecordedTime();
    }
    
    @FXML
    private void aboutButton(ActionEvent event) throws IOException{
        
        Parent aboutPageParent = FXMLLoader.load(getClass().getResource("Page2.fxml"));
        Scene aboutPageScene = new Scene(aboutPageParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(aboutPageScene);
        window.show();
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("Analog")){
            //gets value from model and updates view
            hand.setRotate((double)evt.getNewValue());
        }
        else if (evt.getPropertyName().equals("Digital")){
            digitalClock.setText(evt.getNewValue().toString());
        }
        else if (evt.getPropertyName().equals("Record")){
            record = evt.getNewValue().toString();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        analogModel = new AnalogModel();
        digitalModel = new DigitalModel();
        recordModel = new RecordModel();
        
        lineChart.getData().add(recordModel.getLog());
        yAxis.setAutoRanging(true);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(10);
        lineChart.setAnimated(false);
        
        analogModel.setupMonitor();
        digitalModel.setupMonitor();
        recordModel.setupMonitor();
        
        analogModel.addPropertyChangeListener(this);
        digitalModel.addPropertyChangeListener(this);
        recordModel.addPropertyChangeListener(this);
    }    
}