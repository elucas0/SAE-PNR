package controller;

import modele.donnee.Nid_Gci;

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

import java.sql.DriverManager;

public class Affichage_nid_gci_controller {


    @FXML
    private ComboBox<Integer> limite;

    @FXML
    /**
     * The retour button in the fxml file
     */
    private Button retour;

    @FXML 
    private TableView<Nid_Gci> table;

    @FXML 
    private TableColumn<Nid_Gci,Integer> id;

    @FXML 
    private TableColumn<Nid_Gci,Integer> raisonArretObservation;

    @FXML 
    private TableColumn<Nid_Gci, Integer> nbEnvols;

    @FXML 
    private TableColumn<Nid_Gci, Integer> protection;

    @FXML 
    private TableColumn<Nid_Gci, String> bagueMale;

    @FXML 
    private TableColumn<Nid_Gci,String> bagueFemelle;

    @FXML 
    private TableColumn<Nid_Gci,String> nomPlage;




    public ObservableList<Nid_Gci> data = FXCollections.observableArrayList();

    public ObservableList<Nid_Gci> data1 = FXCollections.observableArrayList();

    @FXML 
    public void viewNidGci(int limite){

        table.getItems().clear();
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM nid_Gci ORDER BY idNid LIMIT " + limite;
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            
            while(rs.next()){
                //data.add(new Batracien(id, date, heure, lieu, observateurs)
                //ArrayList array = new ArrayList<int>(rs3.getInt());
                data.add(new Nid_Gci(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6),  rs.getString(7)));
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory<Nid_Gci,Integer>("idNid"));

        nomPlage.setCellValueFactory(new PropertyValueFactory<Nid_Gci, String>("plage"));
        raisonArretObservation.setCellValueFactory(new PropertyValueFactory<Nid_Gci, Integer>("raisonArretObservation"));
        nbEnvols.setCellValueFactory(new PropertyValueFactory<Nid_Gci,Integer>("nbEnvols"));
        bagueMale.setCellValueFactory(new PropertyValueFactory<Nid_Gci, String>("bagueMale"));
        bagueFemelle.setCellValueFactory(new PropertyValueFactory<Nid_Gci,String>("bagueFemelle"));
        protection.setCellValueFactory(new PropertyValueFactory<Nid_Gci,Integer>("protection"));


        table.setItems(data);
    }


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize()  {

        ObservableList<Integer> liste = FXCollections.observableArrayList(1, 25, 50, 100, ReadInfos.getMax("nid_gci"));
        limite.setItems(liste);

        this.viewNidGci(25);
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
        change.go_to("../view/Affichage_lieu.fxml");

    }

    public void affichage_batracien(){
        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_batracien.fxml");  
    }


    public void affichage_loutre(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_loutre.fxml");       
    }


    public void affichage_gci(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_obs_gci.fxml");       
    }

    public void affichage_nid_gci(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_nid_gci.fxml");       
    }

    public void affichage_hippocampe(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_hippocampe.fxml");       
    }


    public void affichage_chouette(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_chouette.fxml");       
    }

    @FXML
    private void changeLimit(){


        this.viewNidGci(this.limite.getValue());
    }

    
}
