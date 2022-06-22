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


public class Stats_Gci_controller1 {

    @FXML
    private PieChart pieChart0;

    @FXML
    private PieChart pieChart1;

    @FXML
    private PieChart pieChart2;

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
        ObservableList<PieChart.Data> oList0 = requestDB();

        this.pieChart0.setData(oList0);

        showSliceData(oList0);
    }

    @FXML
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
    void retour(ActionEvent event) {
        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Choix_espece_stats.fxml");
    }

    @FXML
    void btn(ActionEvent event) throws SQLException, ClassNotFoundException {
        this.initialize();
    }

    //Create a method to request the database
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