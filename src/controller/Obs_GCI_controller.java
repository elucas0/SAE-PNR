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
        if (natureObs.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        else if (presentMaisNonObs.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        
        else if (idNid.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (nombre.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (lambertX.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (lambertY.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (date.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (heureObs.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else{

        
            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
                Statement obsGCIController = c.createStatement();

                PreparedStatement testGCI = c.prepareStatement("SELECT * FROM lieu WHERE coord_Lambert_X = ? AND coord_Lambert_Y = ?");
                testGCI.setString(1, lambertX.getText());
                testGCI.setString(2, lambertY.getText());
                ResultSet resultatGCI = testGCI.executeQuery();

                if(resultatGCI.next()){}
                else{
                    String querry1 = "INSERT INTO lieu VALUES(" + lambertX.getText() + "," + lambertY.getText() + ");";
                    obsGCIController.executeUpdate(querry1);
                }

                PreparedStatement querry2 = c.prepareStatement("INSERT INTO observation(dateObs, heureObs, lieu_Lambert_X, lieu_Lambert_Y) VALUES('" + Date.valueOf(date.getValue()) + "','" + Time.valueOf(heureObs.getText()) +"', " + lambertX.getText() + ", " + lambertY.getText() + ");");

                PreparedStatement idGCI = c.prepareStatement("SELECT MAX(idObs) FROM Observation;");
                ResultSet requete2 = idGCI.executeQuery();
                requete2.next();
                int idG = requete2.getInt("Max(idObs)");

                int present = 0;
                if(presentMaisNonObs.getValue().equals("oui")){
                    present = 1;

                }else{

                    present = 0;
                }

                String querry3 = "INSERT INTO obs_gci VALUES(" + idG + ", '" + natureObs.getValue() + "', '" + nombre.getText() + "', " + present +  ", '" + idNid.getText() + "');";
                String querry4 = "INSERT INTO aobserve VALUES(" + ReadInfos.getId() + ", " + idG + ");";

                querry2.executeUpdate();
                obsGCIController.executeUpdate(querry3);
                obsGCIController.executeUpdate(querry4);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
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
        if(ReadInfos.estAdmin()){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }

}
