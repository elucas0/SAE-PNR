package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import java.sql.*;


/**
 * The controller of the page Formulaire_obs_chouette.fxml. It manages it.
 * @version 1.3
 */
public class Obs_chouette_controller {

    @FXML
    /**
     * The combobox with the observation's type in the fxml file.
     */
    private ComboBox<String> typeObs;

    @FXML
    /**
     * The combobox wich says if a protocol was applied type in the fxml file.
     */
    private ComboBox<String> protocole;

    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField idChouette;

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
        liste = FXCollections.observableArrayList("oui", "non");
        protocole.setItems(liste);


        liste = FXCollections.observableArrayList("Sonore", "Visuel", "Sonore et visuel");
        typeObs.setItems(liste);
    }

    public void to_Chouette(){

        Stage actuel = (Stage)protocole.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_chouette.fxml");
    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (typeObs.getPromptText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        if (protocole.getPromptText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        
        if (idChouette.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //création de l'insert
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String querry = "INSERT INTO obs_chouette VALUES(" + protocole.getPromptText() + "," + typeObs.getPromptText() + "," + idChouette.getPromptText() +");";
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
    * Event to do when the button retour is pressed.    
    * Switch to the page Formulaire_chouette.fxml
    */
    public void retour(){

        Stage actuel = (Stage)protocole.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }



    
}
