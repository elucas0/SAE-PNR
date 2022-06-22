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
import modele.donnee.Observateur;

import java.sql.*;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.donnee.Lieu;

import java.sql.DriverManager;

public class Consulte_Compte_controller {

    @FXML
    private TableView <Observateur> table1;

    @FXML
    private  TableColumn<Observateur,String> colonneAdmin;

    @FXML
    private TableView <Observateur> table2;

    @FXML
    private TableColumn<Observateur,String> colonneUser;

    @FXML
    private Button user;

    @FXML
    private Button effectuer;

    

    public ObservableList<Observateur> data = FXCollections.observableArrayList();
    public ObservableList<Observateur> data2 = FXCollections.observableArrayList();

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

    @FXML 
    public void viewAdmin(int limite){
        try{
            table1.getItems().clear();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Observateur JOIN registration ON id = idObservateur WHERE administration = 1 LIMIT " + limite;
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                //data.add(new Observation(rs.getInt(1),rs.getDate(2),rs.getTime(3),rs.getDouble(4)));
                if(rs.getString(2) == null){

                    data.add(new Observateur(rs.getInt(1),"null",rs.getString(3)));


                }else{

                    data.add(new Observateur(rs.getInt(1),rs.getString(2),rs.getString(3)));

                }
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //id.setCellValueFactory(new PropertyValueFactory<Observateur,Integer>("id"));
        //date.setCellValueFactory(new PropertyValueFactory<Observation,Date>("date"));
        //heure.setCellValueFactory(new PropertyValueFactory<Observation,Time>("heure"));
        colonneAdmin.setCellValueFactory(new PropertyValueFactory<Observateur,String>("nom"));
        //prenom.setCellValueFactory(new PropertyValueFactory<Observateur,String>("prenom"));
        table1.setItems(data);
    }

    @FXML 
    public void viewUser(int limite){
        try{
            table2.getItems().clear();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Observateur JOIN registration ON id = idObservateur WHERE administration = 1 LIMIT " + limite;
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                //data.add(new Observation(rs.getInt(1),rs.getDate(2),rs.getTime(3),rs.getDouble(4)));
                if(rs.getString(2) == null){

                    data2.add(new Observateur(rs.getInt(1),"null",rs.getString(3)));


                }else{

                    data2.add(new Observateur(rs.getInt(1),rs.getString(2),rs.getString(3)));

                }
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //id.setCellValueFactory(new PropertyValueFactory<Observateur,Integer>("id"));
        //date.setCellValueFactory(new PropertyValueFactory<Observation,Date>("date"));
        //heure.setCellValueFactory(new PropertyValueFactory<Observation,Time>("heure"));
        colonneUser.setCellValueFactory(new PropertyValueFactory<Observateur,String>("nom"));
        //prenom.setCellValueFactory(new PropertyValueFactory<Observateur,String>("prenom"));
        table2.setItems(data2);
    }

/*
    @FXML
    private void initialize(){

        ObservableList<Integer> liste = FXCollections.observableArrayList(1, 25, 50, 100, ReadInfos.getMax("observateur"));
        limite.setItems(liste);

        this.viewAdmin(25);
    }

    @FXML
    private void changeLimit(){


        this.viewObservation(this.limite.getValue());
    }
*/


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
