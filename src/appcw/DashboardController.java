/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcw;
/**
 *
 * @author Abdi Ismail
 */
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ABDI-
 */
public class DashboardController implements Initializable {
    public dataConn dataConn = new dataConn();
    @FXML
    private Label isConnected;
    @FXML
    private PieChart Piechart;
    @FXML
    private AreaChart<String, Double> AreaChart;
    @FXML
    private BarChart<String, Double> LineChart;
    private Connection connextion;
    @FXML
    private BarChart<?, ?> Barchart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        if (dataConn.isDbConnected()) {
//            isConnected.setText("Status: Connected");
//        } else {
//            isConnected.setText("Status: Not Connected");
//        }
        
        
        
        initPieChart();
        initAreaChart();
        initBarChart();
        loadChart();
    }    
    private void initPieChart(){
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
                new PieChart.Data("Participant",935),
                new PieChart.Data("Coordinator",65)

                
                
                
        );
        Piechart.setData(data);
    }
    private void initBarChart(){
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("US",19));
        set1.getData().add(new XYChart.Data("UK",106));
        set1.getData().add(new XYChart.Data("BE",27));
        set1.getData().add(new XYChart.Data("DE",157));
        set1.getData().add(new XYChart.Data("ES",88));
        set1.getData().add(new XYChart.Data("FR",107));
        set1.getData().add(new XYChart.Data("IT",91));
        set1.getData().add(new XYChart.Data("NL",74));
        Barchart.getData().addAll(set1);
        
    }
    private void initAreaChart(){
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("IT",99975.0));
        set1.getData().add(new XYChart.Data("NL",999724.0));
        set1.getData().add(new XYChart.Data("FR",99922.0));
        set1.getData().add(new XYChart.Data("ES",99125.0));
        set1.getData().add(new XYChart.Data("FI",990900.0));
        AreaChart.getData().addAll(set1);
    }
    private void loadChart(){
        String query = "jdbc:sqlite.data.sqlite";
        XYChart.Series<String,Double> series = new XYChart.Series<>();
        try{
            connectDB();
                ResultSet ra = connextion.createStatement().executeQuery(query);
                while (ra.next()){
                    series.getData().add(new XYChart.Data<>(ra.getString(1), ra.getDouble(2)));
                }
            AreaChart.getData().add(series);
        }catch (Exception e) {
        
        
    }
    
    }
    
    public class dataConn {
        Connection connection1;
        public dataConn(){
            connection1 = SqliteConnection.Connector();
        if (connection1 == null) {
            System.out.println("Connection not successful");
            System.exit(1);                     
        }
        }
        public boolean isDbConnected() {
            try {
            return !connection1.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
    
    }
    
    private Connection connectDB(){
        try {
        String dbString ="data.sqlite";
        String user = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(dbString,user,password);
            System.out.println("Connecton = true");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    
}
