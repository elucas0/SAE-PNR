package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_obs_loutre.fxml. It manages it.
 * @version 1.1
 */
public class Obs_Loutre_controller {
    
    @FXML
    /**
     * The combobox with the indication of the observation in the fxml file.
     */
    private ComboBox<String> indice;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;
    


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("positif", "négatif", "pas de prospection");
        indice.setItems(liste);
    }
}
