package controller;

import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modele.donnee.Observateur;
import java.sql.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Consulte_Compte_controller {

    @FXML
    /**
     * The table view in the fxml file for the admins
     */
    private TableView <Observateur> table1;

    @FXML
    /**
     * The table view in the fxml file for the users
     */
    private TableView <Observateur> table2;

    @FXML
    /**
     * The table column in the fxml file for the name of the admin
     */
    private  TableColumn<Observateur,String> colonneAdmin;

    @FXML
    /**
     * The table column in the fxml file for the id of the admin
     */
    private  TableColumn<Observateur,Integer> colonneAdminId;

    @FXML
    /**
     * The table column in the fxml file for the name of the user
     */
    private TableColumn<Observateur,String> colonneUser;

    @FXML
    /**
     * The table column in the fxml file for the user id
     */
    private  TableColumn<Observateur,Integer> colonneUserId;

    @FXML
    /**
     * The button in the fxml file 
     */
    private Button user;

    @FXML
    /**
     * The button in the fxml file 
     */
    private Button effectuer;

    @FXML
    /**
     * Maximal number of rows to display in the table
     */
    private int limite;

    /**
     * ObservableList of observators
     */
    public ObservableList<Observateur> data = FXCollections.observableArrayList();

    /**
     * ObservableList of places
     */
    public ObservableList<Observateur> data2 = FXCollections.observableArrayList();

    

    @FXML
    /**
     * Fill the table with the data from the database
     * @param limite the maximal number of rows to display in the table
     */
    public void viewAdmin(){

        table1.getItems().clear();

        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Observateur JOIN registration ON id = idObservateur WHERE administration = 1";

            PreparedStatement stat = c.prepareStatement(sql);

            ResultSet rs = stat.executeQuery();
            
            while(rs.next()){
                //data.add(new Batracien(id, date, heure, lieu, observateurs)
                //ArrayList array = new ArrayList<int>(rs3.getInt());
                if(rs.getString(2) == null){

                    data.add(new Observateur(rs.getInt(1),"null",rs.getString(3)));

                }else{

                    data.add(new Observateur(rs.getInt(1),rs.getString(2),rs.getString(3)));

                }
            }
            c.close();
            stat.close();
            rs.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        colonneAdmin.setCellValueFactory(new PropertyValueFactory<Observateur,String>("nom"));
        colonneAdminId.setCellValueFactory(new PropertyValueFactory<Observateur,Integer>("id"));
        table1.setItems(data);
    }

    @FXML 
    public void viewUser(){
        table2.getItems().clear();

        try{
            table2.getItems().clear();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            String sql = "SELECT * FROM Observateur JOIN registration ON id = idObservateur WHERE administration = 0";
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while(rs.next()){
                //data.add(new Observation(rs.getInt(1),rs.getDate(2),rs.getTime(3),rs.getDouble(4)));
                if(rs.getString(2) == null){

                    data2.add(new Observateur(rs.getInt(1),"null",rs.getString(3)));
                    

                }else{

                    data2.add(new Observateur(rs.getInt(1),rs.getString(2),rs.getString(3)));

                }
            }
            c.close();
            stat.close();
            rs.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        colonneUser.setCellValueFactory(new PropertyValueFactory<Observateur,String>("nom"));
        colonneUserId.setCellValueFactory(new PropertyValueFactory<Observateur,Integer>("id"));
        table2.setItems(data2);
    }


    @FXML
    /**
     * Initialize the tables with the users and the possible numbers of rows to display
     */
    private void initialize(){

        ObservableList<Integer> liste = FXCollections.observableArrayList(1, 25, 50, 100, ReadInfos.getMax("observateur"));
        //limite.setItems(liste);

        this.viewAdmin();
        this.viewUser();
    }

    @FXML
    /**
     * Define the limit of rows to display in the table
     */
    private void changeLimit(){


        this.viewAdmin();
        this.viewUser();
    }

    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Admin.fxml");

    }

    /**
     * When a button linked to "addAccount" is pressed
     * Switch to the page Formulaire_observateur.fxml
     */
    public void addAccount(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_observateur.fxml");
    }
}
