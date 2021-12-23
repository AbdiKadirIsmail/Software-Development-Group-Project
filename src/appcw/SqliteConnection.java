/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcw;
import java.sql.*;


/**
 *
 * @author abdul
 */ 
public class SqliteConnection {
    public static Connection Connector() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Accounts.db");            
            return conn;
            
    } catch (Exception e) {
        System.out.println(e);
        return null;
    }
    }
    public static Connection Connector2() {
        try {
            Class.forName("org.sqlite.JDBC");           
            Connection conn2 = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            return conn2;
            
    } catch (Exception e) {
        System.out.println(e);
        return null;
    }
    }
    
    
    
}

    
