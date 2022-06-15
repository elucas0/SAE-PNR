package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vegetation_controller {

    @FXML
    private ComboBox<String> natureVege;

    private ObservableList<String> liste;
    


    @FXML
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("environnement", "bordure", "ripisyle");
        natureVege.setItems(liste);
    }
    
}
