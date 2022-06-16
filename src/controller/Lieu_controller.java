package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.sql.*;

public class Lieu_controller {
    @FXML
    private TextField coord_Lambert_x;

    @FXML
    private TextField coord_Lambert_Y;

    @FXML
    private Button effectuer;

    @FXML
    private void test() throws SQLException{
        Window owner = effectuer.getScene().getWindow();

        if (coord_Lambert_x.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");
            return;
        }

        if (coord_Lambert_Y.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");
            return;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "INSERT INTO Lieu VALUES(" + coord_Lambert_x.getText() + "," + coord_Lambert_Y.getText() + ")";
            ResultSet r = s.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
        double coordX = coord_Lambert_x.getText();
        double coordY = coord_Lambert_Y.getText();

        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.insertRecord(coordX, coordY);
        jdcDao.insertRecord();
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
        **/
    }

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

        Stage actuel = (Stage)coord_Lambert_Y.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }
    
}
