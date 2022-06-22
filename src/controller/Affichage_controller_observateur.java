package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modele.donnee.Lieu;
import modele.donnee.Observateur;

import java.sql.DriverManager;

public class Affichage_controller_observateur {
    
    @FXML
    private ComboBox<Integer> limite;

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

    @FXML 
    private TableColumn<Observateur,String> prenom;
   // @FXML private TableColumn<Observateur,> date;
   // @FXML private TableColumn<Observateur,Time> heure;
    @FXML 
    private TableColumn<Lieu,Double> coordx;

    @FXML 
    private TableColumn<Lieu,Double> coordy;

    public ObservableList<Observateur> data = FXCollections.observableArrayList();

    public ObservableList<Lieu> data1 = FXCollections.observableArrayList();

    @FXML 
    public void viewObservation(int limite){
        try{
            table.getItems().clear();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Observateur LIMIT " + limite;
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
        id.setCellValueFactory(new PropertyValueFactory<Observateur,Integer>("id"));
        //date.setCellValueFactory(new PropertyValueFactory<Observation,Date>("date"));
        //heure.setCellValueFactory(new PropertyValueFactory<Observation,Time>("heure"));
        nom.setCellValueFactory(new PropertyValueFactory<Observateur,String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Observateur,String>("prenom"));
        table.setItems(data);
    }


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize()  {

        ObservableList<Integer> liste = FXCollections.observableArrayList(1, 25, 50, 100);
        limite.setItems(liste);

        this.viewObservation(25);
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


    public void affichage_observateur(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_observateur.fxml");

    }

    public void affichage_lieu(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_Lieu.fxml");

    }

    public void affichage_batracien(){}


    public void affichage_loutre(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        //change.go_to("../view/Affichage_loutre.fxml");       
    }


    public void affichage_gci(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        //change.go_to("../view/Affichage_loutre.fxml");       
    }

    public void affichage_hippocampe(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        //change.go_to("../view/Affichage_loutre.fxml");       
    }


    public void affichage_chouette(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        //change.go_to("../view/Affichage_loutre.fxml");       
    }

    @FXML
    private void changeLimit(){


        this.viewObservation(this.limite.getValue());
    }


    
}
