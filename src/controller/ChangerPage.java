package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ChangerPage {

    private Stage primaryStage;
    private Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();


    public ChangerPage(Stage primaryStage){

        if(primaryStage != null){

            this.primaryStage = primaryStage;
        }
    }


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
