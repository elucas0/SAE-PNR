package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Class that contain the method to change of page
 * @version 1.0
 */
public class ChangerPage {

    /**
     * The stage where the page is changed
     */
    private Stage primaryStage;

    /**
     * Th screen's dimensions
     */
    private Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

    /**
     * The constructor of the class
     * @param primaryStage the stage concerned by the page swiching
     */
    public ChangerPage(Stage primaryStage){

        if(primaryStage != null){

            this.primaryStage = primaryStage;
        }
    }


    /**
     * Change the Stage's content to a wanted page
     * @param page the name of the fxml page corresponding to the page to want to
     */
    public void go_to(String page){

        if(page != null){

            try{

                Parent scene = FXMLLoader.load(getClass().getResource("../view/formulaires/"+page));
                primaryStage.setTitle("PNR");
                primaryStage.setScene(new Scene(scene, screenBounds.getWidth(), screenBounds.getHeight() * 0.97));
                primaryStage.show();
            
            }catch(IOException e){
    
                System.err.println(e.getMessage());
            }


        }else{

            System.err.println("go_to : you must go to an existing page");
        }
    }
    
}
