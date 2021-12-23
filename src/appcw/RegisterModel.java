/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdul
 */
public class RegisterModel {

    Connection connection;

    public RegisterModel() {
        connection = SqliteConnection.Connector();
        if (connection == null) {
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

//    public boolean Create(String user, String pass, String fname, String lname, String email) throws SQLException {
//        PreparedStatement PreparedStatement = null;
//        ResultSet resultSet = null;
//        String query = "Insert into Accounts (username, password, fname, lname, email) Values(?,?,?,?)";
//        try {
//            PreparedStatement = connection.prepareStatement(query);
//            PreparedStatement.setString(1, user);
//            PreparedStatement.setString(2, pass);
//            PreparedStatement.setString(3, fname);
//            PreparedStatement.setString(4, lname);
//            PreparedStatement.setString(5, email);
//            resultSet = PreparedStatement.executeQuery();
//            if (resultSet.next()) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            return false;
//        } finally {
//            PreparedStatement.close();
//            resultSet.close();
//        }
//    }
}
