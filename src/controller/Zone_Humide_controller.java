package controller;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import java.sql.*;
import javafx.scene.control.DatePicker;
/**
 * The controller of the page Formulaire_zone_humide.fxml. It manages it.
 * @version 1.0
 */
public class Zone_Humide_controller {

    @FXML
    /**
     * The combobox that tell if the damp area is temporary, in the fxml file.
     */
    private ComboBox<String> temporaire;

    @FXML
    /**
     * The combobox with the pond's type in the fxml file.
     */
    private ComboBox<String> typeMare;

    @FXML
    /**
     * The combobox with the slope's informations in the fxml file.
     */
    private ComboBox<String> pente;

    @FXML
    /**
     * The combobox with the opening's informations in the fxml file.
     */
    private ComboBox<String> ouverture;

    @FXML
    /**
     * The TextField.
     */
    private TextField profondeur;

    @FXML
    /**
     * The TextField.
     */
    private TextField surface;


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
        liste = FXCollections.observableArrayList("oui", "non");
        temporaire.setItems(liste);

        liste = FXCollections.observableArrayList("prairie", "étang", "marais", "mare", "fossé");
        typeMare.setItems(liste);

        liste = FXCollections.observableArrayList("raide", "abrupte", "douce");
        pente.setItems(liste);

        liste = FXCollections.observableArrayList("abritee", "semi-abritée", "ouverte");
        ouverture.setItems(liste);
    }


    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (temporaire.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        else if (typeMare.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        //test : textfield vide
        else if (pente.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        else if (ouverture.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        
        else if (profondeur.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (surface.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else{

        
            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
                Statement zoneHumideController = c.createStatement();
                
                int temp = -1;
                if (temporaire.getValue().equals(("oui"))){
                    temp = 1;
                }
                else{
                    temp = 0;
                }
                PreparedStatement testZoneHumide = c.prepareStatement("SELECT zh_id FROM nid_gci WHERE zh_temporaire = ? AND zh_profondeur = ? AND zh_surface = ? AND zh_typeMare = ? AND zh_pente = ? AND zh_ouverture = ?");
                testZoneHumide.setInt(1, temp);
                testZoneHumide.setString(2, profondeur.getPromptText());
                testZoneHumide.setString(3, surface.getText());
                testZoneHumide.setString(4, typeMare.getValue());
                testZoneHumide.setString(5, pente.getValue());
                testZoneHumide.setString(6, ouverture.getValue());
                ResultSet resultatNidGCI = testZoneHumide.executeQuery();

                if(resultatNidGCI.next()){
                    showAlert(Alert.AlertType.ERROR, owner, "Observation", "Zone humide déjà rentré!");
                }
                else{
                    String querry = "INSERT INTO zonehumide(zh_temporaire, zh_profondeur, zh_surface, zh_typeMare, zh_pente, zh_ouverture) VALUES('" + temp + "'," + profondeur.getText() +", " + surface.getText() + ", '" + typeMare.getValue() + "','" + pente.getValue() + "','" + ouverture.getValue() + "' );";
                    zoneHumideController.executeUpdate(querry);
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
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)ouverture.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }
    
}
