package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_vegetation.fxml. It manages it.
 * @version 1.0
 */
public class Vegetation_controller {

    @FXML
    /**
     * The combobox with the vegetation's nature in the fxml file.
     */
    private ComboBox<String> natureVege;


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
        liste = FXCollections.observableArrayList("environnement", "bordure", "ripisyle");
        natureVege.setItems(liste);
    }
    
}
