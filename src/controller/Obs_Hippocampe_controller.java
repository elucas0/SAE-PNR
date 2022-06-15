package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Obs_Hippocampe_controller {

    @FXML
    /**
     * combobox with the observation's nature in the fxml
     */
    private ComboBox<String> espece;

    @FXML
    private ComboBox<String> sexe;

    @FXML
    private ComboBox<String> typePeche;

    @FXML
    private ComboBox<String> estGestant;

    @FXML
    private ObservableList<String> liste;



    


    @FXML
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("Syngnathus acus", "Hippocampus guttulatus", "Hippocampus hippocampus", "Entelurus aequoreus");
        espece.setItems(liste);


        liste = FXCollections.observableArrayList("male", "femelle", "inconnu");
        sexe.setItems(liste);

        liste = FXCollections.observableArrayList("casier Crevette", "casier Morgates", "petit Filet", "verveux Anguilles");
        typePeche.setItems(liste);

        liste = FXCollections.observableArrayList("oui", "non");
        estGestant.setItems(liste);
    }
    
    
}
