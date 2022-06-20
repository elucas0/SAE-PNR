package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Observateur_controller {

    @FXML
    private ComboBox estAdmin;

    private ObservableList<String> liste;

    void initialize(){

        liste = FXCollections.observableArrayList("Oui", "Non");
        estAdmin.setItems(liste);

    }
    
}
