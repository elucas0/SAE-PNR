package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.sql.*;
/**Class to insert data in table Lieu */
public class Lieu_controller {
    
    @FXML
    /**
     * text field for the X Lambert coordinate 
     */
    private TextField coord_Lambert_x;

    @FXML
    /**
     * text field for the Y Lambert coordinate
     */
    private TextField coord_Lambert_Y;

    @FXML
    /**
     * Button to insert the data in the database
     */
    private Button effectuer;

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void test() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (coord_Lambert_x.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        if (coord_Lambert_Y.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        else{

        
            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
                Statement lieuController = c.createStatement();
                PreparedStatement testLieu = c.prepareStatement("SELECT * FROM lieu WHERE coord_Lambert_X = ? AND coord_Lambert_Y = ?");
                testLieu.setString(1, coord_Lambert_x.getText());
                testLieu.setString(2, coord_Lambert_Y.getText());
                ResultSet resultatLieu = testLieu.executeQuery();

                if(resultatLieu.next()){
                    showAlert(Alert.AlertType.ERROR, owner, "Lieu", "Lieu déjà rentré!");
                }
                else{
                    String querry1 = "INSERT INTO lieu VALUES(" + coord_Lambert_x.getText() + "," + coord_Lambert_Y.getText() + ");";
                    lieuController.executeUpdate(querry1);
                    showAlert(Alert.AlertType.CONFIRMATION, owner, "Lieu", "rentré!");
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
    * Event to do when the button retour is pressed.    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)effectuer.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }
    
}
