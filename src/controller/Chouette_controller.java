package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The controller of the page Formulaire_chouette.fxml. It manages it.
 * @version 1.3
 */
public class Chouette_controller {
    

    @FXML
    /**
     * The combobox with the nature of the observation in the fxml file.
     */
    private ComboBox<String> natureObs;

    @FXML
    /**
     * The combobox that contain the gender in the fxml file.
     */
    private ComboBox<String> sexe;


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
        liste = FXCollections.observableArrayList("Effraie", "Cheveche", "Hulotte");
        natureObs.setItems(liste);

        liste = FXCollections.observableArrayList("male", "femelle", "inconnu");
        sexe.setItems(liste);

    }


    /**
     * Event to do when the button aObservation is pressed.
     * Switch to the page Formulaire_obs_chouette.fxml
     */
    public void to_obs(){

        Stage actuel = (Stage)sexe.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_chouette.fxml");
    }

    /**
    * Event to do when the button aObservation is pressed.
    * Switch to the page Accueil_Utilisateur.fxml
    */
   public void retour(){

       Stage actuel = (Stage)sexe.getScene().getWindow();
       ChangerPage change = new ChangerPage(actuel);
       change.go_to("../view/formulaires/Formulaire_obs_chouette.fxml");
   }
}
