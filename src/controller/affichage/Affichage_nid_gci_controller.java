package controller.affichage;

import modele.donnee.Nid_Gci;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.sql.DriverManager;

public class Affichage_nid_gci_controller {


    @FXML
    /**
     * ComboBox for the number of rows to display
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
    private TableView<Nid_Gci> table;

    @FXML
    /**
     * The table column in the fxml file for the id
     */
    private TableColumn<Nid_Gci,Integer> id;

    @FXML 
    /**
     * The table column in the fxml file for the reason of the end  of the observation
     */
    private TableColumn<Nid_Gci,Integer> raisonArretObservation;
  
    /**
     * The textField
     */
    @FXML private TextField delete;

    @FXML
    /**
     * The table column in the fxml file for the number of flies
     */
    private TableColumn<Nid_Gci, Integer> nbEnvols;

    @FXML
    /**
     * The table column in the fxml file for the number of protections
     */
    private TableColumn<Nid_Gci, Integer> protection;

    @FXML
    /**
     * The table column in the fxml file for the type of bague for a male
     */
    private TableColumn<Nid_Gci, String> bagueMale;

    @FXML
    /**
     * The table column in the fxml file for the type of bague for a female
     */
    private TableColumn<Nid_Gci,String> bagueFemelle;

    @FXML
    /**
     * The table column in the fxml file the name of the beach
     */
    private TableColumn<Nid_Gci,String> nomPlage;

    /**
     * ObservableList for the Gci nests
     */
    public ObservableList<Nid_Gci> data = FXCollections.observableArrayList();

    /**
     * Second ObservableList for the Gci nests
     */
    public ObservableList<Nid_Gci> data1 = FXCollections.observableArrayList();

    @FXML 
    /**
     * Fill the table with the data from the database
     * @param limite the number of Gci nests to display
     */
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
    /**
     * If the correct key is typed
     * @param e event
     */
    public void keyDelete(KeyEvent e){

        if(e.getCode() == KeyCode.ENTER){
            delete_obs();
        }


    }
    /**
     * Take text in textfield and delete the row with the id typed
     */
    @FXML
    public void delete_obs(){
        if (delete.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Erreur!",
                "Entré un nombre");
            
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            PreparedStatement stat = c.prepareStatement("DELETE FROM Obs_GCI WHERE leNid  = ?");
            PreparedStatement stat2 = c.prepareStatement("DELETE FROM Nid_GCI WHERE idNid = ?");
            stat.setString(1,delete.getText());
            stat2.setString(1,delete.getText());
            int row = stat.executeUpdate();
            int row2 = stat2.executeUpdate();
            //ResultSet rs = stat.executeQuery();
            c.close();
            viewNidGci(25);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Method who create the message and show it in the screen
     * @param alertType Type of the Alert (CONFIRMATION OR ERROR)
     * @param owner Window of the Alert
     * @param title Title of the message screen
     * @param message Message who appear in screen
     */
    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
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

            change.go_to("../../view/Accueil_Admin.fxml");
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


        this.viewNidGci(this.limite.getValue());
    }

}
