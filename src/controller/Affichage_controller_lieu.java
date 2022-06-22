package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modele.RequeteObservation;
import modele.donnee.Lieu;
import modele.donnee.Observateur;
import modele.donnee.Observation;
import javafx.fxml.Initializable;
import java.sql.DriverManager;

public class Affichage_controller_lieu {
    

    @FXML
    /**
     * The retour button in the fxml file
     */
    private Button retour;

    @FXML 
    private TableView<Lieu> table;
    @FXML private TableColumn<Lieu,Double> coordx;
    @FXML private TableColumn<Lieu,Double> coordy;
    public ObservableList<Lieu> data1 = FXCollections.observableArrayList();
    @FXML 

    public void viewLieu(){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Lieu LIMIT 25";
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                //data.add(new Observation(rs.getInt(1),rs.getDate(2),rs.getTime(3),rs.getDouble(4)));
                data1.add(new Lieu(rs.getDouble(1),rs.getDouble(2)));
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        coordx.setCellValueFactory(new PropertyValueFactory<Lieu,Double>("coordX"));
        coordy.setCellValueFactory(new PropertyValueFactory<Lieu,Double>("coordY"));
        table.setItems(data1);
    }


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize()  {
        viewLieu();
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page choix_stat_liste.fxml
    */
    public void retour(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/choix_stat_liste.fxml");
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void home(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.readAdmin() == true){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }


    
}
