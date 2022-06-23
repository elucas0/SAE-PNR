package controller.formulaires;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
     * Button access the account page
     */
    private Button user;
    


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize() 
    {
        liste = FXCollections.observableArrayList("Positif","Negatif","Non prospection");
        indice.setItems(liste);
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
        if (indice.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (commune.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (lieu_dit.getText().isEmpty()) {
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
                Statement obsLoutreController = c.createStatement();
                PreparedStatement testLoutre = c.prepareStatement("SELECT * FROM lieu WHERE coord_Lambert_X = ? AND coord_Lambert_Y = ?");
                testLoutre.setString(1, lambertX.getText());
                testLoutre.setString(2, lambertY.getText());
                ResultSet resultatLoutre = testLoutre.executeQuery();

                if(resultatLoutre.next()){}
                else{
                    String querry1 = "INSERT INTO lieu VALUES(" + lambertX.getText() + "," + lambertY.getText() + ");";
                    obsLoutreController.executeUpdate(querry1);
                }
                PreparedStatement querry2 = c.prepareStatement("INSERT INTO Observation(dateObs, heureObs, lieu_Lambert_X, lieu_Lambert_Y) VALUES('" + Date.valueOf(date.getValue()) + "','" + Time.valueOf(heureObs.getText()) +"', " + lambertX.getText() + ", " + lambertY.getText() + ");");
                
                PreparedStatement idLoutre = c.prepareStatement("SELECT MAX(idObs) FROM Observation;");
                ResultSet requete2 = idLoutre.executeQuery();
                requete2.next();
                int idL = requete2.getInt("Max(idObs)");

                String querry3 = "INSERT INTO obs_loutre VALUES(" + idL+ ", '" + commune.getText() + "', '" + lieu_dit.getText() + "', '" + indice.getValue() + "');";
                String querry4 = "INSERT INTO aobserve VALUES(" + ReadInfos.getId() + ", " + idL + ");";
                
                querry2.executeUpdate();
                obsLoutreController.executeUpdate(querry3);
                obsLoutreController.executeUpdate(querry4);
                
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
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)indice.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../../view/Accueil_Utilisateur.fxml");
        }
    }
}
