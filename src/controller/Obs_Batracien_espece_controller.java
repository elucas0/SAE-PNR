package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;



/**
 * The controller of the page Formulaire_obs_batracien.fxml. It manages it.
 * @version 1.2
 */
public class Obs_Batracien_espece_controller{
    

    @FXML
    /**
     * The combobox that contains the information about the sky's weather in the fxml file.
     */
    private ComboBox<String> espece;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField nbPonte;

    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("calamite", "pelodyte");
        espece.setItems(liste);

    }


    /**
    * Event to do when the button retour is pressed.
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)espece.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_batracien.fxml");
    }



    
}
