package controller.affichage;
import modele.donnee.ObservationGci;
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
import modele.donnee.Lieu;

import java.sql.DriverManager;

public class Affichage_obs_gci_controller {


    @FXML
    private ComboBox<Integer> limite;

    @FXML
    /**
     * The retour button in the fxml file
     */
    private Button retour;

    @FXML 
    private TableView<ObservationGci> table;

    @FXML 
    private TableColumn<ObservationGci,Integer> id;

    @FXML 
    private TableColumn<ObservationGci,String> nature;

    @FXML 
    private TableColumn<ObservationGci, Integer> nombre;

    @FXML 
    private TableColumn<ObservationGci,String> observateur;

    @FXML 
    private TableColumn<ObservationGci, Integer> leNid;

    @FXML 
    private TableColumn<ObservationGci,String> presentMaisNonObs;


    @FXML 
    private TableColumn<ObservationGci,Date> date ;

    @FXML 
    private TableColumn<ObservationGci,Time> heure ;

    @FXML 
    private TableColumn<ObservationGci,Lieu> coordX ;

    @FXML 
    private TableColumn<ObservationGci,Lieu> coordY ;

    public ObservableList<ObservationGci> data = FXCollections.observableArrayList();

    public ObservableList<ObservationGci> data1 = FXCollections.observableArrayList();

    @FXML 
    public void viewObsGci(int limite){

        table.getItems().clear();
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Obs_Gci ORDER BY obsG LIMIT " + limite;
            String sql2 = "SELECT dateObs,heureObs,lieu_lambert_X, lieu_Lambert_Y FROM observation, Obs_Gci WHERE idObs = obsG ORDER BY idObs LIMIT " + limite;
            String sql3 = "SELECT lobservateur FROM observation,Obs_Gci, AObserve, observateur WHERE lobservateur=idObservateur AND idObs = obsG AND lobservation=idObs ORDER BY idObs";
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            PreparedStatement stat2= c.prepareStatement(sql2);
            ResultSet rs2 = stat2.executeQuery();
            PreparedStatement stat3= c.prepareStatement(sql3);
            ResultSet rs3 = stat3.executeQuery();
            
            while(rs.next()&& rs2.next()&&rs3.next()){
                //data.add(new Batracien(id, date, heure, lieu, observateurs)
                //ArrayList array = new ArrayList<int>(rs3.getInt());
                data.add(new ObservationGci(rs.getInt(1),rs2.getDate(1),rs2.getTime(2), rs2.getDouble(3), rs2.getDouble(4),rs3.getInt(1), rs.getString("nature"), rs.getInt("nombre"), rs.getInt("leNid"), rs.getInt("presentMaisNonObs")));
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory<ObservationGci,Integer>("id"));
        date.setCellValueFactory(new PropertyValueFactory<ObservationGci,Date>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<ObservationGci,Time>("heure"));
        coordX.setCellValueFactory(new PropertyValueFactory<ObservationGci,Lieu>("coordX"));
        coordY.setCellValueFactory(new PropertyValueFactory<ObservationGci,Lieu>("coordY"));
        observateur.setCellValueFactory(new PropertyValueFactory<ObservationGci, String>("observateur"));
        nature.setCellValueFactory(new PropertyValueFactory<ObservationGci, String>("natureObs"));
        nombre.setCellValueFactory(new PropertyValueFactory<ObservationGci,Integer>("nombre"));
        presentMaisNonObs.setCellValueFactory(new PropertyValueFactory<ObservationGci,String>("presentMaisNonObs"));
        leNid.setCellValueFactory(new PropertyValueFactory<ObservationGci,Integer>("leNid"));

        table.setItems(data);
    }


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize()  {

        ObservableList<Integer> liste = FXCollections.observableArrayList(1, 25, 50, 100, ReadInfos.getMax("obs_gci"));
        limite.setItems(liste);

        this.viewObsGci(25);
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
    private void changeLimit(){


        this.viewObsGci(this.limite.getValue());
    }
    
}
