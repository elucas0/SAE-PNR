import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class Graphics_Stats_controller {

    @FXML private LineChart<String, Number> lineChart;

    @FXML
    void handleClose(ActionEvent event) {

    }

    @FXML
    void handleShowBarChart(ActionEvent event) {

    }

    @FXML
    void handleShowPieChart(ActionEvent event) {

    }

    @FXML
    void handleUpdateData(ActionEvent event) {

    }

    public void btn(ActionEvent event) {
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
        series.getData().add(new XYChart.Data<String, Number>("Feb", 500));
        series.getData().add(new XYChart.Data<String, Number>("Mar", 300));
        series.getData().add(new XYChart.Data<String, Number>("Apr", 600));
        lineChart.getData().add(series);
    }

}
