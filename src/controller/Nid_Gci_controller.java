package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import java.sql.*;

/**
 * The controller of the page Formulaire_nid_gci.fxml. It manages it.
 * @version 1.7
 */
public class Nid_Gci_controller{

    @FXML
    /**
     * The combobx wich the contain the reason to stop the observation in the fxml file.
     */
    private ComboBox<String> raisonArret;

    @FXML
    /**
     * The combobx that told if the nest was protected in the fxml file.
     */
    private ComboBox<String> estProtege;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;

    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> protection;

    @FXML
    /**
     * Button to insert the data in the database
     */
    private Button effectuer;

    @FXML
    /**
     * text field for the bagueMale
     */
    private TextField bagueMale;

    @FXML
    /**
     * text field for the bagueFemelle
     */
    private TextField bagueFemelle;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField nomObs;

    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("envol", "inconnu", "marée", "prédation");
        protection = FXCollections.observableArrayList("oui", "non");



        raisonArret.setItems(liste);
        estProtege.setItems(protection);

    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (raisonArret.getPromptText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        if (bagueMale.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        if (bagueFemelle.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        if (nomObs.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //création de l'insert
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String querry = "INSERT INTO Lieu VALUES(" + raisonArret.getPromptText() + "," + nomObs.getText() + "," + estProtege.getPromptText() + "," + bagueMale.getText() + "," + bagueFemelle.getText() + ");";
            s.executeUpdate(querry);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
    }

    /**
     * Method who create the message and show it in the screen
     * @param alertType Type of the Alert (CONFIRMATION OR ERROR)
     * @param owner
     * @param title Title of the message screen
     * @param message Message who appear in screen
     */
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    /**
     * Event to do when the button aObservation is pressed.
     * Switch to the page Formulaire_obs_gci.fxml
     */
    public void to_obs(){

        Stage actuel = (Stage)raisonArret.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_gci.fxml");
    }


    /**
     * Event to do when the button aObservation is pressed.
     * Switch to the page Formulaire_nid_gci.fxml
     */
    public void to_home(){

        Stage actuel = (Stage)raisonArret.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }

    
    /**
     * Event to do when the button arreter is pressed.
     * Switch to the page Formulaire_obs_gci.fxml
     */
    public void retour(){

        Stage actuel = (Stage)raisonArret.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_gci.fxml");


    }
}
