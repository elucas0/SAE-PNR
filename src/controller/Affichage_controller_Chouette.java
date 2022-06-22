package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modele.donnee.Chouette;
import modele.donnee.Hippocampe;
import modele.donnee.Loutre;
import modele.donnee.OChouette;

import java.sql.DriverManager;

public class Affichage_controller_Chouette {
    
    @FXML
    /**
     * Combo box to select the number of rows to display
     */
    private ComboBox<Integer> limite;

    @FXML
    /**
     * The retour button in the fxml file
     */
    private Button retour;

    /**
     * The table view in the fxml file
     */
    @FXML 
    private TableView<OChouette> table;

    @FXML
    /**
     * The table column in the fxml file for the id
     */
    private TableColumn<OChouette,Integer> numobs ;

    @FXML
    /**
     * The table column in the fxml file for id of the animal
     */
    private TableColumn<OChouette,String> lenumindividu ;

    @FXML
    /**
     * The table column in the fxml file for the name of type of observation
     */
    private TableColumn<OChouette,String> typeobs;

    @FXML
    /**
     * The table column in the fxml file for the genre
     */
    private TableColumn<OChouette,String> sexe;

    @FXML
    /**
     * The table column in the fxml file for the species
     */
    private TableColumn<OChouette,String> espece;

    @FXML
    /**
     * The table column in the fxml file for the date of the observation
     */
    private TableColumn<OChouette,Date> date;

    @FXML
    /**
     * The table column in the fxml file for the time of the observation
     */
    private TableColumn<OChouette,Time> heure;

    @FXML
    /**
     * The table column in the fxml file for the x coordinate
     */
    private TableColumn<OChouette,Double> x;

    @FXML
    /**
     * The table column in the fxml file for the type of protocole used
     */
    private TableColumn<OChouette,Integer> protocole ;

    @FXML
    /**
     * The table column in the fxml file for the y coordinate
     */
    private TableColumn<OChouette,Double> y;

    /**
     * Observable list for the owl observations
     */
    public ObservableList<OChouette> data = FXCollections.observableArrayList();


    @FXML
    /**
     * Fill the table with the data from the database
     */
    public void viewObservation(){
        try{
            table.getItems().clear();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT numObs,protocole,typeObs,leNumIndividu,espece,sexe FROM Obs_Chouette,Chouette";
            String sql2 = "SELECT dateObs,heureObs,lieu_lambert_X, lieu_Lambert_Y FROM Obs_Hippocampe,Observation WHERE idObs=ObsH";
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            PreparedStatement stat2 = c.prepareStatement(sql2);
            ResultSet rs2 = stat2.executeQuery();
            while(rs.next() && rs2.next()){
                //int id, Date date, Time heure,  Double coordx ,Double coordy,int protocole, String typeObs,String lenumIndividu,String espece,String sexe
                    data.add(new OChouette(rs.getInt(1), rs2.getDate(1), rs2.getTime(2),rs2.getDouble(3), rs2.getDouble(4), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)));
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        numobs.setCellValueFactory(new PropertyValueFactory<OChouette,Integer>("id"));
        date.setCellValueFactory(new PropertyValueFactory<OChouette,Date>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<OChouette,Time>("heure"));
        x.setCellValueFactory(new PropertyValueFactory<OChouette,Double>("coordx"));
        y.setCellValueFactory(new PropertyValueFactory<OChouette,Double>("coordy"));
        lenumindividu.setCellValueFactory(new PropertyValueFactory<OChouette,String>("LenumIndividu"));
        typeobs.setCellValueFactory(new PropertyValueFactory<OChouette,String>("TypeObs"));
        sexe.setCellValueFactory(new PropertyValueFactory<OChouette,String>("sexe"));
        espece.setCellValueFactory(new PropertyValueFactory<OChouette,String>("espece"));
        protocole.setCellValueFactory(new PropertyValueFactory<OChouette,Integer>("Protocole"));
        table.setItems(data);
    }


    @FXML
    /**
     * Initialize elements when the fxml file is displayed
     */
    private void initialize()  {

        //ObservableList<Integer> liste = FXCollections.observableArrayList(1, 25, 50, 100);
        //limite.setItems(liste);

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

    /**
     * When a button linked to "affichage_observateur" is pressed
     * Switch to the page affichage_observateur.fxml
     */
    public void affichage_observateur(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_observateur.fxml");

    }

    /**
     * When a button linked to "affichage_lieu" is pressed
     * Switch to the page affichage_lieu.fxml
     */
    public void affichage_lieu(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage_Lieu.fxml");

    }

    /**
     * When a button linked to "affichage_batracien" is pressed
     * Switch to the page affichage_batracien.fxml
     */
    public void affichage_batracien(){}


    /**
     * When a button linked to "affichage_loutre" is pressed
     * Switch to the page affichage_loutre.fxml
     */
    public void affichage_loutre(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        //change.go_to("../view/Affichage_loutre.fxml");       
    }

    /**
     * When a button linked to "affichage_gci" is pressed
     * Switch to the page affichage_gci.fxml
     */
    public void affichage_gci(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        //change.go_to("../view/Affichage_loutre.fxml");       
    }

    /**
     * When a button linked to "affichage_hippocampe" is pressed
     * Switch to the page affichage_hippocampe.fxml
     */
    public void affichage_hippocampe(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        //change.go_to("../view/Affichage_loutre.fxml");       
    }

    /**
     * When a button linked to "affichage_chouette" is pressed
     * Switch to the page affichage_chouette.fxml
     */
    public void affichage_chouette(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        //change.go_to("../view/Affichage_loutre.fxml");       
    }

}
