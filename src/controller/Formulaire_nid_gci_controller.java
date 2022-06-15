package controller;

import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Formulaire_nid_gci_controller {

    @FXML
    private ComboBox<String> natureObs;

    private ObservableList<String> liste;

    public Formulaire_nid_gci_controller(){


    }
    


    @FXML
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("test", "test");

        natureObs.setItems(liste);
    }
    
}
