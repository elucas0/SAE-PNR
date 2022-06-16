package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_zone_humide.fxml. It manages it.
 * @version 1.0
 */
public class Zone_Humide_controller {

    @FXML
    /**
     * The combobox that tell if the damp area is temporary, in the fxml file.
     */
    private ComboBox<String> temporaire;

    @FXML
    /**
     * The combobox with the pond's type in the fxml file.
     */
    private ComboBox<String> typeMare;

    @FXML
    /**
     * The combobox with the slope's informations in the fxml file.
     */
    private ComboBox<String> pente;

    @FXML
    /**
     * The combobox with the opening's informations in the fxml file.
     */
    private ComboBox<String> ouverture;


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
        liste = FXCollections.observableArrayList("oui", "non");
        temporaire.setItems(liste);

        liste = FXCollections.observableArrayList("prairie", "étang", "marais", "mare", "fossé");
        typeMare.setItems(liste);

        liste = FXCollections.observableArrayList("raide", "abrupte", "douce");
        pente.setItems(liste);

        liste = FXCollections.observableArrayList("abritee", "semi-abritée", "ouverte");
        ouverture.setItems(liste);
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)ouverture.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }
    
}
