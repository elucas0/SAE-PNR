package controller.affichage;
import controller.utilitaires.ChangerPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modele.donnee.Observation;
import java.sql.*;

/**
 * The controller of the page Affichage_Historique.fxml. It manages it.
 * @version 1.0
 */
public class Affichage_Historique_controller {

    /**
     * The page's home button
     */
    @FXML
    private Button home;

    /**
     * The page's home button
     */
    @FXML
    private Button user;

    /**
     * The page's go back button
     */
    @FXML
    private Button retour; 

    @FXML
    private TableView<Observation> tabePricipale;

    @FXML
    private TableColumn<Observation,Integer> id;
    @FXML
    private TableColumn<Observation,Double> date;
    @FXML
    private TableColumn<Observation,String> heure;
    @FXML
    private TableColumn<Observation,Double> lieuX;
    @FXML
    private TableColumn<Observation,Double> lieuY;

    /**
     * ObservableList of observators
     */
    public ObservableList<Observation> data = FXCollections.observableArrayList();

    /**
     * The content to do when the page linked to is started
     */
    @FXML
    private void initialize() 
    {

    }
    /**
     * Fill the table with the data from the database
     * @param limite the number of rows to display
     */
    public void viewLieu(int limite){

        tabePricipale.getItems().clear();
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Observation LIMIT " + limite;
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                //data.add(new Observation(rs.getInt(1),rs.getDate(2),rs.getTime(3),rs.getDouble(4)));

                if((rs.getDouble(4) != 0.0) && (rs.getDouble(5) != 0.0)){

                    data.add(new Observation(rs.getInt(1), rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5)));
                }
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        coordx.setCellValueFactory(new PropertyValueFactory<Lieu,Double>("coordX"));
        coordy.setCellValueFactory(new PropertyValueFactory<Lieu,Double>("coordY"));
        table.setItems(data1);
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page choix_stat_liste.fxml
    */
    public void retour(){
        Stage actuel = (Stage)home.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/exempleCompte.fxml");
    }

    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void home(){
        Stage actuel = (Stage)home.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/Accueil_Admin.fxml");
    }
    
    
}
