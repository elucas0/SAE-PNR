package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_obs_chouette.fxml. It manages it.
 * @version 1.3
 */
public class Obs_chouette_controller {

    @FXML
    /**
     * The combobox with the observation's type in the fxml file.
     */
    private ComboBox<String> typeObs;

    @FXML
    /**
     * The combobox wich says if a protocol was applied type in the fxml file.
     */
    private ComboBox<String> protocole;

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
        protocole.setItems(liste);


        liste = FXCollections.observableArrayList("Sonore", "Visuel", "Sonore et visuel");
        typeObs.setItems(liste);
    }

    public void to_Chouette(){

        Stage actuel = (Stage)protocole.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_chouette.fxml");
    }

    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Formulaire_chouette.fxml
    */
    public void retour(){

        Stage actuel = (Stage)protocole.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }



    
}
