package documenteditor1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class DocumentEditor1 extends Application {
    
    public String title = "Document Editor";
    public int width = 800; 
    public int height = 700;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle(title);
        
        VBox root = new VBox(20); 
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(5);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        
        final ChoiceBox sendTo = new ChoiceBox(
            FXCollections.observableArrayList(
                "To:", "Cc:", "Bcc") 
        );
        
        sendTo.setPrefWidth(100); 
        TextField to = new TextField(); 
        to.setPrefWidth(533); 
        HBox sendToBox = new HBox(10);
        sendToBox.setAlignment(Pos.CENTER_LEFT); 
        sendToBox.getChildren().addAll(sendTo, to); 
        grid.add(sendToBox, 0, 0);
        //add sendToBox to gridPane
        
        Label label = new Label("Subject:"); 
        TextField subject = new TextField(); 
        subject.setPrefColumnCount(45);
        HBox subjectBox = new HBox(10); 
        subjectBox.setAlignment(Pos.CENTER_LEFT);
        subjectBox.getChildren().addAll(label, subject); 
        grid.add(subjectBox, 0, 1); 
        //add subjectBox to gridPane
        
        //add grid to Vbox
        root.getChildren().add(grid); 
        
        //provides typing window
        HTMLEditor editor = new HTMLEditor(); 
        editor.setPrefSize(600, 500);
        root.getChildren().add(editor); 
        
        //send button in bottom right of window
        Button send = new Button("Send"); 
        HBox sendBox = new HBox(10); 
        sendBox.setAlignment(Pos.CENTER_RIGHT); 
        sendBox.getChildren().add(send); 
        root.getChildren().add(sendBox); 
        
        send.setOnAction((ActionEvent) -> {
            System.out.println("Send Button Clicked"); 
        });
       
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }   
}