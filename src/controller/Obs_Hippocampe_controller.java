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
import javafx.scene.control.DatePicker;

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
     * text field for the number of fly
     */
    private TextField tempEau;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField taille;

    @FXML
    /**
     * Button to insert the data in the database
     */
    private Button effectuer;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField heureObs;

    @FXML
    /**
     * text field for the number of fly
     */
    private DatePicker date;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField lambertX;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField lambertY;
    


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("Syngnathus acus", "Hippocampus guttulatus", "Hippocampus Hippocampus", "Entelurus aequoreus");
        espece.setItems(liste);


        liste = FXCollections.observableArrayList("male", "femelle", "inconnu");
        sexe.setItems(liste);

        liste = FXCollections.observableArrayList("casierCrevettes", "casierMorgates", "PetitFilet", "verveuxAnguilles");
        typePeche.setItems(liste);

        liste = FXCollections.observableArrayList("oui", "non");
        estGestant.setItems(liste);
    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (espece.getPromptText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        if (sexe.getPromptText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        
        if (typePeche.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        
        //test : textfield vide
        if (estGestant.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (tempEau.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (taille.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (lambertX.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (lambertY.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (date.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (heureObs.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        //création de l'insert
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            //String querry = "INSERT INTO obs_hippocampe VALUES(" + espece.getPromptText() + "," + sexe.getPromptText() + "," + tempEau.getText() + "," + typePeche.getPromptText() + "," + taille.getText() + "," + estGestant.getPromptText() + ");";
            //s.executeUpdate(querry);

            String querry1 = "INSERT INTO lieu VALUES(" + lambertX.getText() + "," + lambertY.getText() + ");";
            PreparedStatement querry2 = c.prepareStatement("INSERT INTO Observation(dateObs, heureObs, lieu_Lambert_X, lieu_Lambert_Y) VALUES('" + Date.valueOf(date.getValue()) + "','" + Time.valueOf(heureObs.getText()) +"', " + lambertX.getText() + ", " + lambertY.getText() + ");");

            PreparedStatement idHippocampes = c.prepareStatement("SELECT MAX(idObs) FROM Observation;");
            ResultSet requete2 = idHippocampes.executeQuery();
            requete2.next();
            int idH = requete2.getInt("Max(idObs)");
            int gestant = -1;
            if (estGestant.getValue().equals(("oui"))){
                gestant = 1;
            }
            else{
                gestant = 0;
            }

            String querry3 = "INSERT INTO obs_hippocampe VALUES(" + idH + ", '" + espece.getValue() + "', '" + sexe.getValue() + "', '" + tempEau.getText() + "','" + typePeche.getValue() + "','" + taille.getText() + "','" + gestant + "');";
            //String querry4 = "INSERT INTO aobserve VALUES(" + idL+1 + commune.getText() + "," + lieu_dit.getText() + "," + indice.getPromptText() + ");";
            s.executeUpdate(querry1);
            querry2.executeUpdate();
            s.executeUpdate(querry3);
            
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
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)espece.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.readAdmin() == true){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }
    
    
}
