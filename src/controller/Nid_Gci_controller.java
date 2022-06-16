package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_nid_gci.fxml. It manages it.
 * @version 1.7
 */
public class Nid_Gci_controller{

    @FXML
    /**
     * The combobx wich the contain the reason to stop the observation in the fxml file.
     */
    private ComboBox<String> raisonArret;

    @FXML
    /**
     * The combobx that told if the nest was protected in the fxml file.
     */
    private ComboBox<String> estProtege;

    @FXML
    /**
     * Button to go to the page Formulaire_nid_gci.fxml in the fxml file.
     */
    private Button passerANidGci;

    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;

    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> protection;


    


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("envol", "inconnu", "marée", "prédation");
        protection = FXCollections.observableArrayList("oui", "non");



        raisonArret.setItems(liste);
        estProtege.setItems(protection);

    }

    /**
     * Event to do when the button aObservation is pressed.
     * Switch to the page Formulaire_obs_gci.fxml
     */
    public void to_obs(){

        Stage actuel = (Stage)passerANidGci.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_gci.fxml");
    }


    /**
     * Event to do when the button aObservation is pressed.
     * Switch to the page 
     */
    public void to_home(){

        Stage actuel = (Stage)passerANidGci.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
    }

    
    /**
     * Event to do when the button arreter is pressed.
     * Switch to the page 
     */
    public void retour(){

        Stage actuel = (Stage)passerANidGci.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);


    }
}
