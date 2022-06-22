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
import modele.donnee.Lieu;
import modele.donnee.Loutre;
import modele.donnee.ObsLoutre;
import modele.donnee.Observateur;

import java.sql.DriverManager;

public class Affichage_controller_loutre {
    
    @FXML
    /**
     * The combo box in the fxml file that allows to select the number of observations to display
     */
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
    private TableView<Loutre> table;

    @FXML 
    /**
     * The table column in the fxml file for the id
     */
    private TableColumn<Loutre,Integer> id;

    @FXML
    /**
     * The table column in the fxml file for the name of the observator
     */
    private TableColumn<Loutre,String> nom;

    @FXML 
    /**
     * The table column in the fxml file for the name of the city
     */
    private TableColumn<Loutre,String> commune;
    
    @FXML 
    /**
     * The table column in the fxml file for the name of the place
     */
    private TableColumn<Loutre,String> lieudit;
    
    @FXML
    /**
     * The table column in the fxml file for the indicator of the presence
     */
    private TableColumn<Loutre,String> indice;
    
    @FXML
    /**
     * The table column in the fxml file for the date
     */
    private TableColumn<Loutre,Date> date;
    
    @FXML
    /**
     * The table column in the fxml file for the time
     */
     private TableColumn<Loutre,Time> heure;
    
    @FXML
    /**
     * The table column in the fxml file for the x coordinate
     */
    private TableColumn<Loutre,Double> x;

    @FXML
    /**
     * The table column in the fxml file for the y coordinate
     */
    private TableColumn<Loutre,Double> y;

    public ObservableList<Loutre> data = FXCollections.observableArrayList();


    @FXML
    /**
     * Fill the table with the data from the database
     */
    public void viewObservation(){
        try{
            table.getItems().clear();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Obs_Loutre";
            String sql2 = "SELECT dateObs,heureObs,lieu_lambert_X, lieu_Lambert_Y FROM Obs_Loutre,Observation WHERE idObs=ObsL";
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            PreparedStatement stat2 = c.prepareStatement(sql2);
            ResultSet rs2 = stat2.executeQuery();
            while(rs.next() && rs2.next()){
                //data.add(new Observation(rs.getInt(1),rs.getDate(2),rs.getTime(3),rs.getDouble(4)));
                    data.add(new Loutre(rs.getInt(1), rs2.getDate(1), rs2.getTime(2),rs2.getDouble(3), rs2.getDouble(4), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory<Loutre,Integer>("id"));
        date.setCellValueFactory(new PropertyValueFactory<Loutre,Date>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<Loutre,Time>("heure"));
        x.setCellValueFactory(new PropertyValueFactory<Loutre,Double>("coordx"));
        y.setCellValueFactory(new PropertyValueFactory<Loutre,Double>("coordy"));
        indice.setCellValueFactory(new PropertyValueFactory<Loutre,String>("indice"));
        lieudit.setCellValueFactory(new PropertyValueFactory<Loutre,String>("lieudit"));
        commune.setCellValueFactory(new PropertyValueFactory<Loutre,String>("commune"));
        table.setItems(data);
    }


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
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
