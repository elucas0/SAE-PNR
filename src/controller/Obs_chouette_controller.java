package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Obs_chouette_controller {

    @FXML
    /**
     * combobox with the observation's nature in the fxml
     */
    private ComboBox<String> typeObs;

    @FXML
    private ComboBox<String> protocole;

    private ObservableList<String> liste;



    


    @FXML
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
        change.go_to("Formulaire_chouette.fxml");
    }



    
}
