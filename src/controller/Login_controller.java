package controller;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
            
        }
        if (mdp.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
            
        }
        try {            
            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "test", "test");
            Statement s = c.createStatement();
            PreparedStatement i = c.prepareStatement("SELECT * FROM registration WHERE full_name = ?");
            i.setString(1, id.getText());
            ResultSet r = i.executeQuery();
            
            while (r.next()) {
                pass = r.getString("password");
                

                if (pass.equals(mdp.getText())){
                    Stage stage = (Stage)id.getScene().getWindow();
                    ChangerPage page = new ChangerPage(stage);
                    page.go_to("../view/Accueil_Utilisateur.fxml");
                        
                }
                else{
                    showAlert(Alert.AlertType.ERROR, owner, "ERROR!",
                        "mdp ou identifiant erroné " + mdp.getText() + " " + pass);
                }
            }
            r.close();
            s.close();
            c.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(pass == null && !mdp.getText().isEmpty() && !id.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "ERROR!",
                    "pas de compte existant");
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


