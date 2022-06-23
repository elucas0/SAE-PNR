package controller.affichage;
import controller.Consulte_Compte_controller;
import controller.utilitaires.ChangerPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modele.donnee.Aobserve;
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
    private TableView<Aobserve> tabePricipale;

    @FXML
    private TableColumn<Aobserve,Integer> idObservateur;
    @FXML
    private TableColumn<Aobserve,Integer> idObservation;

    /**
     * ObservableList of observators
     */
    public ObservableList<Aobserve> data = FXCollections.observableArrayList();

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
    public void viewAobserve(int limite){

        tabePricipale.getItems().clear();
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM aobserve WHERE lobservateur = " + Consulte_Compte_controller.getId() + " LIMIT " + limite;
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                data.add(new Aobserve(rs.getInt(1), rs.getInt(2)));
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        idObservateur.setCellValueFactory(new PropertyValueFactory<Aobserve,Integer>("idObservateur"));
        idObservation.setCellValueFactory(new PropertyValueFactory<Aobserve,Integer>("idObservation"));
        tabePricipale.setItems(data);
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page choix_stat_liste.fxml
    */
    public void retour(){
        Stage actuel = (Stage)home.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/exempleCompte.fxml");
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
