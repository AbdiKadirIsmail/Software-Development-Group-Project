/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcw;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.*;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author abdul
 */
public class LoginViewController implements Initializable {
    public LoginModel loginModel = new LoginModel();
    @FXML
    private Label isConnected;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    
    
    private Label label;
    @FXML
    private TabPane tabPaneLogin;
    @FXML
    private Tab tabAdmin;
    @FXML
    private Tab tabUser;
    @FXML
    private Label lbCreateAccount;
    @FXML
    private Pane slidePane;
    @FXML
    private Label lbAdmin;
    @FXML
    private Label lbUser;
    @FXML
    private Label lbStatus;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane anchorPane;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private JFXTextField txtUsernameU;
    @FXML
    private JFXPasswordField txtPasswordU;
    @FXML
    private Label lbCreateAccount1;
    @FXML
    private Label error_adminUsername;
    @FXML
    private Label error_adminPassword;
    @FXML
    private Label error_userUsername;
    @FXML
    private Label error_userPassword;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (loginModel.isDbConnected()) {
            isConnected.setText("Status: Connected");
        } else {
            isConnected.setText("Status: Not Connected");
        }
    }
    
    @FXML
    public void LoginAdmin(ActionEvent event) throws Exception{
        conn = SqliteConnection.Connector();
        boolean isAUsernameEmpty = validation.TextFieldValidation.isTextFieldNotEmpty(txtUsername, error_adminUsername, "Username is required");
        boolean isAPasswordEmpty = validation.TextFieldValidation.isTextFieldNotEmpty(txtPassword, error_adminPassword, "Password is required");       
        if (isAUsernameEmpty && isAPasswordEmpty) {
        String query = "select * from Accounts where username = ? and password = ?  and type = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtPassword.getText());
            pst.setString(3, lbStatus.getText());
            
            rs = pst.executeQuery();
            if (rs.next()) {
                isConnected.setText("Username and password is correct");
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("DashboardView.fxml").openStream());
                DashboardViewController dvc = (DashboardViewController)loader.getController();
                dvc.GetDashboard(txtUsername.getText());
                Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
                stage.setScene(scene);
                stage.show(); 
            } else {
                isConnected.setText("Username and/or password is invalid");
            }
        } catch (SQLException ex) {
            isConnected.setText("Username and/or password is invalid");
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
            rs.close();
        }
        }  
    }
    
    @FXML
    public void LoginUser(ActionEvent event) throws Exception{
        conn = SqliteConnection.Connector();
        boolean isUUsernameEmpty = validation.TextFieldValidation.isTextFieldNotEmpty(txtUsernameU, error_userUsername, "Username is required");
        boolean isUPasswordEmpty = validation.TextFieldValidation.isTextFieldNotEmpty(txtPasswordU, error_userPassword, "Password is required");   
        if (isUUsernameEmpty && isUPasswordEmpty) {
        String query = "select * from Accounts where username = ? and password = ? and type = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, txtUsernameU.getText());
            pst.setString(2, txtPasswordU.getText());
            pst.setString(3, lbStatus.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                isConnected.setText("Username and password is correct");
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("DashboardView.fxml").openStream());
                DashboardViewController dvc = (DashboardViewController)loader.getController();
                dvc.GetDashboard(txtUsernameU.getText());
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show(); 
            } else {
                isConnected.setText("Username and/or password is invalid");
            }
        } catch (SQLException ex) {
            isConnected.setText("Username and/or password is invalid");
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
            rs.close();
        }
    }
    }

    @FXML
    private void openAdminTab(MouseEvent event) {
        TranslateTransition toLeftTranslation = new TranslateTransition(new Duration(500),lbStatus);
        toLeftTranslation.setToX(slidePane.getTranslateX());
        toLeftTranslation.play();
        toLeftTranslation.setOnFinished((ActionEvent event2)->{
        lbStatus.setText("ADMIN");
        });
        tabPaneLogin.getSelectionModel().select(tabAdmin);
    }

    @FXML
    private void openUserTab(MouseEvent event) {
        TranslateTransition toRightAnimation = new TranslateTransition(new Duration(500),lbStatus);
        toRightAnimation.setToX(slidePane.getTranslateX() + (slidePane.getPrefWidth() - lbStatus.getPrefWidth()));
        toRightAnimation.play(); 
        toRightAnimation.setOnFinished((ActionEvent event1) -> {
            lbStatus.setText("USER");
        });
        tabPaneLogin.getSelectionModel().select(tabUser);
    }

    @FXML
    private void openCreateAccount(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterAccountView.fxml"));
        Scene login = lbAdmin.getScene();
        root.translateYProperty().set(login.getHeight());
        rootPane.getChildren().add(root);
        Timeline tl = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
        tl.getKeyFrames().add(kf);
        tl.play();
        tl.setOnFinished((ActionEvent event2) -> {
        rootPane.getChildren().remove(anchorPane);            
        });                
    }   
}
