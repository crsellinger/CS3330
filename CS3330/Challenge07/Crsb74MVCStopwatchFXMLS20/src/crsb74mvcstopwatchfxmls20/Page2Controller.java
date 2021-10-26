/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74mvcstopwatchfxmls20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Caleb Sellinger
 */
public class Page2Controller implements Initializable {

    @FXML
    private TextArea textArea;
    
    private AboutModel page2;
    
    @FXML
    private void backButton(ActionEvent event) throws IOException{
        Parent aboutPageParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene aboutPageScene = new Scene(aboutPageParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(aboutPageScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        page2 = new AboutModel("ProjectDocumentation.txt");
        textArea.setText(page2.loadFile());
    }
    
}
