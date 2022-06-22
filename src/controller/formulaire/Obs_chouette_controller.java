package controller.formulaire;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.SQLException;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import java.sql.*;
import javafx.scene.control.DatePicker;

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
     * different combobox.
     */
    private ObservableList<String> liste;

    @FXML
    /**
     * text field for the id
     */
    private TextField idChouette;

    @FXML
    /**
     * Button to insert the data in the database
     */
    private Button effectuer;

    @FXML
    /**
     * text field for the hours
     */
    private TextField heureObs;

    @FXML
    /**
     * text field for the Date
     */
    private DatePicker date;

    @FXML
    /**
     * text field for the X Lambert coordinate
     */
    private TextField lambertX;

    @FXML
    /**
     * text field for the Y Lambert coordinate
     */
    private TextField lambertY;

    @FXML
    private Button user;



    


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
        user.setText(ReadInfos.getStatus());

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
        if (typeObs.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        else if (protocole.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        
        else if (idChouette.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (lambertX.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (lambertY.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (date.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (heureObs.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else{

        
            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
                Statement obsChouetteController = c.createStatement();

                PreparedStatement testChouette = c.prepareStatement("SELECT * FROM lieu WHERE coord_Lambert_X = ? AND coord_Lambert_Y = ?");
                testChouette.setString(1, lambertX.getText());
                testChouette.setString(2, lambertY.getText());
                ResultSet resultatChouette = testChouette.executeQuery();

                if(resultatChouette.next()){}
                else{
                    String querry1 = "INSERT INTO lieu VALUES(" + lambertX.getText() + "," + lambertY.getText() + ");";
                    obsChouetteController.executeUpdate(querry1);
                }

                PreparedStatement querry2 = c.prepareStatement("INSERT INTO Observation(dateObs, heureObs, lieu_Lambert_X, lieu_Lambert_Y) VALUES('" + Date.valueOf(date.getValue()) + "','" + Time.valueOf(heureObs.getText()) +"', " + lambertX.getText() + ", " + lambertY.getText() + ");");

                PreparedStatement id_Chouette = c.prepareStatement("SELECT MAX(idObs) FROM Observation;");
                ResultSet requete2 = id_Chouette.executeQuery();
                requete2.next();
                int idC = requete2.getInt("Max(idObs)");
                int protocol = -1;
                if (protocole.getValue().equals(("oui"))){
                    protocol = 1;
                }
                else{
                    protocol = 0;
                }

                String querry3 = "INSERT INTO obs_chouette VALUES('" + protocol + "', '" + typeObs.getValue() + "', '" + idChouette.getText() + "'," + idC +");";
                String querry4 = "INSERT INTO aobserve VALUES(" + ReadInfos.getId() + ", " + idC + ");";
                querry2.executeUpdate();
                obsChouetteController.executeUpdate(querry3);
                obsChouetteController.executeUpdate(querry4);
                
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
    * Event to do when the button retour is pressed.    
    * Switch to the page Formulaire_chouette.fxml
    */
    public void retour(){

        Stage actuel = (Stage)protocole.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }



    
}
