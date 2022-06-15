package controller;

import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Controller for the file Formulaire_obs_gci.fxml
 */
public class Obs_GCI_controller {


    @FXML
    /**
     * combobox with the observation's nature in the fxml
     */
    private ComboBox<String> natureObs;

    /**
     * combobox in the fxml that contains if 
     */
    private ComboBox<String> presentMaisNonObs;


    private ObservableList<String> liste;
    private ObservableList<String> liste2;


    public Obs_GCI_controller(){}
    


    @FXML
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("Oeuf", "Poussin", "Nid");
        liste2 = FXCollections.observableArrayList("oui", "non");

        //presentMaisNonObs.setItems(liste2);
        natureObs.setItems(liste);

    }

}
