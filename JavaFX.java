import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

public class JavaFX
{
    private static TextField txtFieldMessage;
    
    public static void main (String[] args)
    {
        launchFX();
    }
    
    private static void launchFX()
    {
        //initialises JavaFX
        new JFXPanel();
        
        //runs initialisation on the JavaFX thread
        Platform.runLater(() -> initialiseGUI());
    }
    
    private static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("My First GUI");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(720);
        stage.setHeight(720);
        stage.show();
        
        Button btn = new Button();
        btn.setText("Try Me!");
        btn.setLayoutX(350);
        btn.setLayoutY(350);
        btn.setOnAction((ActionEvent ae) -> printMessage());
        rootPane.getChildren().add(btn);
        
        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(160);
        txtFieldMessage.setLayoutY(250);
        txtFieldMessage.setPrefWidth(400);
        txtFieldMessage.setPromptText("Enter your message");
        rootPane.getChildren().add(txtFieldMessage);
        
        
    }
    
    private static void printMessage()
    {
        System.out.println("You are cool!");
    }
}
