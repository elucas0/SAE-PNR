package controller;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Obs_Batracien_controller{



    @FXML
    private ComboBox<String> meteo_ciel;

        @FXML
    private ComboBox<String> meteo_vent;

    @FXML
    private ComboBox<String> meteo_pluie;

    @FXML
    private ComboBox<String> meteo_temps;


    private ObservableList<String> liste;



    


    @FXML
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
    
}
