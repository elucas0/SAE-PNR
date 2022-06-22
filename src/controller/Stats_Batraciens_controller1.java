package controller;

import java.sql.SQLException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;


public class Stats_Batraciens_controller1 {

    @FXML
    private BarChart<String, Number> barChartBatracien;

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
        barChartBatracien.getData().clear();
        XYChart.Series<String, Number> series = requestDB();
        series.setName("Nombre de batraciens");
        barChartBatracien.getData().add(series);
    }
    //Create a method to request the database
    public XYChart.Series<String, Number> requestDB() throws SQLException, ClassNotFoundException {

        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        PreparedStatement i = c.prepareStatement("SELECT meteo_ciel, COUNT(obsB) FROM obs_batracien GROUP BY meteo_ciel");
        ResultSet rs = i.executeQuery();
        while (rs.next()) {
            if((rs.getString("meteo_ciel")!=null) && (rs.getString("COUNT(obsB)")!=null)){
                String nomMeteo = rs.getString("meteo_ciel");
                int nombreBatraciens = rs.getInt("COUNT(obsB)");
                series.getData().add(new XYChart.Data<String, Number>(nomMeteo, nombreBatraciens));
            }
        }
        rs.close();
        s.close();
        c.close();  
        return series;
    }

}
