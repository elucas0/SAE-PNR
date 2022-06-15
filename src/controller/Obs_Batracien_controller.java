package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Obs_Batracien_controller {

    @FXML
    /**
     * combobox with the observation's nature in the fxml
     */
    private ComboBox<String> espece;

    /**
     * combobox in the fxml that contains if 
     */
    private ComboBox<String> nbAdultes;
    private ComboBox<String> meteo_ciel;
    private ComboBox<String> meteo_vent;
    private ComboBox<String> meteo_pluie;
    private ComboBox<String> natureObs;


    private ObservableList<String> liste;


    public Obs_Batracien_controller(){}
    


    @FXML
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("Effraie", "Cheveche", "Hulotte");
        liste2 = FXCollections.observableArrayList("male", "femelle", "inconnu");

        //sexe.setItems(liste2);
        natureObs.setItems(liste);

    }
    
}
