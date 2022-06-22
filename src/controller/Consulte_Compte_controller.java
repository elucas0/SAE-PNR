package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.sql.*;
import javafx.scene.control.MenuButton;
import javafx.scene.paint.Color;

public class Consulte_Compte_controller {

    @FXML
    private  VBox adminPane;

    @FXML
    private VBox userPane;

    @FXML
    private Button user;

    @FXML
    private Button effectuer;



    @FXML
    private void initialize(){

        user.setText(ReadInfos.getStatus());
    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private ArrayList<String> getUsers(){
        ArrayList<String> resultatUser = new ArrayList<String>();
        try {
            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT full_name FROM registration WHERE administration = 0";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                resultatUser.add(r.getString("full_name"));
                
            }
            //Suppression des virgules
            resultatUser.toString().replaceAll(",", " ");

            //System.out.println(resultatUser.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultatUser;
    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private ArrayList<String> getAdmin(){
        ArrayList<String> resultatAdmin = new ArrayList<String>();
        try {
            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT full_name FROM registration WHERE administration = 1";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                resultatAdmin.add(r.getString("full_name"));
                
            }
            //Suppression des virgules
            resultatAdmin.toString().replaceAll(",", " ");

            //System.out.println(resultat.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultatAdmin;
    }

    public void affichageUser(){
        ArrayList<String> resultatUser = getUsers();
        for (String user : resultatUser) {
            Button usr = new Button(user);
            userPane.getChildren().add(usr);
        }
    }


    /**
    * Event to do when the button retour is pressed.    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Admin.fxml");

    }


    public void addAccount(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_observateur.fxml");
    }
}
