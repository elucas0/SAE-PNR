package controller.formulaires;

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

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
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
    private Button user;

    @FXML
    void initialize(){

        liste = FXCollections.observableArrayList("Oui", "Non");
        estAdmin.setItems(liste);
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
        if (idCompte.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
        }
        else if (mdp.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
        }
    
        else if (nom.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
        }
        else if (prenom.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
        }
        else if (estAdmin.getValue().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
        }

        else{

        
            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
                Statement ObservateurController = c.createStatement();

                int admin = -1;
                if (estAdmin.getValue().equals(("oui"))){
                    admin = 1;
                }
                else{
                    admin = 0;
                }


                PreparedStatement testRegistration = c.prepareStatement("SELECT * FROM registration WHERE id = ? AND full_name = ? AND password = ? AND administration = ?");
                testRegistration.setString(1, idCompte.getText());
                testRegistration.setString(2, prenom.getText());
                testRegistration.setString(3, mdp.getText());
                testRegistration.setInt(4, admin);
                ResultSet resultatRegistration = testRegistration.executeQuery();

                if(resultatRegistration.next()){
                    showAlert(Alert.AlertType.ERROR, owner, "Registration", "Compte déjà créée!");
                }
                else{
                    String querry1 = "INSERT INTO registration VALUES(" + idCompte.getText() + ",'" + prenom.getText() + "','" + mdp.getText() + "','" + admin + "');";
                    ObservateurController.executeUpdate(querry1);
                    showAlert(Alert.AlertType.CONFIRMATION, owner, "Observateur", "rentré!");
                }
                
                PreparedStatement testObservateur = c.prepareStatement("SELECT * FROM Observateur WHERE nom = ? AND prenom = ?");
                testObservateur.setString(1, nom.getText());
                testObservateur.setString(2, prenom.getText());
                ResultSet resultatObservateur = testObservateur.executeQuery();

                if(resultatObservateur.next()){
                    showAlert(Alert.AlertType.ERROR, owner, "Observateur", "Observateur déjà rentré!");
                }
                else{
                    String querry3 = "INSERT INTO Observateur (nom,prenom) VALUES('" + nom.getText() + "', '" + prenom.getText() + "');";
                    ObservateurController.executeUpdate(querry3);
                    showAlert(Alert.AlertType.CONFIRMATION, owner, "Observateur", "rentré!");

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
        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/ConsulteCompte.fxml");

    }
}
