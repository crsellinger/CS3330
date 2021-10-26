/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynewstopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles
 */
public class AnalogStopWatch {
    //animation
    private Timeline timeline;
    private KeyFrame keyframe;
    
    //images
    private ImageView dialImageView;
    private ImageView handImageView;
    private StackPane root;
    private Image dialImage;
    private Image handImage;
    private String dialImageName = "clockface.png";
    private String handImageName = "hand.png";
    
    //stopwatch algorithm
    private double secondsElapsed = 0.0;
    private double tickTimeInSecs = 1; //how to change the resolution
    private double angleDeltaPerSec = 6.0;
    
    //Constructors
    public AnalogStopWatch(){
        secondsElapsed = 0.0;
        tickTimeInSecs = 1.0;
        angleDeltaPerSec = 6.0;
        
        setupUI();
        setupTimer();
    }
    
//    public AnalogStopWatch(){
//        
//    }
    
    public void setupUI(){
        //root node
        root = new StackPane();
        
        //Images on the display
        dialImageView = new ImageView();
        handImageView = new ImageView();
        root.getChildren().addAll(dialImageView, handImageView);
        
//        Image test = new Image(getClass().getResourceAsStream("giphy.gif")); //relative file path based on machine
//        Image dialImage = new Image(getClass().getResourceAsStream("clockface.png"));
//        Image handImage = new Image(getClass().getResourceAsStream("hand.png"));
        
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));

        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        //buttons
        VBox buttonControls = new VBox();
        Button startStop = new Button("Start");
        Button lapReset = new Button("Stop");
        startStop.setMaxWidth(Double.MAX_VALUE);
        lapReset.setMaxWidth(Double.MAX_VALUE);
        buttonControls.setAlignment(Pos.BOTTOM_CENTER);
        buttonControls.getChildren().addAll(lapReset, startStop);
        root.getChildren().addAll(buttonControls);
        
        //puts buttons on top of stack
        buttonControls.toFront();
        
        //Event listeners
        //start and stop button
        startStop.setOnAction((ActionEvent event) -> {
            if (isRunning()){
                timeline.pause();
                startStop.setText("Start");
            }
            else {
                timeline.play();
                startStop.setText("Stop");
            }
        });
        
        //some other button
        lapReset.setOnAction((ActionEvent event) -> {
            timeline.pause();
        });
    }
    
    public void setupTimer(){
        //Every 1s, lambda expression is called
        keyframe = new KeyFrame(Duration.millis(1000), (ActionEvent actionEvent) -> {
            System.out.println("Timeline event!");
            
            secondsElapsed += tickTimeInSecs;
            double rotation = secondsElapsed * angleDeltaPerSec;
            
            handImageView.setRotate(rotation);
        });
        
        timeline = new Timeline(keyframe);
        
        //actionEvent
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    public boolean isRunning(){
        if (timeline != null){
            if (timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        
        return false;
    }
    
    public Parent getRootContainer(){   //Parent superclass allows subclass to inherent StackPane, VBox, etc.
        return root;
    }
    
    public Double getWidth(){   //Our method name for our object
        if (dialImage != null){
            return dialImage.getWidth();//Library method name for general objects
        }
        else {
            return 0.0;
        }
    }
    
    public Double getHeight(){   //Our method name for our object
        if (dialImage != null){
            return dialImage.getHeight();//Library method name for general objects
        }
        else {
            return 0.0;
        }
    }
    
    public void start(){
        timeline.play();
    }
    
    public void setTIckInSeconds(Double tickTimeInSecs){
        this.tickTimeInSecs = tickTimeInSecs;
        setupTimer();   //Necessary to from different class
    }
}
