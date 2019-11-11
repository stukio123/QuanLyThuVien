package quanlythuvien2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class FXMLThongKeController implements Initializable {

    @FXML
    private AreaChart areaChart ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Tháng");
 
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Lượng Sách (quyển)");
        areaChart = new AreaChart(xAxis,yAxis);        
 
        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName("Lượng mưa trung bình TPHCM");
    }    
    
}
