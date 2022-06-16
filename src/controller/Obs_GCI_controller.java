package controller;

import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_obs_gci.fxml. It manages it.
 * @version 1.2
 */
public class Obs_GCI_controller {


    @FXML
    /**
     * The combobox with the nature of the observation in the fxml file.
     */
    private ComboBox<String> natureObs;

    @FXML
    /**
     * The combobox that tell if the nest was present but there wasn't
     * any observation, in the fxml file.
     */
    private ComboBox<String> presentMaisNonObs;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste2;    


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("Oeuf", "Poussin", "Nid");
        liste2 = FXCollections.observableArrayList("oui", "non");

        presentMaisNonObs.setItems(liste2);
        natureObs.setItems(liste);

    }


    /**
     * Event to do when the button aNid is pressed.
     * Switch to the page Formulaire_nid_gci.fxml
     */
    public void to_Nid(){

        Stage actuel = (Stage)presentMaisNonObs.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_nid_gci.fxml");
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Formulaire_nid_gci.fxml
    */
    public void retour(){

        Stage actuel = (Stage)presentMaisNonObs.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }

}
