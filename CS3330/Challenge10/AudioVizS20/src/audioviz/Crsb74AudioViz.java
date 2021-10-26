/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioviz;

import static java.lang.Integer.min;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 *
 * @author Professor Wergeles 
 */
public class Crsb74AudioViz implements Visualizer {
    
    private final String name = "Crsb74AudioViz";
    
    private Integer numOfBands;
    private AnchorPane vizPane;
    
    private final Double bandHeightPercentage = 1.3;
    
    private Double width = 0.0;
    private Double height = 0.0;
    
    private Double bandWidth = 0.0;
    private Double bandHeight = 0.0;
    private Double halfBandHeight = 0.0;
    
    private Rectangle[] r1;
    private Rectangle[] r2;
    private Rectangle[] r3;
    private Rectangle[] r4;
    
    private BoxBlur blur = new BoxBlur();
    
    public Crsb74AudioViz() {
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void start(Integer numBands, AnchorPane vizPane) {
        end();
        
        this.numOfBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
        
        bandWidth = (width/2) / numBands;
        bandHeight = height * bandHeightPercentage;
        halfBandHeight = bandHeight / 2;
        
        r1 = new Rectangle[numBands];
        r2 = new Rectangle[numBands];
        r3 = new Rectangle[numBands];
        r4 = new Rectangle[numBands];
        
        //rotation for rectangles to top of visualizer
        Rotate reflectRectangles = new Rotate();
        reflectRectangles.setAngle(180);
        reflectRectangles.setPivotX((bandWidth/1.1)/2);
        reflectRectangles.setPivotY(0);
        
        //flip right half of visualizer to make it symmetric
        Rotate midRotation = new Rotate();
        midRotation.setAngle(180);
        midRotation.setPivotX(width/2);
        midRotation.setPivotY(0);
        
        //Shift for right half of visualizer
        Translate shift = new Translate();
        shift.setX(width/2);
        shift.setY(0);
        
        for (int i = 0; i < numBands; i++) {
            
            Rectangle bottomRectangle = new Rectangle();
            Rectangle topRectangle = new Rectangle();
            Rectangle rightTopRectangle = new Rectangle();
            Rectangle rightBottomRectangle = new Rectangle();
            
            //first set of rectangles
            bottomRectangle.setLayoutX(bandWidth / 2 + bandWidth * i);
            bottomRectangle.setLayoutY(height / 2);
            bottomRectangle.setHeight(10);
            bottomRectangle.setWidth(bandWidth/1.1);
            bottomRectangle.setFill(Color.hsb(260, 1.0, 1.0, 1.0));
            //second set of rectangles
            topRectangle.setLayoutX(bandWidth / 2 + bandWidth * i);
            topRectangle.setLayoutY(height / 2);
            topRectangle.setHeight(10);
            topRectangle.setWidth(bandWidth/1.1);
            topRectangle.setFill(Color.hsb(300, 1.0, 1.0, 1.0));
            topRectangle.getTransforms().add(reflectRectangles);
            //third set of rectangles
            rightBottomRectangle.setLayoutX(bandWidth / 2 + bandWidth * i);
            rightBottomRectangle.setLayoutY(height / 2);
            rightBottomRectangle.setHeight(10);
            rightBottomRectangle.setWidth(bandWidth/1.1);
            rightBottomRectangle.setFill(Color.hsb(180, 1.0, 1.0, 1.0));
            rightBottomRectangle.getTransforms().addAll(shift);
            //fourth set of rectangles
            rightTopRectangle.setLayoutX(bandWidth / 2 + bandWidth * i);
            rightTopRectangle.setLayoutY(height / 2);
            rightTopRectangle.setHeight(10);
            rightTopRectangle.setWidth(bandWidth/1.1);
            rightTopRectangle.setFill(Color.hsb(150, 1.0, 1.0, 1.0));
            rightTopRectangle.getTransforms().addAll(shift, reflectRectangles);
            
            vizPane.getChildren().add(topRectangle);
            vizPane.getChildren().add(bottomRectangle);
            vizPane.getChildren().add(rightTopRectangle);
            vizPane.getChildren().add(rightBottomRectangle);
            
            //left side
            r1[i] = bottomRectangle;
            r2[i] = topRectangle;
            
            //right side
            r3[i] = rightBottomRectangle;
            r4[i] = rightTopRectangle;
        }

    }
    
    @Override
    public void end() {
        if (r1 != null) {
             for (Rectangle newRectangle : r1) {
                 vizPane.getChildren().remove(newRectangle);
             }
            r1 = null;
        }
        if (r2 != null) {
             for (Rectangle newRectangle : r2) {
                 vizPane.getChildren().remove(newRectangle);
             }
            r2 = null;
        }
        if (r3 != null) {
             for (Rectangle newRectangle : r3) {
                 vizPane.getChildren().remove(newRectangle);
             }
            r3 = null;
        }
        if (r4 != null) {
             for (Rectangle newRectangle : r4) {
                 vizPane.getChildren().remove(newRectangle);
             }
            r4 = null;
        }
    }
    
    @Override
    public void draw(double timestamp, double lenght, float[] magnitudes, float[] phases) {
        if (r1 == null) {
            return;
        }
        
        Integer num = min(r1.length, magnitudes.length);
        
        for (int i = 0, j = num-1; i < num && j >= 0; i++, j--) {
            r1[i].setHeight(((60.0 + magnitudes[i])/60.0) * halfBandHeight + 10);
            //each array of rectangles should be the same so I didn't write
            //separate for loops
            r2[i].setHeight(((60.0 + magnitudes[i])/60.0) * halfBandHeight + 10);
            r3[j].setHeight(((60.0 + magnitudes[i])/60.0) * halfBandHeight + 10);
            r4[j].setHeight(((60.0 + magnitudes[i])/60.0) * halfBandHeight + 10);
            
            //if a rectangle is not being used in the visualizer, make it invisible
            if (r1[i].getHeight() == 10){
                r1[i].setVisible(false);
            }
            else{
                r1[i].setVisible(true);
            }
            if (r2[i].getHeight() == 10){
                r2[i].setVisible(false);
            }
            else{
                r2[i].setVisible(true);
            }
            if (r3[j].getHeight() == 10){
                r3[j].setVisible(false);
            }
            else{
                r3[j].setVisible(true);
            }
            if (r4[j].getHeight() == 10){
                r4[j].setVisible(false);
            }
            else{
                r4[j].setVisible(true);
            }
        }
    }
}
