package controller;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * The controller of the page Formulaire_obs_batracien.fxml. It manages it.
 * @version 1.2
 */
public class Obs_Batracien_controller{
    

    @FXML
    /**
     * The combobox that contains the information about the sky's weather in the fxml file.
     */
    private ComboBox<String> meteo_ciel;


    @FXML
    /**
     * The combobox that contains the information about the wind's weather in the fxml file.
     */
    private ComboBox<String> meteo_vent;


    @FXML
    /**
     * The combobox that contains the information about the rain's weather in the fxml file.
     */
    private ComboBox<String> meteo_pluie;


    @FXML
    /**
     * The combobox that contains the information about the time's weather in the fxml file.
     */
    private ComboBox<String> meteo_temps;


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


        liste = FXCollections.observableArrayList("dégagé", "semi-dégagé", "nuageux");
        meteo_ciel.setItems(liste);

        liste = FXCollections.observableArrayList("non", "léger", "moyen", "fort");
        meteo_vent.setItems(liste);

        liste = FXCollections.observableArrayList("non", "légère", "moyenne", "forte");
        meteo_pluie.setItems(liste);

        liste = FXCollections.observableArrayList("froid", "moyen", "chaud");
        meteo_temps.setItems(liste);
    }

    /**
    * Event to do when the button retour is pressed.
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)meteo_ciel.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }
    
}
