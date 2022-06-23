package controller.formulaires;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import java.sql.SQLException;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
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
    private TextField nomEnvols;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField nomPlage;

    @FXML
    /**
     * Button access the account page
     */
    private Button user;
    
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
        user.setText(ReadInfos.getStatus());
    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (raisonArret.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (estProtege.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        //test : textfield vide
        else if (bagueMale.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        else if (bagueFemelle.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        else if (nomEnvols.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (nomPlage.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else{

        
            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
                Statement nidGCIController = c.createStatement();

                int protec = -1;
                if(estProtege.getValue().equals("oui")){
                    protec = 1;

                }else{

                    protec = 0;
                }

                PreparedStatement testNidGCI = c.prepareStatement("SELECT idNid FROM nid_gci WHERE nomPlage = ? AND raisonArretObservation = ? AND nbEnvol = ? AND protection = ? AND bagueMale = ? AND bagueFemelle = ?");
                testNidGCI.setString(1, nomPlage.getText());
                testNidGCI.setString(2, raisonArret.getPromptText());
                testNidGCI.setString(3, nomEnvols.getText());
                testNidGCI.setInt(4, protec);
                testNidGCI.setString(5, bagueMale.getText());
                testNidGCI.setString(6, bagueFemelle.getText());
                ResultSet resultatNidGCI = testNidGCI.executeQuery();

                if(resultatNidGCI.next()){
                    showAlert(Alert.AlertType.ERROR, owner, "Observation", "Nid déjà rentré!");
                }
                else{
                    String querry = "INSERT INTO nid_gci(nomPlage, raisonArretObservation, nbEnvol, protection, bagueMale, bagueFemelle) VALUES('" + nomPlage.getText() + "','" + raisonArret.getValue() + "', '" + nomEnvols.getText() + "', " + protec + ", '" + bagueMale.getText() + "', '" + bagueFemelle.getText() + "');";
                    nidGCIController.executeUpdate(querry);
                    showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method who create the message and show it in the screen
     * @param alertType Type of the Alert (CONFIRMATION OR ERROR)
     * @param owner The owner of the window
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
        change.go_to("../../view/formulaires/Formulaire_obs_gci.fxml");
    }


    /**
     * Event to do when the button aObservation is pressed.
     * Switch to the page Formulaire_nid_gci.fxml
     */
    public void to_home(){

        Stage actuel = (Stage)raisonArret.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../../view/Accueil_Utilisateur.fxml");
        }
    }

    
    /**
     * Event to do when the button arreter is pressed.
     * Switch to the page Formulaire_obs_gci.fxml
     */
    public void retour(){

        Stage actuel = (Stage)raisonArret.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_gci.fxml");


    }
}
