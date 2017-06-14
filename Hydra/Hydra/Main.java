import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class Main
{
    public static void main (String [] args)
    {
        Display display = new Display();
        
        //initialises JavaFX
        new JFXPanel();
                      
        //runs initialisation on the JavaFX thread
        Platform.runLater(() -> Display.iniHydra());
        
    }
}
