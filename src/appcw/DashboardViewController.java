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
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdul
 */
public class DashboardViewController implements Initializable {

    @FXML
    private Label userLoggedIn;
    @FXML
    private StackPane mainStackPane;
    @FXML
    private Pane toolbarPane;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private FontAwesomeIconView searchicon;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane contentPane;
    public static AnchorPane temporaryPane;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        temporaryPane = contentPane;
        initDrawer();
        
    }
    private void initDrawer() {
        drawer.setMinWidth(150);
        try {
            VBox menu = FXMLLoader.load(getClass().getResource(Constants.SIDEBAR));
            drawer.setSidePane(menu);
            
            HamburgerBackArrowBasicTransition transition 
                    = new HamburgerBackArrowBasicTransition(hamburger);
            
            transition.setRate(-1);
            
            hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event)->
           {
                transition.setRate(transition.getRate()*-1);
                transition.play();
                if (drawer.isOpened()){
                    drawer.close();
                }
                else{
                    drawer.open();
                }
                
            });
            
            
        } catch (IOException ex) {
            Logger.getLogger(DashboardViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    

    public void GetDashboard(String user) {
        userLoggedIn.setText(user);
    }

    public void SignOut(ActionEvent event) {
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("LoginView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {

        }

    }

}
