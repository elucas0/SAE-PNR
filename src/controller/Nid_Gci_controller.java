package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class Nid_Gci_controller{

    @FXML
    private ComboBox<String> raisonArret;

    @FXML
    private ComboBox<String> estProtege;

    @FXML
    private Button passerANidGci;


    private ObservableList<String> liste;
    private ObservableList<String> protection;


    


    @FXML
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("envol", "inconnu", "marée", "prédation");
        protection = FXCollections.observableArrayList("oui", "non");



        raisonArret.setItems(liste);
        estProtege.setItems(protection);

    }

    public void to_obs(){

        Stage actuel = (Stage)passerANidGci.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("Formulaire_obs_gci.fxml");
    }


    public void to_home(){

        Stage actuel = (Stage)passerANidGci.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);


    }
    
    public void retour(){

        Stage actuel = (Stage)passerANidGci.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);


    }
}
