/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcw;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author abdul
 */
public class RegisterAccountViewController implements Initializable {

    public RegisterModel registerModel = new RegisterModel();
    @FXML
    private Label lbLogIn;
    @FXML
    private AnchorPane anchorPaneC;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtLname;
    @FXML
    private JFXTextField txtFname;
    @FXML
    private Label isConnected;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private JFXComboBox type;
    @FXML
    private Label error_createUsername;
    @FXML
    private Label error_createPassword;
    @FXML
    private Label error_createEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        con = appcw.SqliteConnection.Connector();
        if (registerModel.isDbConnected()) {
            isConnected.setText("Status: Connected");
        } else {
            isConnected.setText("Status: Not Connected");
        }
        type.getItems().addAll("ADMIN", "USER");
    }

    @FXML
    private void openLogIn(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene create = lbLogIn.getScene();
        root.translateYProperty().set(create.getHeight());

        StackPane rootPane = (StackPane) create.getRoot();

        rootPane.getChildren().add(root);
        Timeline tl = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
        tl.getKeyFrames().add(kf);
        tl.play();
        tl.setOnFinished((ActionEvent event2) -> {
            rootPane.getChildren().remove(anchorPaneC);
        });
    }

    @FXML
    public void CreateAcc(ActionEvent event) throws SQLException {
        conn = SqliteConnection.Connector();               
        boolean isCUsernameEmpty = validation.TextFieldValidation.isTextFieldNotEmpty(txtUsername, error_createUsername, "Username is required");
        boolean isCPasswordEmpty = validation.TextFieldValidation.isTextFieldNotEmpty(txtPassword, error_createPassword, "Password is required");
        boolean isValidEmail = validation.TextFieldValidation.isValidEmail(txtEmail, error_createEmail, "Invalid email");
        if (isCUsernameEmpty && isCPasswordEmpty && isValidEmail) {
            
        
        String query = "insert into Accounts (username, password, fname, lname, email, type) Values(?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtPassword.getText());
            pst.setString(3, txtFname.getText());
            pst.setString(4, txtLname.getText());
            pst.setString(5, txtEmail.getText());
            pst.setString(6, type.getValue().toString());
            pst.execute();
            isConnected.setText("Account Created");
        } catch (SQLException ex) {
            isConnected.setText("Failed to created account");
        }
        }

    }

}
