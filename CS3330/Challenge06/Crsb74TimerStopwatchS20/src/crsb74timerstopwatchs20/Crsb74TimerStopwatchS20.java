/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74timerstopwatchs20;

import static java.lang.Math.floor;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Caleb
 */
public class Crsb74TimerStopwatchS20 extends Application {
    
    private Timeline timeline;
    
    //vars for timer and lap
    private double timerStartTime = 60000; //in millis
    private double timerCountDown = 1;  //So that it will go through the if statement at least once on line 141
    private double recordTime = 0.0;
    private double lastRecordedTime = 0.0;
    private int recordCount = 0;
    
    //stopwatch algorithm
    private double secondsElapsed = 0.0;
    private double tickTimeInMillis = 0.001; //how to change the resolution
    private double angleDeltaPerSec = 6.0;
    private double rotation = 0.0;
    
    //digital clock
    private double millis = 0.0;
    private double seconds = 0.0;
    private double min = 0.0;
    private int clockElapsedCountForMillis = 0;
    private int clockElapsedCountForMin = 0;
    private int clockElapsedCountForSec = 0;
    
    @Override
    public void start(Stage primaryStage) {
        //stage
        GridPane root = new GridPane();
        StackPane analogNode = new StackPane();
        
        //Alert Window
        Alert alertWindow = new Alert(AlertType.WARNING);
        
        //format for timers
        NumberFormat noDecimalPlace = new DecimalFormat("#00");
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        
        //images
        ImageView dialImageView = new ImageView();
        ImageView handImageView = new ImageView();
        String dialImageName = "clockface.png";
        String handImageName = "hand.png";
        
        Image dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        Image handImage = new Image(getClass().getResourceAsStream(handImageName));
        
        //adds dial and hand image to stack pane node
        analogNode.getChildren().addAll(dialImageView, handImageView);
        
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        //adds stackpane node to root node
        root.add(analogNode, 1, 0);
        
        //Digital display
        Label digitalClock = new Label("00min\n00s\n00cs");
        digitalClock.setFont(Font.font("Times", FontWeight.BOLD, 22));
        digitalClock.setPrefWidth(75);
        root.add(digitalClock, 0, 0);
        
        Label timer = new Label("Timer:  ");
        timer.setFont(Font.font("Times", FontWeight.BOLD, 18));
        timer.setPrefWidth(75);
        timer.setAlignment(Pos.CENTER_RIGHT);
        root.add(timer, 0, 1);
        
        Label timerTime = new Label();
        timerTime.setFont(Font.font("Times", FontWeight.BOLD, 18));
        timerTime.setText(sdf.format(timerStartTime));//In millis to show 60 seconds when started
        root.add(timerTime, 1, 1);
        
        Label lap = new Label("Lap:  ");
        lap.setFont(Font.font("Times", FontWeight.BOLD, 18));
        lap.setPrefWidth(75);
        lap.setAlignment(Pos.CENTER_RIGHT);
        root.add(lap, 0, 2);
        
        Label lapTime = new Label();
        lapTime.setFont(Font.font("Times", FontWeight.BOLD, 18));
        lapTime.setText(sdf.format(0));
        root.add(lapTime, 1, 2);
        
        //buttons
        VBox buttonControls = new VBox();
        Button startStop = new Button("Start");
        Button recordReset = new Button("Record");
        startStop.setPrefWidth(100);
        recordReset.setPrefWidth(100);
        buttonControls.setAlignment(Pos.BOTTOM_CENTER);
        buttonControls.getChildren().addAll(startStop, recordReset);
        root.add(buttonControls, 0, 3, 2, 1);
        
        KeyFrame keyframe = new KeyFrame(Duration.millis(1), (ActionEvent actionEvent) -> {
            secondsElapsed += tickTimeInMillis;
            rotation = secondsElapsed * angleDeltaPerSec;
            handImageView.setRotate(rotation);
            millis = floor(secondsElapsed * 100) - (clockElapsedCountForMillis * 100);
            seconds = floor(secondsElapsed) - (clockElapsedCountForSec * 60);
            min = floor(secondsElapsed/60) - (clockElapsedCountForMin * 60);
            digitalClock.setText(noDecimalPlace.format(min) +"min\n" + noDecimalPlace.format(seconds)
                    + "s\n" + noDecimalPlace.format(millis) + "cs");
            if (millis >= 100.0){
                ++clockElapsedCountForMillis;
            }
            if (seconds >= 60.0){
                ++clockElapsedCountForSec;
            }
            if (min >= 60.0){
                ++clockElapsedCountForMin;
            }
            
            //put timerCountDown inside so we dont have to keep track of it forever
            if (timerCountDown > 0){
                timerCountDown = timerStartTime - secondsElapsed * 1000;
                timerTime.setText(sdf.format(timerCountDown));
            }
            if (timerCountDown < 0){
                alertWindow.setContentText("You have " + recordCount + " records in 60 seconds!");
                alertWindow.show();
                timeline.pause();
                startStop.setText("Start");
                recordReset.setText("Reset");
                timerCountDown = 0;
            }
        });
        
        timeline = new Timeline(keyframe);
        timeline.setCycleCount(Animation.INDEFINITE);
        
        //Actions when buttons are clicked
        startStop.setOnAction((ActionEvent event) -> {
            if (isRunning() == false){  //Start
                timeline.play();
                startStop.setText("Stop");
                recordReset.setText("Record");
            }
            else {  //Stop
                timeline.pause();
                startStop.setText("Start");
                recordReset.setText("Reset");
            }
        });
        
        recordReset.setOnAction((ActionEvent event) -> {
            if (isRunning() == false){      //Reset
                recordReset.setText("Record");
                secondsElapsed = 0.0;
                recordCount = 0;
                clockElapsedCountForMillis = 0;
                clockElapsedCountForSec = 0;
                clockElapsedCountForMin = 0;
                timerCountDown = 1;
                handImageView.setRotate(0);
                lapTime.setText(sdf.format(0));
                timerTime.setText(sdf.format(timerStartTime));
                digitalClock.setText("00min\n00s\n00cs");
            }
            else{   //Record
                recordTime = (secondsElapsed * 1000) - lastRecordedTime;
                //multiplying by 1000 puts it in millis
                recordCount += 1;
                lapTime.setText(sdf.format(recordTime));
            }
            
            lastRecordedTime = secondsElapsed * 1000;
        });
        
        double width = root.getPrefWidth();
        double height = root.getPrefHeight();
        
        Scene scene = new Scene(root, width, height);
        
        primaryStage.setTitle("Crsb74 Stopwatch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean isRunning(){
        if (timeline != null){
            if (timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        
        return false;
    }
}