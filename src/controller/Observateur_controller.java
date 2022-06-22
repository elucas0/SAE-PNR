package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.sql.SQLException;
import java.time.LocalTime;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import java.sql.*;

public class Observateur_controller {

    @FXML
    private ComboBox<String> estAdmin;

    private ObservableList<String> liste;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField idCompte;

    @FXML
    private TextField mdp;

    @FXML
    /**
     * Button to insert the data in the database
     */
    private Button effectuer;

    @FXML
    void initialize(){

        liste = FXCollections.observableArrayList("Oui", "Non");
        estAdmin.setItems(liste);
    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (idCompte.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
        }
        if (mdp.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
        }
    
        if (nom.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
        }
        if (prenom.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
        }
        //création de l'insert
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();

            int admin = -1;
            if (estAdmin.getValue().equals(("oui"))){
                admin = 1;
            }
            else{
                admin = 0;
            }
            String querry1 = "INSERT INTO registration VALUES(" + idCompte.getText() + ",'" + prenom.getText() + "','" + mdp.getText() + "','" + admin + "');";
            
            
            
            PreparedStatement idObs = c.prepareStatement("SELECT MAX(idObs) FROM Observateur;");
            ResultSet requete2 = idObs.executeQuery();
            requete2.next();
            int idO = requete2.getInt("Max(idObs)");

            String querry3 = "INSERT INTO Observateur VALUES(" + idO+ ", '" + nom.getText() + "', '" + prenom.getText() + "');";
            s.executeUpdate(querry1);
            s.executeUpdate(querry3);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
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


    public void retour(){
        
    }
    
}
