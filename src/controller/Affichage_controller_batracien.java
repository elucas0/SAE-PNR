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
import modele.donnee.Batracien;
import modele.donnee.Lieu;
import modele.donnee.ObsBatracien;
import modele.donnee.Observateur;
import modele.donnee.Observation;
import javafx.fxml.Initializable;
import java.sql.DriverManager;

public class Affichage_controller_batracien {
    

    @FXML
    /**
     * The retour button in the fxml file
     */
    private Button retour;

    @FXML 
    private TableView<Batracien> table;
    @FXML 
    private TableColumn<Batracien,Integer> id ;
    @FXML 
    private TableColumn<Batracien,Date> date ;
    @FXML private TableColumn<Batracien,Time> heure ;
    @FXML private TableColumn<Batracien,Lieu> lieu ;
    @FXML private TableColumn<Batracien,Integer> observateurs ;
    @FXML private TableColumn<ObsBatracien,String> resObs ;
    @FXML private TableColumn<ObsBatracien,String> lEspece ;
    @FXML 
    private TableColumn<ObsBatracien,String> meteo_ciel  ;
    @FXML 
    private TableColumn<ObsBatracien,String> meteo_temp  ;
    @FXML 
    private TableColumn<ObsBatracien,String> meteo_vent  ;
    @FXML 
    private TableColumn<ObsBatracien,String> meteo_pluie  ;
    @FXML private TableColumn<ObsBatracien,Integer> concerne_zh ;
    @FXML private TableColumn<ObsBatracien,Integer> concernes_vege;
    public ObservableList<Batracien> data = FXCollections.observableArrayList();
    //public ObservableList<Lieu> data1 = FXCollections.observableArrayList();
    @FXML 

    public void viewObservation(){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT obsB FROM Obs_Batracien ORDER BY obsB LIMIT 25";
            String sql2 = "SELECT dateObs,heureObs,lieu_lambert_X, lieu_Lambert_Y FROM observation, Obs_Batracien WHERE idObs = obsB ORDER BY idObs LIMIT 25";
            String sql3 = "SELECT lobservateur FROM observation,Obs_Batracien,AObserve,observateur WHERE lobservateur=idObservateur AND idObs = obsB AND lobservation=idObs ORDER BY idObs LIMIT 25";
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            PreparedStatement stat2= c.prepareStatement(sql2);
            ResultSet rs2 = stat2.executeQuery();
            PreparedStatement stat3= c.prepareStatement(sql3);
            ResultSet rs3 = stat3.executeQuery();
            
            while(rs.next()&& rs2.next()&&rs3.next()){
                //data.add(new Batracien(id, date, heure, lieu, observateurs)
                //ArrayList array = new ArrayList<int>(rs3.getInt());
                data.add(new Batracien(rs.getInt(1),rs2.getDate(1),rs2.getTime(2),new Lieu(rs2.getDouble(3), rs2.getDouble(4)),rs3.getInt(1)));
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory<Batracien,Integer>("id"));
        date.setCellValueFactory(new PropertyValueFactory<Batracien,Date>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<Batracien,Time>("heure"));
        lieu.setCellValueFactory(new PropertyValueFactory<Batracien,Lieu>("Lieu"));
        observateurs.setCellValueFactory(new PropertyValueFactory<Batracien,Integer>("observateurs"));
     /*nombretetard.setCellValueFactory(new PropertyValueFactory<ObsBatracien,Integer>("nombretetard"));
     temperature.setCellValueFactory(new PropertyValueFactory<ObsBatracien,Double>("temperature"));
        meteo_ciel.setCellValueFactory(new PropertyValueFactory<ObsBatracien,String>("meteo_ciel"));
        meteo_temp.setCellValueFactory(new PropertyValueFactory<ObsBatracien,String>("meteo_temp"));
        meteo_vent.setCellValueFactory(new PropertyValueFactory<ObsBatracien,String>("meteo_vent"));
        meteo_pluie.setCellValueFactory(new PropertyValueFactory<ObsBatracien,String>("meteo_pluie"));
        concerne_zh.setCellValueFactory(new PropertyValueFactory<ObsBatracien,Integer>("concerne_zh"));
        concernes_vege.setCellValueFactory(new PropertyValueFactory<ObsBatracien,Integer>("concernes_vege"));*/
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
