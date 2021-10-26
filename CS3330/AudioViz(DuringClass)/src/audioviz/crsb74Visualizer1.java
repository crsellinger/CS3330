/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioviz;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Caleb Sellinger
 */
public class crsb74Visualizer1 implements Visualizer{
    
    private String name = "Default";
    
    private Integer numBands;
    private AnchorPane vizPane;
    private String vizPaneInitialStyle = "";
    
    //size of anchor pane
    private Double width = 0.0;
    private Double height = 0.0;

    @Override
    public void start(Integer numBands, AnchorPane vizPane) {
        //makes sure all old objects are destroyed
        end();
        
        vizPaneInitialStyle = vizPane.getStyle();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
    }

    @Override
    public void end() {
        
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
        
    }
    
}
