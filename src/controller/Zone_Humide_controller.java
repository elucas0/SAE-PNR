package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Zone_Humide_controller {

    @FXML
    private ComboBox<String> temporaire;

    @FXML
    private ComboBox<String> typeMare;

    @FXML
    private ComboBox<String> pente;

    @FXML
    private ComboBox<String> ouverture;



    private ObservableList<String> liste;
    


    @FXML
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
    
}
