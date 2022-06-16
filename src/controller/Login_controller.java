package controller;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import view.JdbcDao;
import java.sql.*;

public class Login_controller {   
    @FXML
    private TextField id;

    @FXML
    private PasswordField mdp;

    @FXML
    private Button bouton_connexion;

    @FXML
    public void connect(ActionEvent event) throws SQLException {
        String pass = null;
        Window owner = bouton_connexion.getScene().getWindow();

        if (id.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }
        if (mdp.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
            return;
        }
        try {            
            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/connection", "test@localhost", "test");
            Statement s = c.createStatement();
            String query = "SELECT * FROM registration WHERE full_name = '" + id.getText() + "';";
            ResultSet r = s.executeQuery(query);
            
            while (r.next()) {
                pass = r.getString("password");

                if (pass == mdp.getText()){
                    showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                        "Welcome " + id.getText());
                }
                else{
                    showAlert(Alert.AlertType.ERROR, owner, "ERROR!",
                        "mdp ou identifiant erroné ");
                }
            }
            if(pass == null){
                showAlert(Alert.AlertType.ERROR, owner, "ERROR!",
                        "Pas de compte créée");
            }
            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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


