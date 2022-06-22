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
    /**
     * text field for inputing the id
     */
    @FXML
    private TextField id;
    
    /**
     * text field for inputing the password
     */
    @FXML
    private PasswordField mdp;

    /**
     * button  used to connect
     */
    @FXML
    private Button bouton_connexion;
    
    /**
    * Event to do when the button bouton_connexion is pressed.    
    * Connect user to the databases if the id and the password are right
    */
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

     /**
     * Method who create the message and show it in the screen
     * @param alertType Type of the Alert (CONFIRMATION OR ERROR)
     * @param owner Window where the message will be shown
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
}

