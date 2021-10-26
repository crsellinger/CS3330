/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynewstopwatch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Professor Wergeles
 */
public class MyNewStopWatch extends Application {
    
    private String appName = "New Stopwatch";
    
    @Override
    public void start(Stage primaryStage) {

        AnalogStopWatch clock = new AnalogStopWatch();
        
        Scene scene = new Scene(clock.getRootContainer(), clock.getWidth(), clock.getHeight());
        
        primaryStage.setTitle(appName);
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
