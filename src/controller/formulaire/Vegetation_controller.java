package controller.formulaire;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.sql.SQLException;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import java.sql.*;


/**
 * The controller of the page Formulaire_vegetation.fxml. It manages it.
 * @version 1.0
 */
public class Vegetation_controller {

    @FXML
    private TextField environnement;

    @FXML
    private TextField bordure;

    @FXML
    private TextField ripisyle;

    @FXML
    private TextField idZoneVege;

    @FXML
    /**
     * Button to insert the data in the database
     */
    private Button effectuer;

    @FXML
    private Button user;

    @FXML
    private void initialize(){

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
        if (environnement.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (bordure.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (ripisyle.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (idZoneVege.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else{

            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
                Statement vegetationController = c.createStatement();

                PreparedStatement testVegetation = c.prepareStatement("SELECT idVegeLieu FROM lieu_vegetation WHERE idVegeLieu = ?");
                testVegetation.setString(1, idZoneVege.getText());
                ResultSet resultatVegetation = testVegetation.executeQuery();

                if(resultatVegetation.next()){}
                else{
                    String querry1 = "INSERT INTO lieu_vegetation VALUES();";
                    vegetationController.executeUpdate(querry1);
                }

                PreparedStatement testVegetation2 = c.prepareStatement("SELECT natureVege FROM vegetation WHERE natureVege = 'environnement' AND decrit_LieuVege = ?");
                testVegetation2.setString(1, idZoneVege.getText());
                ResultSet resultatVegetation2 = testVegetation2.executeQuery();

                if(resultatVegetation2.next()){}
                else{
                    String querry2 = "INSERT INTO vegetation (idVege,natureVege,vegetation,decrit_LieuVege) VALUES(" + "'environnement'" + ",'" + environnement.getText() + "'," + idZoneVege.getText() + ");";
                    vegetationController.executeUpdate(querry2);
                }


                PreparedStatement testVegetation3 = c.prepareStatement("SELECT natureVege FROM vegetation WHERE natureVege = 'bordure' AND decrit_LieuVege = ?");
                testVegetation3.setString(1, idZoneVege.getText());
                ResultSet resultatVegetation3 = testVegetation3.executeQuery();

                if(resultatVegetation3.next()){}
                else{
                    String querry3 = "INSERT INTO vegetation (idVege,natureVege,vegetation,decrit_LieuVege) VALUES(" + "'bordure'" + ",'" + bordure.getText() + "'," + idZoneVege.getText() + ");";
                }


                PreparedStatement testVegetation4 = c.prepareStatement("SELECT natureVege FROM vegetation WHERE natureVege = 'ripisyle' AND decrit_LieuVege = ?");
                testVegetation4.setString(1, idZoneVege.getText());
                ResultSet resultatVegetation4 = testVegetation4.executeQuery();

                if(resultatVegetation4.next()){}
                else{
                    String querry4 = "INSERT INTO vegetation (idVege,natureVege,vegetation,decrit_LieuVege) VALUES(" + "'ripisyle'" + ",'" + ripisyle.getText() + "'," + idZoneVege.getText() + ");";
                    vegetationController.executeUpdate(querry4);
                }

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

        Stage actuel = (Stage)environnement.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }
    
}
