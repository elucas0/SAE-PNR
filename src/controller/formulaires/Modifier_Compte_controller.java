package controller.formulaires;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Consulte_Compte_controller;
import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Modifier_Compte_controller{



    @FXML
    private TextField nom;

    @FXML
    private TextField mdp;

    @FXML
    private TextField confirmerMdp;

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
        Window owner = mdp.getScene().getWindow();
        //test : textfield vide
        if (nom.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "S'il vous plaît, veuillez entrer un id d'observateur valide");

        }
        //test : textfield vide
        else if ((mdp.getText().isEmpty()) && (confirmerMdp.getText().isEmpty()) && (!mdp.getText().equals(confirmerMdp.getText()))) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "S'il vous plaît, veuillez entrer un id d'observation valide");

        }
        else{

        
            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
                String s = "UPDATE registration SET full_name = '" + nom.getText() + "', password = '" + mdp.getText() +"' WHERE id = " + Consulte_Compte_controller.getId() + ";";
                PreparedStatement querry1 = c.prepareStatement(s);
                querry1.executeUpdate();
                showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
            
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Stage actuel = (Stage)mdp.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/exempleCompte.fxml");
    }


    /**
     * Method who create the message and show it in the screen
     * @param alertType Type of the Alert (CONFIRMATION OR ERROR)
     * @param owner Window where the message is shown
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

        Stage actuel = (Stage)mdp.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/exempleCompte.fxml");


    }
}