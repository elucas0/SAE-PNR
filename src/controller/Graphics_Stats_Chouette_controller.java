package controller;

import java.sql.SQLException;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


public class Graphics_Stats_Chouette_controller {

    @FXML
    private PieChart pieChart1;

    @FXML
    private Button home;

    @FXML
    private Button refresh;

    @FXML
    private Button retour;


    @FXML
    public void home(){

        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.readAdmin() == true){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }

    @FXML
    void retour(ActionEvent event) {
        Stage actuel = (Stage)retour.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/choix_stat_liste.fxml");
    }

    @FXML
    void btn(ActionEvent event) throws SQLException, ClassNotFoundException {
        pieChart1.getData().clear();
        ObservableList<PieChart.Data> oList = requestDB();
        pieChart1.setData(oList);
    }
    //Create a method to request the database
    public ObservableList<PieChart.Data> requestDB() throws SQLException, ClassNotFoundException {

        ObservableList<PieChart.Data> oList = FXCollections.observableArrayList();

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        PreparedStatement i = c.prepareStatement("SELECT espece, typeObs, COUNT(*) FROM obs_chouette JOIN chouette ON leNumIndividu = numIndividu GROUP BY espece, typeObs");
        ResultSet rs = i.executeQuery();
        while (rs.next()) {
            if((rs.getString("espece")=="Effraie") && (rs.getString("typeObs")!=null)){
                String nomEspece = rs.getString("espece");
                String typeObs = rs.getString("typeObs");
                int nombre = rs.getInt("COUNT(*)");
                //Get the percentage of the pie chart
                double percentage = ((double)nombre * this.getNombreObs())/100;
                oList.add(new PieChart.Data(nomEspece + " " + typeObs, percentage));
            }
        }
        rs.close();
        s.close();
        c.close();  
        return oList;
    }

    //Return the result of the request SELECT COUNT(*) FROM obs_chouette
    public int getNombreObs() throws SQLException, ClassNotFoundException {

        int nombre = 0;

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        PreparedStatement i = c.prepareStatement("SELECT COUNT(*) FROM obs_chouette");
        ResultSet rs = i.executeQuery();
        while (rs.next()) {
            nombre = rs.getInt("COUNT(*)");
        }
        rs.close();
        s.close();
        c.close();
        return nombre;
    }

}
