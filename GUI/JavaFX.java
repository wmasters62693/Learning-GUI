import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JavaFX
{
    private static TextField txtFieldRanking;
    private static TextField txtFieldName;
    private static TextField txtFieldCountry;
    
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
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.setTitle("Top Universitys By William Masters");
        stage.show();
        
        int paddingL = 30;
        int Gap = 30;
        
        Label label = new Label("Enter details of topUniversitys");
        label.setLayoutX(30);
        label.setLayoutY(Gap);
        rootPane.getChildren().add(label);
        
        txtFieldRanking = new TextField();
        txtFieldRanking.setLayoutX(paddingL);
        txtFieldRanking.setLayoutY(Gap*2);
        txtFieldRanking.setPrefWidth(200);
        txtFieldRanking.setPromptText("Enter Ranking");
        rootPane.getChildren().add(txtFieldRanking);
        
        txtFieldName = new TextField();
        txtFieldName.setLayoutX(paddingL);
        txtFieldName.setLayoutY(Gap*3);
        txtFieldName.setPrefWidth(200);
        txtFieldName.setPromptText("Enter Name");
        rootPane.getChildren().add(txtFieldName);
        
        txtFieldCountry = new TextField();
        txtFieldCountry.setLayoutX(paddingL);
        txtFieldCountry.setLayoutY(Gap*4);
        txtFieldCountry.setPrefWidth(200);
        txtFieldCountry.setPromptText("Enter Country");
        rootPane.getChildren().add(txtFieldCountry);
        
        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(paddingL);
        btn.setLayoutY(Gap*5);
        btn.setOnAction((ActionEvent ae) -> GetData());
        rootPane.getChildren().add(btn);
        
        Image image = new Image ("GitHub.jpg");
        ImageView Image1 = new ImageView();
        Image1.setImage(image);
        Image1.setLayoutX(paddingL);
        Image1.setLayoutY(Gap*6);
        Image1.setPreserveRatio(true);       
        
    }
    
    private static void GetData()
    {
        String Rank = txtFieldRanking.getText();
        String Name = txtFieldName.getText();
        String Country = txtFieldCountry.getText();
        System.out.println(Rank + "  " + Name + " " + Country);
        
    }
    
    private static void terminate()
    {
        System.out.println("bye bye!");
        System.exit(0);
    }

}
