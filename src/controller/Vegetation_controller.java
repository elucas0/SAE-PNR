package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_vegetation.fxml. It manages it.
 * @version 1.0
 */
public class Vegetation_controller {

    @FXML
    private TextField environnement;

    @FXML
    private TextField bordure;

    @FXML
    private TextField ripisyle;

    @FXML
    private TextField idZoneVege;    


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)environnement.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.readAdmin() == true){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }
    
}
