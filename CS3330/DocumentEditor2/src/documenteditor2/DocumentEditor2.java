/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documenteditor2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Professor Wergeles
 */
public class DocumentEditor2 extends Application {
    
    public String title = "Document Editor 2";
    public int width = 800; 
    public int height = 700; 
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle(title);
        
        VBox root = new VBox(20); 
        
        GridPane grid = new GridPane(); 
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        
        //title of email
        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField(); 
        titleField.setPrefColumnCount(45);
        HBox titleFieldBox = new HBox(10); 
        titleFieldBox.setAlignment(Pos.CENTER_LEFT);
        titleFieldBox.getChildren().addAll(titleLabel, titleField); 
        grid.add(titleFieldBox, 0, 0);
        //adds title to gridPane
        
        //textArea instead of HTML editor
        TextArea editor = new TextArea(); 
        editor.setPrefColumnCount(45); 
        editor.setPrefRowCount(25); 
        grid.add(editor, 0, 1);
        //adds textArea to gridPane
        
        //Menu bar
        MenuBar menuBar = new MenuBar(); 
        Menu fileMenu = new Menu("File"); 
        menuBar.getMenus().add(fileMenu); 
        MenuItem saveMenuItem = new MenuItem("Save"); 
        fileMenu.getItems().add(saveMenuItem); 
        
        saveMenuItem.setOnAction((ActionEvent event) -> {
            
        });
        
        root.getChildren().addAll(menuBar, grid);
        //adds menu bar and gridPane (plus children) to VBox
        
        Scene scene = new Scene(root, width, height); 
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