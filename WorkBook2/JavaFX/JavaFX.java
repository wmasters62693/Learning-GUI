//importing all the required 
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;


public class JavaFX
{
    //initialising variables that are used in more than one function
    private static TextField txtFieldRanking;
    private static TextField txtFieldName;
    private static TextField txtFieldCountry;
    
    private static University currentlySelectedUniversity = null;
    
    //initialising arrayLists
    private static ListView<University> uniListView;
    private static ArrayList<University> uniArrayList = new ArrayList<University>();
    
    
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
        //creates a new Stage, names it, sets it so it cant be resized, declares the size and sets it so that when you exit it calls the function terminate 
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
        
        // creating variables to help with positioning of future items
        int paddingL = 30;
        int Gap = 30;
        
        //creates a new label and adds it to the stage
        Label label = new Label("Enter details of topUniversitys");
        label.setLayoutX(30);
        label.setLayoutY(Gap);
        rootPane.getChildren().add(label);
        
        //creates a new text field when the user can input data, sets the size and location and adds it to the stage
        txtFieldRanking = new TextField();
        txtFieldRanking.setLayoutX(paddingL);
        txtFieldRanking.setLayoutY(Gap*2);
        txtFieldRanking.setPrefWidth(200);
        txtFieldRanking.setPromptText("Enter Ranking");
        rootPane.getChildren().add(txtFieldRanking);
        
        //creates a new text field when the user can input data, sets the size and location and adds it to the stage
        txtFieldName = new TextField();
        txtFieldName.setLayoutX(paddingL);
        txtFieldName.setLayoutY(Gap*3);
        txtFieldName.setPrefWidth(200);
        txtFieldName.setPromptText("Enter Name");
        rootPane.getChildren().add(txtFieldName);
        
        //creates a new text field when the user can input data, sets the size and location and adds it to the stage
        txtFieldCountry = new TextField();
        txtFieldCountry.setLayoutX(paddingL);
        txtFieldCountry.setLayoutY(Gap*4);
        txtFieldCountry.setPrefWidth(200);
        txtFieldCountry.setPromptText("Enter Country");
        rootPane.getChildren().add(txtFieldCountry);
        
        //creates a new button, sets the size, location and to call the function GetData when the button is clicked on
        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(paddingL);
        btn.setLayoutY(Gap*5);
        btn.setOnAction((ActionEvent ae) -> addUni());
        rootPane.getChildren().add(btn);
        
        //creates a new image, sets the size and location and adds it to the stage
        Image image = new Image ("GitHub.jpg");
        ImageView Image1 = new ImageView();
        Image1.setImage(image);
        Image1.setLayoutX(paddingL);
        Image1.setLayoutY(Gap*6);
        Image1.setPreserveRatio(true);
        Image1.setFitWidth(200);
        //Image1.setFitHeight(300);
        rootPane.getChildren().add(Image1);
        
        //creates a new list viewer
        uniListView = new ListView<University>();
        uniListView.setLayoutX(300);
        uniListView.setLayoutY(Gap);
        updateUniView();
        uniListView.setOnMouseClicked((MouseEvent me) -> {
            currentlySelectedUniversity = uniListView.getSelectionModel().getSelectedItem();
        });
        rootPane.getChildren().add(uniListView);
        
        //create a new button that removes the selected university from the uniList
        Button btn2 = new Button();
        btn2.setText("Remove");
        btn2.setLayoutX(235);
        btn2.setLayoutY(Gap*2);
        btn2.setOnAction((ActionEvent ae) -> removeUni());
        rootPane.getChildren().add(btn2);
        
        
    }
    
    private static void addUni()
    {
        //gets whats in the text fields and stores them as variables
        int Rank =(Integer.parseInt(txtFieldRanking.getText()));
        String Name = txtFieldName.getText();
        String Country = txtFieldCountry.getText();
        
        //adds the new university to the array list and sorts the array list
        uniArrayList.add(new University(Rank, Name, Country));
               
        updateUniView();
        
    }
    
    public static void removeUni()
    {
        uniArrayList.remove(currentlySelectedUniversity);
        updateUniView();
    }
    
        private static void updateUniView()
    {
        uniListView.getItems().clear();
                        
        for(University uni : uniArrayList)
        {
            uniListView.getItems().add(uni);
        }
    }
    
    //function that when called outputs "bye bye!" to the console and exits the program
    private static void terminate()
    {
        System.out.println("bye bye!");
        System.exit(0);
    }

}