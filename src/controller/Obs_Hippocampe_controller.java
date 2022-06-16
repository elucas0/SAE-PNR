package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_cbs_hippocampe.fxml. It manages it.
 * @version 1.1
 */
public class Obs_Hippocampe_controller {

    @FXML
    /**
     * The combobox with the seahorse's specie in the fxml file.
     */
    private ComboBox<String> espece;

    @FXML
    /**
     * The combobox that tell about the gender in the fxml file.
     */
    private ComboBox<String> sexe;

    @FXML
    /**
     * The combobox that tell about the fishing's type in the fxml file.
     */
    private ComboBox<String> typePeche;

    @FXML
    /**
     * The combobox that tell if the male seahors is pregnant, in the fxml file.
     */
    private ComboBox<String> estGestant;

    @FXML
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
