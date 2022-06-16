package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_obs_loutre.fxml. It manages it.
 * @version 1.1
 */
public class Obs_Loutre_controller {
    
    @FXML
    /**
     * The combobox with the indication of the observation in the fxml file.
     */
    private ComboBox<String> indice;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;
    


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("positif", "négatif", "pas de prospection");
        indice.setItems(liste);
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)indice.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }
}
