 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvccpumonitorfxml;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class Controller implements Initializable, PropertyChangeListener {  //PropertyChangeListener is the first requirement for firePropertyChange
    
    //Do NOT use getter or setter in the Controller
    
    @FXML
    private Text cpuLabel;
    @FXML
    private ImageView hand;
    @FXML
    private Button startStopButton;

    Model model; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //used to set the program up at start time
        model = new Model(); 
        model.setupMonitor(); 
        hand.setRotate(0);
        cpuLabel.setText("00.00%");
        //Third requirement for firePropertyChange
        model.addPropertyChangeListener(this);  //links model and controller
    }

    @FXML
    public void startStopMonitor(ActionEvent event) {
        if ( !(model.isRunnning())) {
            model.start();
            startStopButton.setText("Stop");
        } else {
            model.stop();
            startStopButton.setText("Start");
        }
    }
    
    //Second requirement for firePropertyChange
    //listens for events
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        if (evt.getPropertyName().equals("Analog")){
            //gets value from model and updates view
            hand.setRotate((double)evt.getNewValue());
        }
        else if (evt.getPropertyName().equals("Digital")){
            cpuLabel.setText(evt.getNewValue().toString() + "%");
        }
        //and an else if for laps and timer
    }
}
