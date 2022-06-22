package controller.statistiques;

import java.sql.SQLException;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


public class Stats_Hippocampes_controller1 {

    @FXML
    /**
     * PieChart from the fxml file to display the statistics of the owls
     */
    private PieChart pieChart0;

    @FXML
    /**
     * Second PieChart from the fxml file to display the statistics of the owls
     */
    private PieChart pieChart1;

    @FXML
    /**
     * Third PieChart from the fxml file to display the statistics of the owls
     */
    private PieChart pieChart2;

    @FXML
    /**
     * Fourth PieChart from the fxml file to display the statistics of the owls
     */
    private PieChart pieChart3;

    @FXML
    /**
     * Button from the fxml file to get back to the home page
     */
    private Button home;

    @FXML
    /**
     * Button from the fxml file to refresh the data
     */
    private Button refresh;

    @FXML
    /**
     * Button from the fxml file to get back to the previous page
     */
    private Button retour;

    @FXML
    /**
     * Label from the fxml file to display the value of the slice selected by the user
     */
    private Label label;

    @FXML
     /**
     * Initialize the controller class and set the pie charts
     * @throws ClassNotFoundException if the driver is not found
     * @throws SQLException if the connection is not established
     */
    public void initialize() throws ClassNotFoundException, SQLException{
        this.pieChart0.getData().clear();
        this.pieChart1.getData().clear();
        this.pieChart2.getData().clear();
        this.pieChart3.getData().clear();

        ObservableList<PieChart.Data> oList0 = requestDB("Entelurus aequoreus");
        ObservableList<PieChart.Data> oList1 = requestDB("Hippocampus guttulatus");
        ObservableList<PieChart.Data> oList2 = requestDB("Hippocampus hippocampus");
        ObservableList<PieChart.Data> oList3 = requestDB("Syngnathus acus");

        this.pieChart0.setData(oList0);
        this.pieChart1.setData(oList1);
        this.pieChart2.setData(oList2);
        this.pieChart3.setData(oList3);


        showSliceData(oList0, "Entelurus aequoreus");
        showSliceData(oList1, "Hippocampus guttulatus");
        showSliceData(oList2, "Hippocampus hippocampus");
        showSliceData(oList3, "Syngnathus acus");
    }

    @FXML
    /**
     * When a button linked to "home" is clicked, the user is redirected to the home page
     */
    public void home(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../../view/Accueil_Utilisateur.fxml");
        }
    }

    @FXML
    /**
     * When a button linked to "retour" is pressed
     * Switch to the page Choix_espece_stats.fxml
     * @param event The event that is triggered
     */
    void retour(ActionEvent event) {
        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/Choix_espece_stats.fxml");
    }

    @FXML
    /**
     * When a button linked to "btn" is pressed
     * Refresh the page with the new data
     * @param event the event
     * @throws SQLException the SQL exception
     * @throws ClassNotFoundException the class not found exception
     */
    void btn(ActionEvent event) throws SQLException, ClassNotFoundException {
        this.initialize();
    }

    /**
     * Returns a ObservableList for a given species using an SQL request
     * @param species the species to request
     * @return an ObservableList
     * @throws SQLException if the SQL request fails
     * @throws ClassNotFoundException if the class is not found
     */
    public ObservableList<PieChart.Data> requestDB(String species) throws SQLException, ClassNotFoundException {

        ObservableList<PieChart.Data> oList = FXCollections.observableArrayList();

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        PreparedStatement i = c.prepareStatement("SELECT espece, sexe, COUNT(*) FROM obs_hippocampe WHERE espece = '" + species + "'  GROUP BY espece, sexe");
        ResultSet rs = i.executeQuery();
        while (rs.next()) {
            String sexe = rs.getString("sexe");
            int nombre = rs.getInt("COUNT(*)");
            oList.add(new PieChart.Data(sexe, nombre));
        }
        rs.close();
        s.close();
        c.close();
        return oList;
    }

    /**
     * Returns the total number of observations of a given species
     * @param species the species
     * @return the number of observations
     * @throws SQLException if the SQL request fails
     * @throws ClassNotFoundException if the class is not found
     */
    public int getNombreObs(String species) throws SQLException, ClassNotFoundException {

        int nombre = 0;

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        PreparedStatement i = c.prepareStatement("SELECT COUNT(*) FROM obs_hippocampe WHERE espece = '" + species + "'");
        ResultSet rs = i.executeQuery();
        while (rs.next()) {
            nombre = rs.getInt("COUNT(*)");
        }
        rs.close();
        s.close();
        c.close();
        return nombre;
    }

    /**
     * Sets the label to the value of the clicked slice
     * @param oList the list of data
     * @param species the species of the slice
     */
    public void showSliceData(ObservableList<PieChart.Data> oList, String species){
        for(PieChart.Data data : oList){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    try {
                        label.setText("Valeur sélectionnée : " + String.valueOf(data.getPieValue() / getNombreObs(species) * 100) + "%");
                        System.out.println(data.getPieValue());
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}