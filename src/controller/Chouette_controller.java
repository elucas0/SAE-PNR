package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Chouette_controller {
    

    @FXML
    /**
     * combobox with the observation's nature in the fxml
     */
    private ComboBox<String> natureObs;

    /**
     * combobox in the fxml that contains if 
     */
    private ComboBox<String> sexe;


    private ObservableList<String> liste;
    private ObservableList<String> liste2;


    public Chouette_controller(){}
    


    @FXML
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("Effraie", "Cheveche", "Hulotte");
        liste2 = FXCollections.observableArrayList("male", "femelle", "inconnu");

        //sexe.setItems(liste2);
        natureObs.setItems(liste);

    }
}
