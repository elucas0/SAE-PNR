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

public class Affichage_controller_observateur {
    

    @FXML
    /**
     * The retour button in the fxml file
     */
    private Button retour;

    @FXML 
    private TableView<Observateur> table;
    @FXML 
    private TableColumn<Observateur,Integer> id;
    @FXML 
    private TableColumn<Observateur,String> nom;
    @FXML private TableColumn<Observateur,String> prenom;
   // @FXML private TableColumn<Observateur,> date;
   // @FXML private TableColumn<Observateur,Time> heure;
    @FXML private TableColumn<Lieu,Double> coordx;
    @FXML private TableColumn<Lieu,Double> coordy;
    public ObservableList<Observateur> data = FXCollections.observableArrayList();
    public ObservableList<Lieu> data1 = FXCollections.observableArrayList();
    @FXML 
    public void viewObservation(){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Observateur LIMIT 25";
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                //data.add(new Observation(rs.getInt(1),rs.getDate(2),rs.getTime(3),rs.getDouble(4)));
                data.add(new Observateur(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory<Observateur,Integer>("id"));
        //date.setCellValueFactory(new PropertyValueFactory<Observation,Date>("date"));
        //heure.setCellValueFactory(new PropertyValueFactory<Observation,Time>("heure"));
        coordx.setCellValueFactory(new PropertyValueFactory<Lieu,Double>("coordX"));
        coordy.setCellValueFactory(new PropertyValueFactory<Lieu,Double>("coordY"));
        nom.setCellValueFactory(new PropertyValueFactory<Observateur,String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Observateur,String>("prenom"));
        table.setItems(data);
    }


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize()  {
        viewObservation();
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
        if(ReadInfos.estAdmin() == true){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }


    
}
