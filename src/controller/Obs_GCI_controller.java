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
 * The controller of the page Formulaire_obs_gci.fxml. It manages it.
 * @version 1.2
 */
public class Obs_GCI_controller {


    @FXML
    /**
     * The combobox with the nature of the observation in the fxml file.
     */
    private ComboBox<String> natureObs;

    @FXML
    /**
     * The combobox that tell if the nest was present but there wasn't
     * any observation, in the fxml file.
     */
    private ComboBox<String> presentMaisNonObs;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste2;  
    
    @FXML
    /**
     * text field for the number of fly
     */
    private TextField idNid;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField nombre;

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
        liste = FXCollections.observableArrayList("Oeuf", "Poussin", "Nid");
        liste2 = FXCollections.observableArrayList("oui", "non");

        presentMaisNonObs.setItems(liste2);
        natureObs.setItems(liste);

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
        if (presentMaisNonObs.getPromptText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        
        if (idNid.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (nombre.getText().isEmpty()) {
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
            //tring querry = "INSERT INTO obs_gci VALUES(" + natureObs.getPromptText() + "," + nombre.getText() + "," + presentMaisNonObs.getPromptText() + "," + idNid.getText() + ");";
            //s.executeUpdate(querry);
            String querry1 = "INSERT INTO lieu VALUES(" + lambertX.getText() + "," + lambertY.getText() + ");";

            PreparedStatement idGCI = c.prepareStatement("SELECT LAST_INSERT_ID();");
            ResultSet requete2 = idGCI.executeQuery();
            requete2.next();
            int id_GCI = requete2.getInt("LAST_INSERT_ID()");

            //System.out.println(Time.valueOf(heureObs.getText()));
            PreparedStatement querry2 = c.prepareStatement("INSERT INTO observation VALUES(" + Date.valueOf(date.getValue()) + "','" + Time.valueOf(heureObs.getText()) +"', " + lambertX.getText() + ", " + lambertY.getText() + ");");
            String querry3 = "INSERT INTO obs_gci VALUES(" + id_GCI + ", " + natureObs.getPromptText() + ", " + nombre.getText() + ", " + presentMaisNonObs.getPromptText() +  "," + idNid.getText() + ");";
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
     * Event to do when the button aNid is pressed.
     * Switch to the page Formulaire_nid_gci.fxml
     */
    public void to_Nid(){

        Stage actuel = (Stage)presentMaisNonObs.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_nid_gci.fxml");
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Formulaire_nid_gci.fxml
    */
    public void retour(){

        Stage actuel = (Stage)presentMaisNonObs.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.readAdmin() == true){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }

}
