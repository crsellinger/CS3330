/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author dalemusser
 */
public class MyStopWatch extends Application {
    
    //class fields
    
    //animation
    public Timeline timeline;
    public KeyFrame keyframe;
    
    //images
    public ImageView dialImage;
    public ImageView handImage;
    
    //stopwatch algorithm
    public double secondsElapsed = 0.0;
    public double tickTimeInSecs = 1; //how to change the resolution
    public double angleDeltaPerSec = 6.0;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("StopWatch");
        
        //root node
        StackPane root = new StackPane();
        
        //Images on the display
        ImageView dialImageView = new ImageView();
        ImageView handImageView = new ImageView();
        root.getChildren().addAll(dialImageView, handImageView);
        
//        Image test = new Image(getClass().getResourceAsStream("giphy.gif")); //relative file path based on machine
//        Image dialImage = new Image(getClass().getResourceAsStream("clockface.png"));
//        Image handImage = new Image(getClass().getResourceAsStream("hand.png"));
        
        Image dialImage = new Image(getClass().getResourceAsStream("clockface.png"));
        Image handImage = new Image(getClass().getResourceAsStream("hand.png"));

        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        //buttons
        VBox buttonControls = new VBox();
        Button start = new Button("Start");
        Button stop = new Button("Stop");
        start.setMaxWidth(Double.MAX_VALUE);
        stop.setMaxWidth(Double.MAX_VALUE);
        buttonControls.setAlignment(Pos.BOTTOM_CENTER);
        buttonControls.getChildren().addAll(stop, start);
        root.getChildren().add(buttonControls);
        
        //Event listeners
        //start and stop button
        start.setOnAction((ActionEvent event) -> {
            if (isRunning()){
                timeline.pause();
                start.setText("Start");
            }
            else {
                timeline.play();
                start.setText("Stop");
            }
        });
        
        //some other button
        stop.setOnAction((ActionEvent event) -> {
            timeline.pause();
        });
        
        //Every 1s, lambda expression is called
        KeyFrame keyframe = new KeyFrame(Duration.millis(1000), (ActionEvent actionEvent) -> {
            System.out.println("Timeline event!");
            
            secondsElapsed += tickTimeInSecs;
            double rotation = secondsElapsed * angleDeltaPerSec;
            
            handImageView.setRotate(rotation);
        });
        
        timeline = new Timeline(keyframe);
        
        //actionEvent
        timeline.setCycleCount(Animation.INDEFINITE);
        //timeline.play();
        
        double width = dialImage.getWidth();
        double height = dialImage.getHeight() + buttonControls.getHeight();
        
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
        
    }
    
    public boolean isRunning(){
        if (timeline != null){
            if (timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}