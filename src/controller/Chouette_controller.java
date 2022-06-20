package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Window;
import java.sql.*;
/**
 * The controller of the page Formulaire_chouette.fxml. It manages it.
 * @version 1.3
 */
public class Chouette_controller {
    

    @FXML
    /**
     * The combobox with the nature of the observation in the fxml file.
     */
    private ComboBox<String> natureObs;

    @FXML
    /**
     * The combobox that contain the gender in the fxml file.
     */
    private ComboBox<String> sexe;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste; 
    
    @FXML
    /**
     * Button to insert the data in the database
     */
    private Button effectuer;


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("Effraie", "Cheveche", "Hulotte");
        natureObs.setItems(liste);

        liste = FXCollections.observableArrayList("male", "femelle", "inconnu");
        sexe.setItems(liste);

    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (natureObs.getPromptText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        if (sexe.getPromptText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //création de l'insert
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String querry = "INSERT INTO Lieu VALUES(" + natureObs.getPromptText() + "," + sexe.getPromptText() + ");";
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
     * Switch to the page Formulaire_obs_chouette.fxml
     */
    public void to_obs(){

        Stage actuel = (Stage)sexe.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_chouette.fxml");
    }

    /**
    * Event to do when the button aObservation is pressed.
    * Switch to the page Accueil_Utilisateur.fxml
    */
   public void retour(){

       Stage actuel = (Stage)sexe.getScene().getWindow();
       ChangerPage change = new ChangerPage(actuel);
       change.go_to("../view/formulaires/Formulaire_obs_chouette.fxml");
   }
}
