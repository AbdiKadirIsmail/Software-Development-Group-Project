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
import static java.awt.SystemColor.window;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import static javafx.fxml.FXMLLoader.load;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ABDI-
 */
public class SidebarController implements Initializable {

    @FXML
    private Button btnDashbaord;
    @FXML
    private Button btnAccount;
    @FXML
    private Button Admin;
    @FXML 
    private javafx.scene.control.Button closeButton;
    @FXML
    private Button btnLogout1;
    

    /**
     * Initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openDashboard(ActionEvent event) {
//           try {
//            DashboardViewController.temporaryPane.getChildren().clear();
//            StackPane pane2=FXMLLoader.load(getClass().getResource());
//            ObservableList<Node> elements = pane2.getChildren();
//            DashboardViewController.temporaryPane.getChildren().setAll(elements);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(SidebarController.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    
        try {
            DashboardViewController.temporaryPane.getChildren().clear();
            StackPane pane2=FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            ObservableList<Node> elements = pane2.getChildren();
            DashboardViewController.temporaryPane.getChildren().setAll(elements);
            
        } catch (IOException ex) {
            Logger.getLogger(SidebarController.class.getName()).log(Level.SEVERE, null, ex);
    
    } 
           
        
    
    
    

//    @FXML
//    private void Signin(ActionEvent event) {
//                   try {
//            DashboardViewController.temporaryPane.getChildren().clear();
//            StackPane pane2=FXMLLoader.load(getClass().getResource("LoginView.fxml"));
//            ObservableList<Node> elements = pane2.getChildren();
//            DashboardViewController.temporaryPane.getChildren().setAll(elements);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(SidebarController.class.getName()).log(Level.SEVERE, null, ex);
//   
//    
//    }
//         try {
//            DashboardViewController.temporaryPane.getChildren().clear();
//            StackPane pane2=FXMLLoader.load(getClass().getResource("LoginView.fxml"));
//            ObservableList<Node> elements = pane2.getChildren();
//            DashboardViewController.temporaryPane.getChildren().setAll(elements);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(SidebarController.class.getName()).log(Level.SEVERE, null, ex);
//    
//    } 
            
    
    }

//    @FXML
//    private void openRegister(ActionEvent event) {
//          try {
//            ((Node) event.getSource()).getScene().getWindow().hide();
//            Stage stage = new Stage();
//            FXMLLoader loader = new FXMLLoader();
//            Pane root = loader.load(getClass().getResource("RegisterAccountView.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//        }
//        }
//            try {
//            DashboardViewController.temporaryPane.getChildren().clear();
//            StackPane pane2=FXMLLoader.load(getClass().getResource("RegisterAccountView.fxml"));
//            ObservableList<Node> elements = pane2.getChildren();
//            DashboardViewController.temporaryPane.getChildren().setAll(elements);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(SidebarController.class.getName()).log(Level.SEVERE, null, ex);
//    
//    } 
//    }

    @FXML
    private void openAccount(ActionEvent event) {
//          try {
//            ((Node) event.getSource()).getScene().getWindow().hide();
//            Stage stage = new Stage();
//            FXMLLoader loader = new FXMLLoader();
//            Pane root = loader.load(getClass().getResource("Account.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//
//        }
        try {
            DashboardViewController.temporaryPane.getChildren().clear();
            StackPane pane2=FXMLLoader.load(getClass().getResource("Account.fxml"));
            ObservableList<Node> elements = pane2.getChildren();
            DashboardViewController.temporaryPane.getChildren().setAll(elements);
            
        } catch (IOException ex) {
            Logger.getLogger(SidebarController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void openAdmin(ActionEvent event) {
//          try {
//            ((Node) event.getSource()).getScene().getWindow().hide();
//            Stage stage = new Stage();
//            FXMLLoader loader = new FXMLLoader();
//            Pane root = loader.load(getClass().getResource("Admin.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//
//        }
          try {
            DashboardViewController.temporaryPane.getChildren().clear();
            StackPane pane2=FXMLLoader.load(getClass().getResource("AdminView.fxml"));
            ObservableList<Node> elements = pane2.getChildren();
            DashboardViewController.temporaryPane.getChildren().setAll(elements);
            
        } catch (IOException ex) {
            Logger.getLogger(SidebarController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        
    }
    @FXML
    private void openLogout(ActionEvent event) {
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
    
    private void exit(ActionEvent event) {
       
}
        
    
    
       
    
    private void StackPane(String pane){
            try {
            DashboardViewController.temporaryPane.getChildren().clear();
            StackPane pane2=FXMLLoader.load(getClass().getResource(pane));
            ObservableList<Node> elements = pane2.getChildren();
            DashboardViewController.temporaryPane.getChildren().setAll(elements);
            
        } catch (IOException ex) {
            Logger.getLogger(SidebarController.class.getName()).log(Level.SEVERE, null, ex);
    }
    } 

    @FXML
    private void closeButtonAction(ActionEvent event) {
        // get a handle to the stage
    Stage stage = (Stage) closeButton.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
        
    
   
    
    
}
