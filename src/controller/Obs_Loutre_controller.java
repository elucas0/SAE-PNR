package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Obs_Loutre_controller {
    
    @FXML
    private ComboBox<String> indice;

    private ObservableList<String> liste;
    


    @FXML
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("positif", "négatif", "pas de prospection");
        indice.setItems(liste);
    }
}
