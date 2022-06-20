package view.login_page;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Main class that print the application
 */
public class Main extends Application {


    /**
     * The screnn's dimensions
     */
    private Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();


    /**
     * Start the application if called
     * @param primaryStage the stage where the graphical elements are printed
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../formulaires/Formulaire_observateur.fxml"));
        primaryStage.setTitle("PNR");
        primaryStage.setScene(new Scene(root, screenBounds.getWidth(), screenBounds.getHeight() * 0.97));
        primaryStage.show();
    }

    /**
     * The class' main method that launch the application with calling the method launch()
     * @param args
     */
    public static void main(String[] args) {
        
        launch(args);
    }
}
