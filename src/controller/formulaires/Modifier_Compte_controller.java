package controller.formulaires;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Consulte_Compte_controller;
import controller.utilitaires.ChangerPage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    private void initialize(){


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

                PreparedStatement modifierCompte = c.prepareStatement("SELECT * FROM aobserve WHERE lobservateur = ? AND lobservation = ?");

                ResultSet resultatAObserve = modifierCompte.executeQuery();

                if(resultatAObserve.next()){
                    showAlert(Alert.AlertType.ERROR, owner, "Observation", "Observateur déjà rentré pour cette observation!");
                }
                else{
                    String s = "UPDATE registration SET nom = " + nom.getText() + ", password = " + mdp.getText() +" WHERE id = " + Consulte_Compte_controller.getId() + ";";
                    PreparedStatement querry1 = c.prepareStatement(s);
                    querry1.executeUpdate();
                    showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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