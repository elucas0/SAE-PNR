package controller;

import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Formulaire_nid_gci_controller {

    @FXML
    private ComboBox<String> raisonArret;
    private ComboBox<String> estProtege;


    private ObservableList<String> liste;
    private ObservableList<String> protection;


    public Formulaire_nid_gci_controller(){


    }
    


    @FXML
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("envol", "inconnu", "marée", "prédation");
        protection = FXCollections.observableArrayList("oui", "non");


        raisonArret.setItems(liste);
        //estProtege.setItems(protection);

    }
    
}
