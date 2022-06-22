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
    private PieChart pieChart0;

    @FXML
    private PieChart pieChart1;

    @FXML
    private PieChart pieChart2;

    @FXML
    private PieChart pieChart3;

    @FXML
    private Button home;

    @FXML
    private Button refresh;

    @FXML
    private Button retour;

    @FXML
    private Label label;

    @FXML
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
    void retour(ActionEvent event) {
        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/Choix_espece_stats.fxml");
    }

    @FXML
    void btn(ActionEvent event) throws SQLException, ClassNotFoundException {
        this.initialize();
    }

    //Create a method to request the database
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