import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Pos;


import java.util.Random;


public class Display
{
    public static double ScreenWidth;
    public static double ScreenHeight;
    
    
    
    
    
    public static void iniHydra()
    {
        NewWindow();
    }
    
    public static void NewWindow()
    {
        
        Stage stage = new Stage();
        stage.setTitle("Hydra");
        stage.getIcons().add(new Image(Display.class.getResourceAsStream("hydra.png")));
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        int[] COOR = setLocation();
        stage.setX(COOR[0]);
        stage.setY(COOR[1]);
        stage.setWidth(300);
        stage.setHeight(100);
        stage.setOnCloseRequest(event -> ButtonClick(stage));
        stage.show();
        
        Label label = new Label("Cut off a head, two more will take its place.");
        label.setLayoutY(0);
        
        rootPane.getChildren().add(label);
        
        Button btn = new Button();
        btn.setText("Okay!");
        btn.setLayoutX(40);
        btn.setLayoutY(22);
        //StackPane.setAlignment(btn, Pos.CENTER);
        btn.setOnAction((ActionEvent ae) -> ButtonClick(stage));
        rootPane.getChildren().add(btn);
                
        ImageView Image = new ImageView();
        Image Hydra = new Image(Display.class.getResourceAsStream("hydra.png"));
        Image.setImage(Hydra);
        Image.setY(20);
        Image.setX(0);
        rootPane.getChildren().add(Image);
        
    }
    
    public static int[] setLocation()
    {
        double rand = new Random().nextDouble();
        int[] DIM = GetDimensions();
        
        int width = (DIM[0]);  // change to detect size of monitor
        int height = (DIM[1]);
        
        double X = DIM[0]*0.2 + (rand * (DIM[0]*0.8 - DIM[0]*0.2));
        rand = new Random().nextDouble();
        double Y = DIM[1]*0.2 + (rand * (DIM[1]*0.8 - DIM[1]*0.2));
        
        int x = ((int)X);
        int y = ((int)Y);
        //System.out.println("X: " + x + " , Y: " + y);
        int[] COOR = {x, y};
        //System.out.println("X: " + COOR[0] + " , Y: " + COOR[1]);
        return (COOR);
    }
   
    public static void ButtonClick(Stage stage)
    {
        NewWindow();
        NewWindow();
        
        stage.close();
    }
    
    public static int[] GetDimensions()
    {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        int ScreenWidth = ((int)primaryScreenBounds.getWidth());
        int ScreenHeight = ((int)primaryScreenBounds.getHeight());
        
        //System.out.println(ScreenWidth + " " + ScreenHeight);
        int[] DIM = {ScreenWidth, ScreenHeight};
        
        return(DIM);
    }    
}
