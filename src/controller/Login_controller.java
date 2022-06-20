package controller;

import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.sql.*;
/**Class to connect people in the application */
public class Login_controller {   

    @FXML
    /**
     * Text fiel for the username
     */
    private TextField id;

    @FXML
    /**
     * Text fiel for the password
     */
    private PasswordField mdp;

    @FXML
    /**
     * Button to create the connexion
     */
    private Button bouton_connexion;

    @FXML
    /**
     * Method who check if the username and the password is good
     * @throws SQLException
     */
    public void connect() throws SQLException {
        String pass = null;
        Window owner = bouton_connexion.getScene().getWindow();
        //test si l'identifiant n'est pas renseigné
        if (id.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            
        }
        //test si le mot de passe n'est pas renseigné
        if (mdp.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
            
        }
        try {            
            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            PreparedStatement i = c.prepareStatement("SELECT * FROM registration WHERE full_name = ?");
            i.setString(1, id.getText());
            ResultSet r = i.executeQuery();
            
            while (r.next()) {
                pass = r.getString("password");
                
                //test si le mot de passe correspond a l'utilisateur
                if (pass.equals(mdp.getText())){
                    Stage stage = (Stage)id.getScene().getWindow();
                    ChangerPage page = new ChangerPage(stage);
                    //redirige sur la page utilisateur
                    if(r.getInt("administration") == 0){
                        page.go_to("../view/Accueil_Utilisateur.fxml");
                    }
                    //redirige sur la page administrateur
                    else{
                        page.go_to("../view/Accueil_Admin.fxml");
                    }
                    
                        
                }
                //test mot de passe correspond pas a l'identifiant
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
        //Test s'il n'y a pas de compte crée pour cet identifiant et ce mot de passe
        if(pass == null && !mdp.getText().isEmpty() && !id.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "ERROR!",
                    "pas de compte existant");
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


    public void keyConnect(KeyEvent e){

        if(e.getCode() == KeyCode.ENTER){
            try {
                this.connect();
            } catch (SQLException e1) {

                e1.printStackTrace();
            }
        }


    }
}


