package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modele.donnee.Observateur;
import java.sql.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import modele.donnee.User;

public class Consulte_Compte_controller {

    @FXML
    private TableView <User> table1;

    @FXML
    private TableView <User> table2;

    @FXML
    private  TableColumn<User,String> colonneAdmin;

    @FXML
    private TableColumn<User,String> colonneUser;

    @FXML
    private  TableColumn<Observateur,Integer> colonneUserId;

    @FXML
    private Button user;

    @FXML
    private Button effectuer;

    @FXML
    private int limite;

    

    @FXML 
    public void viewUser(){

        table1.getItems().clear();
        table2.getItems().clear();

        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM registration WHERE administration = 1";
            String sql2 = "SELECT * FROM registration WHERE administration = 0";

            PreparedStatement stat = c.prepareStatement(sql);
            PreparedStatement stat2 = c.prepareStatement(sql2);

            ResultSet rs = stat.executeQuery();
            ResultSet rs2 = stat2.executeQuery();

            
            while(rs.next()){
                //data.add(new Batracien(id, date, heure, lieu, observateurs)
                //ArrayList array = new ArrayList<int>(rs3.getInt());
                data.add(new User(rs.getInt(1), rs.getString(2), rs.getInt(4)));
            }
            while(rs2.next()){
                //data.add(new Batracien(id, date, heure, lieu, observateurs)
                //ArrayList array = new ArrayList<int>(rs3.getInt());
                data2.add(new User(rs2.getInt(1), rs2.getString(2), rs2.getInt(4)));
            }
            c.close();
            stat.close();
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML 
    public void viewUser(int limite){
        try{
            table2.getItems().clear();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Observateur JOIN registration ON id = idObservateur WHERE administration = 0 LIMIT " + limite;
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
        colonneUser.setCellValueFactory(new PropertyValueFactory<Observateur,String>("nom"));
        colonneUserId.setCellValueFactory(new PropertyValueFactory<Observateur,Integer>("id"));
        table2.setItems(data2);
    }


    @FXML
    private void initialize(){

        ObservableList<Integer> liste = FXCollections.observableArrayList(1, 25, 50, 100, ReadInfos.getMax("observateur"));
        //limite.setItems(liste);

        this.viewAdmin(25);
        this.viewUser(25);
    }

    @FXML
    private void changeLimit(){


        this.viewAdmin(this.limite);
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
