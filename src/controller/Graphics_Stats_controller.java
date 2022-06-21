package controller;

import java.sql.SQLException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class Graphics_Stats_controller {

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    void btn(ActionEvent event) throws SQLException, ClassNotFoundException {
        lineChart.getData().clear();
        XYChart.Series<String, Number> series = requestDB();
        lineChart.getData().add(series);
    }

    //Create a method to request the database
    public XYChart.Series<String, Number> requestDB() throws SQLException, ClassNotFoundException {

        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.setName("Nombre de batraciens");

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        PreparedStatement i = c.prepareStatement("SELECT COUNT(obsB) FROM obs_batracien GROUP BY meteo_ciel");
        ResultSet rs = i.executeQuery();
        while (rs.next()) {
            series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
        }
        rs.close();
        s.close();
        c.close();  
        return series;
    }

}
