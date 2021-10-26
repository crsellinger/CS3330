/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexample;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Professor Wergeles
 */
public class MVCExampleViewController implements Initializable {
    //This class is the controller (middle man)
    
    @FXML
    private VBox root;
    @FXML
    private MenuItem addPerson;
    @FXML
    private MenuItem getEveryone;
    @FXML
    private MenuItem deleteEveryone;
    @FXML
    private MenuItem test;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField; 
    
    private MVCExampleModel model;
    
    //Event listeners below, no other methods should be implemented here
    @FXML
    public void addPersonButton(ActionEvent event){
        //if not empty
        System.out.println("Hello");
        if (!textField.getText().isEmpty()){
            if(model.addPerson(textField.getText())){
                textArea.setText("Person: " + textField.getText() + " added successfully");
            }
            else{
                textArea.setText("Could not add person: " + textField.getText());
            }
        }
        else{
            textArea.setText("Must type person to add person!");
        }
    }
    
    @FXML
    public void getEveryoneButton(ActionEvent event){
        textArea.setText(model.getEveryone().toString());
    }
    
    @FXML
    public void deleteEveryoneButton(ActionEvent event){
        if(model.deleteEveryone()){
            textArea.setText("Everyone was deleted successfully!");
        }
        else{
            textArea.setText("Failed to delete everyone!");
        }
    }
    
    @FXML
    public void test(){
        textArea.setText("Test!");
    }
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new MVCExampleModel();
    }    
    
}
