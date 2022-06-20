package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
 * The controller of the page Formulaire_obs_loutre.fxml. It manages it.
 * @version 1.1
 */
public class Obs_Loutre_controller {
    
    @FXML
    /**
     * The combobox with the indication of the observation in the fxml file.
     */
    private ComboBox<String> indice;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField commune;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField lieu_dit;

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
     * Button to insert the data in the database
     */
    private Button effectuer;
    


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("positif", "négatif", "pas de prospection");
        indice.setItems(liste);
    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (indice.getPromptText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (commune.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (lieu_dit.getText().isEmpty()) {
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
            String querry1 = "INSERT INTO lieu VALUES(" + lambertX.getText() + "," + lambertY.getText() + ");";

            PreparedStatement id = c.prepareStatement("SELECT MAX(idObs) FROM observation;");
            ResultSet requete1 = id.executeQuery();
            requete1.next();
            int idObs = requete1.getInt("idObs");

            PreparedStatement idLoutre = c.prepareStatement("SELECT MAX(obsL) FROM observation;");
            ResultSet requete2 = idLoutre.executeQuery();
            requete2.next();
            int idL = requete2.getInt("obsL");
            String tess = heureObs.getText();
            String querry2 = "INSERT INTO observation VALUES(" + idObs+1 + date.getValue() + "," + heureObs.getText() + lambertX.getText() + "," + lambertY.getText() + ");";
            String querry3 = "INSERT INTO obs_loutre VALUES(" + idL+1 + commune.getText() + "," + lieu_dit.getText() + "," + indice.getPromptText() + ");";
            //String querry4 = "INSERT INTO aobserve VALUES(" + idL+1 + commune.getText() + "," + lieu_dit.getText() + "," + indice.getPromptText() + ");";
            s.executeUpdate(querry1);
            s.executeUpdate(querry2);
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

        Stage actuel = (Stage)indice.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }
}
