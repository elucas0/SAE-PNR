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

/**
 * Controller of the page Stats_Gci_1.fxml
 * Displays the statistics of the Gci
 * @version 1.2
 */
public class Stats_Gci_controller1 {

    @FXML
    /**
     * PieChart from the fxml file to display the statistics of the Gci
     */
    private PieChart pieChart0;

    @FXML
    /**
     * Second PieChart from the fxml file to display the statistics of the Gci
     */
    private PieChart pieChart1;

    @FXML
    /**
     * Third PieChart from the fxml file to display the statistics of the Gci
     */
    private PieChart pieChart2;

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
     * Label from the fxml file to display value of the slice selected by the user
     */
    private Label label;

    @FXML
    /**
     * Initialize the controller class and set the pie chart
     * @throws ClassNotFoundException if the driver is not found
     * @throws SQLException if the connection is not established
     */
    public void initialize() throws ClassNotFoundException, SQLException{
        this.pieChart0.getData().clear();
        ObservableList<PieChart.Data> oList0 = requestDB();

        this.pieChart0.setData(oList0);

        showSliceData(oList0);
    }

    @FXML
    /**
     * When a button linked to "home" is clicked, the user is redirected to the home page
     */
    public void home(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
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
        change.go_to("../view/Choix_espece_stats.fxml");
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
     * Returns a ObservableList using an SQL request
     * @return an ObservableList
     * @throws SQLException if the SQL request fails
     * @throws ClassNotFoundException if the class is not found
     */
    public ObservableList<PieChart.Data> requestDB() throws SQLException, ClassNotFoundException {

        ObservableList<PieChart.Data> oList = FXCollections.observableArrayList();

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        PreparedStatement i = c.prepareStatement("SELECT nomPlage, COUNT(*) FROM nid_gci GROUP BY nomPlage");
        ResultSet rs = i.executeQuery();
        while (rs.next()) {
            String nomPlage = rs.getString("nomPlage");
            int nombre = rs.getInt("COUNT(*)");
            oList.add(new PieChart.Data(nomPlage, nombre));
        }
        rs.close();
        s.close();
        c.close();  
        return oList;
    }

    /**
     * Returns the total number of observations
     * @return the number of observations
     * @throws SQLException if the SQL request fails
     * @throws ClassNotFoundException if the class is not found
     */
    public int getNombreObs() throws SQLException, ClassNotFoundException {

        int nombre = 0;

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        PreparedStatement i = c.prepareStatement("SELECT COUNT(*) FROM nid_gci");
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
     */
    public void showSliceData(ObservableList<PieChart.Data> oList){
        for(PieChart.Data data : oList){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    try {
                        label.setText("Valeur sélectionnée : " + String.valueOf(data.getPieValue() / getNombreObs() * 100) + "%");
                        System.out.println(data.getPieValue());
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}