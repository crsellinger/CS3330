/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditorfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Caleb
 */
public class TextEditorFXMLController implements Initializable {

    @FXML
    private TextArea textArea;
    
    @FXML
    private VBox root;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSave(ActionEvent event) {
        System.out.println(textArea.getText());
    }
    
    @FXML
    public void handleOpen(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        
        Stage stage = (Stage) root.getScene().getWindow();
        
        fileChooser.showOpenDialog(stage);
    }
}

/*
Note: The @FXML annotation is used to tag nonpublic controller member fields and 
    handler methods for use by FXML markup (connection)


    Modil-View-Controller (MVC):

    *FXML file(UI Code) ->View

    *Java class handles the events for UI -> Controller
    
    *Domain Objects (Data), on the java side,
    that ocnnect to the view throught the controller -> Model
*/