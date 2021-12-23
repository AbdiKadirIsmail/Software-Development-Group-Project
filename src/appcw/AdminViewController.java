/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abdul
 */
package appcw;

import static appcw.SqliteConnection.Connector;
import static appcw.SqliteConnection.Connector2;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdul
 */
public class AdminViewController implements Initializable {

    public AdminModel adminModel = new AdminModel();
    ObservableList<AdminModel> listM;
    Connection conn = null;

    public CordisD1 cordisD1 = new CordisD1();
    ObservableList<CordisD1> listCD1;
    Connection conn2 = null;

    ResultSet rs = null;
    PreparedStatement pst = null;
    int index = -1;
    int indexCD1 = -1;

    @FXML
    private JFXTextField txt_Username;
    @FXML
    private JFXTextField txt_Password;
    @FXML
    private JFXTextField txt_Fname;
    @FXML
    private JFXTextField txt_Lname;
    @FXML
    private JFXTextField txt_Email;
    @FXML
    private JFXComboBox<String> type;
    @FXML
    private TableColumn<AdminModel, Integer> col_id;
    @FXML
    private TableColumn<AdminModel, String> col_username;
    @FXML
    private TableColumn<AdminModel, String> col_password;
    @FXML
    private TableColumn<AdminModel, String> col_fname;
    @FXML
    private TableColumn<AdminModel, String> col_lname;
    @FXML
    private TableColumn<AdminModel, String> col_email;
    @FXML
    private TableColumn<AdminModel, String> col_type;
    @FXML
    private TableView<AdminModel> tbview;
    @FXML
    private Label isConnected;
    @FXML
    private JFXTextField txt_id;
    @FXML
    private AnchorPane switch_acc;
    @FXML
    private AnchorPane switch_CD1;
    @FXML
    private TableView<CordisD1> tbview1;
    @FXML
    private TableColumn<CordisD1, Integer> col_Pid;
    @FXML
    private TableColumn<CordisD1, Integer> col_projectRcn;
    @FXML
    private TableColumn<CordisD1, Integer> col_projectID;
    @FXML
    private TableColumn<CordisD1, String> col_projectAcronym;
    @FXML
    private TableColumn<CordisD1, String> col_role;
    @FXML
    private TableColumn<CordisD1, Integer> col_idCD1;
    @FXML
    private TableColumn<CordisD1, String> col_name;
    @FXML
    private TableColumn<CordisD1, String> col_shortName;
    @FXML
    private TableColumn<CordisD1, String> col_activityType;
    @FXML
    private TableColumn<CordisD1, String> col_endOfParticipation;
    @FXML
    private TableColumn<CordisD1, String> col_ecContribution;
    @FXML
    private TableColumn<CordisD1, String> col_country;
    @FXML
    private TableColumn<CordisD1, String> col_street;
    @FXML
    private TableColumn<CordisD1, String> col_city;
    @FXML
    private TableColumn<CordisD1, String> col_postCode;
    @FXML
    private TableColumn<CordisD1, String> col_organizationUrl;
    @FXML
    private TableColumn<CordisD1, String> col_vatNumber;

    public static ObservableList<AdminModel> getDatausers() {
        Connection conn = Connector();
        ObservableList<AdminModel> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Accounts");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AdminModel(Integer.parseInt(rs.getString("id")), rs.getString("username"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"), rs.getString("type")));
            }
        } catch (Exception ex) {
        }
        return list;
    }

    public static ObservableList<CordisD1> getDataC1() {
        Connection conn2 = Connector2();
        ObservableList<CordisD1> listCD1 = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn2.prepareStatement("select * from data");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCD1.add(new CordisD1(Integer.parseInt(rs.getString("Pid")), Integer.parseInt(rs.getString("projectRcn")), Integer.parseInt(rs.getString("projectID")),
                        Integer.parseInt(rs.getString("id")), rs.getString("projectAcronym"), rs.getString("role"),
                        rs.getString("name"), rs.getString("shortName"), rs.getString("activityType"), rs.getString("endOfParticipation"),
                        rs.getString("ecContribution"),
                        rs.getString("country"), rs.getString("street"), rs.getString("city"),
                        rs.getString("postCode"), rs.getString("organizationUrl"), rs.getString("vatNumber")));
            }
        } catch (Exception ex) {
        }
        return listCD1;
    }
    @FXML
    private Label isConnected1;
    @FXML
    private JFXTextField txt_Pid;
    @FXML
    private JFXTextField txt_projectRcn;
    @FXML
    private JFXTextField txt_projectID;
    @FXML
    private JFXTextField txt_projectAcronym;
    @FXML
    private JFXTextField txt_role;
    @FXML
    private JFXTextField txt_idCD1;
    @FXML
    private JFXTextField txt_name;
    @FXML
    private JFXTextField txt_shortName;
    @FXML
    private JFXTextField txt_activityType;
    @FXML
    private JFXTextField txt_endOfParticipation;
    @FXML
    private JFXTextField txt_ecContribution;
    @FXML
    private JFXTextField txt_country;
    @FXML
    private JFXTextField txt_street;
    @FXML
    private JFXTextField txt_city;
    @FXML
    private JFXTextField txt_postCode;
    @FXML
    private JFXTextField txt_organizationUrl;
    @FXML
    private JFXTextField txt_vatNumber;

    @FXML
    public void addAcc(ActionEvent event) throws SQLException {
        conn = SqliteConnection.Connector();
        String query = "insert into Accounts (username, password, fname, lname, email, type) Values(?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, txt_Username.getText());
            pst.setString(2, txt_Password.getText());
            pst.setString(3, txt_Fname.getText());
            pst.setString(4, txt_Lname.getText());
            pst.setString(5, txt_Email.getText());
            pst.setString(6, type.getValue().toString());
            pst.execute();
            isConnected.setText("Account Created");
            Refresh();
        } catch (SQLException ex) {
            isConnected.setText("Failed to created account");
        }
    }

    public void Refresh() {
        col_Pid.setCellValueFactory(new PropertyValueFactory<CordisD1, Integer>("projectRcn"));
        col_projectRcn.setCellValueFactory(new PropertyValueFactory<CordisD1, Integer>("Pid"));
        col_projectID.setCellValueFactory(new PropertyValueFactory<CordisD1, Integer>("projectID"));
        col_projectAcronym.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("projectAcronym"));
        col_role.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("role"));
        col_idCD1.setCellValueFactory(new PropertyValueFactory<CordisD1, Integer>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("name"));
        col_shortName.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("shortName"));
        col_activityType.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("activityType"));
        col_endOfParticipation.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("endOfParticipation"));
        col_ecContribution.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("ecContribution"));
        col_country.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("country"));
        col_street.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("street"));
        col_city.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("city"));
        col_postCode.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("postCode"));
        col_organizationUrl.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("organizationUrl"));
        col_vatNumber.setCellValueFactory(new PropertyValueFactory<CordisD1, String>("vatNumber"));

        listCD1 = getDataC1();
        tbview1.setItems(listCD1);
        if (cordisD1.isDbConnected()) {
            isConnected1.setText("Table Updated");
        } else {
            isConnected1.setText("Unable to update table");
        }
        col_id.setCellValueFactory(new PropertyValueFactory<AdminModel, Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("username"));
        col_password.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("password"));
        col_fname.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("fname"));
        col_lname.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("lname"));
        col_email.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("email"));
        col_type.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("type"));
        listM = getDatausers();
        tbview.setItems(listM);
        if (adminModel.isDbConnected()) {
            isConnected.setText("Table Updated");
        } else {
            isConnected.setText("Unable to update table");
        }
    }

    @FXML
    void getSelected(MouseEvent event) {

        index = tbview.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_Username.setText(col_username.getCellData(index).toString());
        txt_Password.setText(col_password.getCellData(index).toString());
        txt_Fname.setText(col_fname.getCellData(index).toString());
        txt_Lname.setText(col_lname.getCellData(index).toString());
        txt_Email.setText(col_email.getCellData(index).toString());
        type.setValue(col_type.getCellData(index).toString());

        

    }

    @FXML
    public void Del() throws SQLException {
        conn = SqliteConnection.Connector();
        String query = "delete from Accounts where id = ?";
        pst = conn.prepareStatement(query);
        try {
            pst.setString(1, txt_id.getText());
            pst.execute();
            isConnected.setText("Data removed");
            Refresh();
        } catch (Exception ex) {
            isConnected.setText("Unable to remove data");
        }
    }

    @FXML
    public void UpdateAcc() {
        try {
            conn = SqliteConnection.Connector();
            String v1 = txt_id.getText();
            String v2 = txt_Username.getText();
            String v3 = txt_Password.getText();
            String v4 = txt_Fname.getText();
            String v5 = txt_Lname.getText();
            String v6 = txt_Email.getText();
            String v7 = type.getValue();
            String query = "update Accounts set id= '" + v1 + "',username= '" + v2 + "',password= '" + v3
                    + "',fname= '" + v4 + "',lname= '" + v5 + "',email= '" + v6 + "',type= '" + v7 + "' where id='" + v1 + "' ";
            pst = conn.prepareStatement(query);
            pst.execute();
            isConnected.setText("Account Changed");
            Refresh();
        } catch (Exception ex) {
            isConnected.setText("Failed to change account");
        }
    }

    @FXML
    public void switchAccData() {
        switch_acc.setVisible(true);
        switch_CD1.setVisible(false);
    }

    @FXML
    public void switchCD1Data() {
        switch_acc.setVisible(false);
        switch_CD1.setVisible(true);
    }
    
    @FXML
    public void addCD1() throws SQLException{   
    }

    @FXML
    private void DelCD1(ActionEvent event) {
    }

    @FXML
    private void UpdateCD1(ActionEvent event) {       
    }

    @FXML
    private void getSelectedCD1(MouseEvent event) {
        indexCD1 = tbview1.getSelectionModel().getSelectedIndex();
        if (indexCD1 <= -1) {
            return;
        }
        indexCD1 = tbview1.getSelectionModel().getSelectedIndex();
        txt_Pid.setText(col_Pid.getCellData(indexCD1).toString());
        txt_projectRcn.setText(col_projectRcn.getCellData(indexCD1).toString());
        txt_projectID.setText(col_projectID.getCellData(indexCD1).toString());
        txt_projectAcronym.setText(col_projectAcronym.getCellData(indexCD1).toString());
        txt_role.setText(col_role.getCellData(indexCD1).toString());
        txt_idCD1.setText(col_idCD1.getCellData(indexCD1).toString());
        txt_name.setText(col_name.getCellData(indexCD1).toString());
        txt_shortName.setText(col_shortName.getCellData(indexCD1).toString());
        txt_activityType.setText(col_activityType.getCellData(indexCD1).toString());
        txt_endOfParticipation.setText(col_endOfParticipation.getCellData(indexCD1).toString());
        txt_ecContribution.setText(col_ecContribution.getCellData(indexCD1).toString());
        txt_country.setText(col_country.getCellData(indexCD1).toString());
        txt_street.setText(col_street.getCellData(indexCD1).toString());
        txt_city.setText(col_city.getCellData(indexCD1).toString());
        txt_postCode.setText(col_postCode.getCellData(indexCD1).toString());
        txt_organizationUrl.setText(col_organizationUrl.getCellData(indexCD1).toString());
        txt_vatNumber.setText(col_vatNumber.getCellData(indexCD1).toString());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.getItems().addAll("ADMIN", "USER");

        Refresh();

        if (adminModel.isDbConnected()) {
            isConnected.setText("Status: Connected");
        } else {
            isConnected.setText("Status: Not Connected");
        }

    }

   

}
