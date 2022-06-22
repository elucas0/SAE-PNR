package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.sql.*;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;

/**
 * The controller for compte view
 */
public class Exemple_Compte_controller {

    @FXML
    /**
     * The account button in the fxml file
     */
    private Button user;

    @FXML
    /**
     * The button to delete the account the account
     */
    private Button delete;

    @FXML
    /**
     * The retour button in the fxml file
     */
    private Button back;

    @FXML
    /**
     * The button to display the history of the account
     */
    private Button history;

    @FXML
    private Label description;


    @FXML
    /**
     * Initialize elements when the fxml file is displayed
     */
    private void initialize(){
       //description.setText("admin");

        //user.setText(ReadInfos.getStatus());
    }

    @FXML
    /**
     * Event to do when the button delete is pressed.
     * Delete the account from the database
     */
    public void deleteUser(){
        try {

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();

            String query = "DELETE FROM registration WHERE id = " + Consulte_Compte_controller.getId() + ";";
            s.executeQuery(query);

            String query2 = "DELETE FROM Observateur WHERE idObservateur = " + Consulte_Compte_controller.getId() + ";";
            s.executeQuery(query2);

            s.close();
            c.close();
            Stage actuel = (Stage)user.getScene().getWindow();
            ChangerPage change = new ChangerPage(actuel);
            if(Consulte_Compte_controller.getId() == ReadInfos.getId()){
                change.go_to("../view/page_loging.fxml");
            }
            else{
                change.go_to("../view/consulteCompte.fxml");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Event to do when the button retour is pressed.    
     * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){
        Stage actuel = (Stage)back.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/consulteCompte.fxml");

    }

    /**
     * Event to do when the button history is pressed.
     * Switch to the page Affichage_historique.fxml
     */
    public void historique(){
        Stage actuel = (Stage)back.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/affichages/Affichage_historique.fxml");
    }
}
