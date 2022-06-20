/*
 * rajouter dans la page un champ de texet pour :
 * l'id
 * l'administration
 * sinon l'insert est pas possible!!!!!
 */
package controller;

import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import java.sql.*;

public class ConnectionBDD {
    @FXML
    private TextField id;

    @FXML
    private PasswordField mdp;

    @FXML
    private Button bouton_connexion;

    @FXML
    public void register() throws SQLException {

        Window owner = bouton_connexion.getScene().getWindow();

        if (id.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
        }
        if (mdp.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String querry = "INSERT INTO registration VALUES(" + id.getText() + "," + mdp.getText() + ");";
            s.executeUpdate(querry);
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
            "Welcome " + id.getText());
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}

