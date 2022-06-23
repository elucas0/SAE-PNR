package controller.affichage;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.Time;



import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modele.donnee.Batracien;
import modele.donnee.Lieu;

import java.sql.DriverManager;

public class Affichage_controller_batracien {
    
    @FXML
    private ComboBox<Integer> limite;


    @FXML
    /**
     * The retour button in the fxml file
     */
    private Button retour;

    @FXML
    /**
     * The table in the fxml file
     */
    private TableView<Batracien> table;

    @FXML
    /**
     * The table column in the fxml file for the id
     */
    private TableColumn<Batracien,Integer> id ;

    @FXML
    /**
     * The table column in the fxml file for the date of the observation
     */
    private TableColumn<Batracien,Date> date ;

    @FXML
    /**
     * The table column in the fxml file for the time of the observation
     */
    private TableColumn<Batracien,Time> heure ;

    @FXML
    /**
     * The table column in the fxml file for the x coordinate of the observation
     */
    private TableColumn<Batracien,Lieu> coordX ;

    @FXML
    /**
     * The table column in the fxml file for the y coordinate of the observation
     */
    private TableColumn<Batracien,Lieu> coordY ;

    @FXML
    /**
     * The table column in the fxml file for the type of the name of the observator
     */
    private TableColumn<Batracien,Integer> observateur;

    @FXML
    /**
     * The table column in the fxml file
     */
    private TableColumn<Batracien,String> resObs ;

    @FXML 
    /**
     * The table column in the fxml file for the species
     */
    private TableColumn<Batracien,String> espece ;

    @FXML
    /**
     * The table column in the fxml file for the number of adults
     */
    private TableColumn<Batracien,Integer> adulte; 

    @FXML
    /**
     * The table column in the fxml file for the number of reproductives
     */
    private TableColumn<Batracien,Integer> amplexus;

    @FXML
    /**
     * The table column in the fxml file for the number of births
     */
    private TableColumn<Batracien,Integer> ponte;

    @FXML
    /**
     * The table column in the fxml file for the number of juveniles
     */
    private TableColumn<Batracien,Integer> tetards;

    /**
     * Observable list of Batracien
     */
    public ObservableList<Batracien> data = FXCollections.observableArrayList();

    @FXML 
    /**
     * Fill the table with the data from the database
     * @param limite the number of rows to display
     */
    public void viewObservation(int limite){

        table.getItems().clear();
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Obs_Batracien ORDER BY obsB LIMIT " + limite;
            String sql2 = "SELECT dateObs,heureObs,lieu_lambert_X, lieu_Lambert_Y FROM observation, Obs_Batracien WHERE idObs = obsB ORDER BY idObs LIMIT " + limite;
            String sql3 = "SELECT lobservateur FROM observation,Obs_Batracien,AObserve,observateur WHERE lobservateur=idObservateur AND idObs = obsB AND lobservation=idObs ORDER BY idObs";
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            PreparedStatement stat2= c.prepareStatement(sql2);
            ResultSet rs2 = stat2.executeQuery();
            PreparedStatement stat3= c.prepareStatement(sql3);
            ResultSet rs3 = stat3.executeQuery();
            
            while(rs.next()&& rs2.next()&&rs3.next()){
                //data.add(new Batracien(id, date, heure, lieu, observateurs)
                //ArrayList array = new ArrayList<int>(rs3.getInt());
                data.add(new Batracien(rs.getInt(1),rs2.getDate(1),rs2.getTime(2), rs2.getDouble(3), rs2.getDouble(4),rs3.getInt(1), rs.getString("espece"), rs.getInt("nombreAdultes"), rs.getInt("nombreAmplexus"), rs.getInt("nombreTetard"), rs.getInt("nombrePonte")));
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory<Batracien,Integer>("id"));
        date.setCellValueFactory(new PropertyValueFactory<Batracien,Date>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<Batracien,Time>("heure"));
        coordX.setCellValueFactory(new PropertyValueFactory<Batracien,Lieu>("coordX"));
        coordY.setCellValueFactory(new PropertyValueFactory<Batracien,Lieu>("coordY"));
        observateur.setCellValueFactory(new PropertyValueFactory<Batracien,Integer>("observateurs"));
        espece.setCellValueFactory(new PropertyValueFactory<Batracien, String>("espece"));
        tetards.setCellValueFactory(new PropertyValueFactory<Batracien,Integer>("nombreTetard"));
        adulte.setCellValueFactory(new PropertyValueFactory<Batracien,Integer>("nombreAdultes"));
        amplexus.setCellValueFactory(new PropertyValueFactory<Batracien,Integer>("nombreAmplexus"));
        ponte.setCellValueFactory(new PropertyValueFactory<Batracien,Integer>("nombrePonte"));

        table.setItems(data);
    }
    

    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize()  {
        viewObservation(25);
        ObservableList<Integer> liste = FXCollections.observableArrayList(1, 25, 50, 100, ReadInfos.getMax("obs_batracien"));
        limite.setItems(liste);
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page choix_stat_liste.fxml
    */
    public void retour(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/choix_stat_liste.fxml");
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

            change.go_to("../../view/Accueil_Utilisateur.fxml");
        }
    }

    /**
     * When a button linked to "affichage_observateur" is pressed
     * Switch to the page affichage_observateur.fxml
     */
    public void affichage_observateur(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/affichage/Affichage_observateur.fxml");

    }

    /**
     * When a button linked to "affichage_lieu" is pressed
     * Switch to the page affichage_lieu.fxml
     */
    public void affichage_lieu(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/affichage/Affichage_Lieu.fxml");

    }

    /**
     * When a button linked to "affichage_batracien" is pressed
     * Switch to the page affichage_batracien.fxml
     */
    public void affichage_batracien(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/affichage/Affichage_batracien.fxml");       
    }


    /**
     * When a button linked to "affichage_loutre" is pressed
     * Switch to the page affichage_loutre.fxml
     */
    public void affichage_loutre(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/affichage/Affichage_loutre.fxml");       
    }

    /**
     * When a button linked to "affichage_gci" is pressed
     * Switch to the page affichage_gci.fxml
     */
    public void affichage_gci(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/affichage/Affichage_obs_gci.fxml");       
    }

    /**
     * When a button linked to "affichage_hippocampe" is pressed
     * Switch to the page affichage_hippocampe.fxml
     */
    public void affichage_hippocampe(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/affichage/Affichage_hippocampe.fxml");       
    }

    /**
     * When a button linked to "affichage_chouette" is pressed
     * Switch to the page affichage_chouette.fxml
     */
    public void affichage_chouette(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/affichage/Affichage_chouette.fxml");       
    }

    public void affichage_nid_gci(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/affichage/Affichage_nid_gci.fxml"); 
    }

    @FXML
    /**
     * Sets the value of the limite combobox
     */
    private void changeLimit(){

        this.viewObservation(this.limite.getValue());
    }


    
}
