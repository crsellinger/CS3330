/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74gradecalculators20;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Caleb Sellinger
 */
public class Crsb74GradeCalculatorS20 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grade Calculator");
                
        //Grid
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));
        
        //Labels
        Label assignment = new Label("Assignment (40%): ");
        assignment.setMinWidth(110);
        root.add(assignment, 0, 0);
        
        Label exam = new Label("Exam (40%): ");
        exam.setMinWidth(110);
        root.add(exam, 0, 1);
        
        Label finalProject = new Label("Final Project (20%): ");
        finalProject.setMinWidth(110);
        root.add(finalProject, 0, 2);
        
        Label finalScore = new Label("Final Score: ");
        finalScore.setMinWidth(110);
        root.add(finalScore, 0, 3);
        
        //Text fields
        TextField score1 = new TextField();
        score1.setPrefWidth(300);
        root.add(score1, 1, 0);
        
        TextField score2 = new TextField();
        score2.setPrefWidth(300);
        root.add(score2, 1, 1);
        
        TextField score3 = new TextField();
        score3.setPrefWidth(300);
        root.add(score3, 1, 2);
        
        //Text area
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(2);
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setPrefWidth(300);
        root.add(textArea, 1, 3);
        
        //Buttons
        HBox allButtons = new HBox(10);
        allButtons.setSpacing(15);
        allButtons.setPadding(new Insets(10, 0, 10, 0));
        
        Button calculate = new Button("Calculate");
//        HBox calculateHbox = new HBox(10);
//        calculateHbox.setSpacing(15);
//        calculateHbox.setPadding(new Insets(10, 0, 10, 0));
        calculate.setMinWidth(80);
//        calculateHbox.getChildren().add(calculate);
//        root.add(calculateHbox, 0, 4, 2, 1);
        
        Button fullScore = new Button("Full Score");
//        HBox fullScoreHbox = new HBox(10);
//        fullScoreHbox.setSpacing(15);
//        fullScoreHbox.setPadding(new Insets(10, 0, 10, 0));
        fullScore.setMinWidth(80);
//        fullScoreHbox.getChildren().add(fullScore);
//        root.add(fullScoreHbox, 0, 4, 2, 1);
        
        Button clear = new Button("Clear");
//        HBox clearHbox = new HBox(10);
//        clearHbox.setSpacing(15);
//        clearHbox.setPadding(new Insets(10, 0, 10, 0));
        clear.setMinWidth(80);
//        clearHbox.getChildren().add(clear);
//        root.add(clearHbox, 0, 4, 2, 1);
        
        Button alert = new Button("Alert!");
//        HBox alertHbox = new HBox(10);
//        alertHbox.setSpacing(15);
//        alertHbox.setPadding(new Insets(10, 0, 10, 0));
        alert.setMinWidth(80);
//        alertHbox.getChildren().add(alert);
//        root.add(alertHbox, 0, 4, 2, 1);
        
        allButtons.setAlignment(Pos.BASELINE_CENTER);
        allButtons.getChildren().addAll(calculate, fullScore, clear, alert);
        root.add(allButtons, 0, 4, 2, 1);
        
        //if calculate button is pressed
        calculate.setOnAction((ActionEvent e) -> {
            double finalValue = Integer.parseInt(score1.getText()) * 0.4 + Integer.parseInt(score2.getText()) * 0.4
                    + Integer.parseInt(score3.getText()) * 0.2;
            DecimalFormat decFormat = new DecimalFormat("#.##");
            textArea.setText("My final score should be " + finalValue);
        });
        
        //if fullScore button is pressed
        fullScore.setOnAction((ActionEvent f) -> {
            score1.setText("100");
            score2.setText("100");
            score3.setText("100");
        });
        
        //if clear button is pressed
        clear.setOnAction((ActionEvent g) -> {
            score1.setText("");
            score2.setText("");
            score3.setText("");
            textArea.setText("");
        });
        
        //if alert button is pressed
        alert.setOnAction((ActionEvent h) -> {
            Alert alertBox = new Alert(AlertType.CONFIRMATION, textArea.getText());
            alertBox.show();
        });
        
        
        //Scene
        Scene scene = new Scene(root, 500, 300); 
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
