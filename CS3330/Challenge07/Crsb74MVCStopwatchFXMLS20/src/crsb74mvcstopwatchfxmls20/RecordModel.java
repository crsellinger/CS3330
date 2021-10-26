/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74mvcstopwatchfxmls20;

import java.text.SimpleDateFormat;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Caleb Sellinger
 */
public class RecordModel extends AbstractModel{
    
    private double recordTime;
    private double lastRecordedTime;
    private int recordCount;
    
    private XYChart.Series<String, Number> log;
    
    private String newRecord;
    
    public RecordModel(){
        log = new XYChart.Series();
        recordTime = 0.0;
        lastRecordedTime = 0.0;
        recordCount = 0;
        secondsElapsed = 0.0;
        tickTimeInMillis = 0.001;
    }
    
    @Override
    public void updateMonitor(){
        super.updateMonitor();
        updateRecord();
    }
    
    public void updateRecord(){
        String oldRecord = newRecord;
        newRecord = getRecordString();
        
        firePropertyChange("Record", oldRecord, newRecord);
    }
    
    public String getRecordString(){
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SS");
        secondsElapsed += tickTimeInMillis;
        recordTime = (secondsElapsed * 1000) - lastRecordedTime;
        
        return sdf.format(recordTime);
    }
    
    public void setLastRecordedTime(){
        this.lastRecordedTime = secondsElapsed * 1000;
        recordCount += 1;
    }
    
    public XYChart.Series<String, Number> getLog(){
        return log;
    }
    
    public void plotGraph(){
        log.getData().add(new XYChart.Data(Integer.toString(recordCount), recordTime/1000));
    }
    
    @Override
    public void reset(){
        super.reset();
        recordCount = 0;
        lastRecordedTime = 0.0;
        log.getData().clear();
    }
}