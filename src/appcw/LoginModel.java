/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcw;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdul
 */
public class LoginModel {
    Connection connection;
    
    public LoginModel() {
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
    
//    public boolean isLogin(String user, String pass) throws SQLException {
//        PreparedStatement PreparedStatement = null;
//        ResultSet resultSet = null;
//        String query = "select * from Accounts where username = ? and password = ?";
//        try {
//            PreparedStatement = connection.prepareStatement(query);
//            PreparedStatement.setString(1, user);
//            PreparedStatement.setString(2, pass);
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
