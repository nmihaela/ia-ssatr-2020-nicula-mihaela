/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.biblioteca.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mihaela
 */
public class DBAccess {
    private Connection connection;
    private static DBAccess instance; 
    private DBAccess() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        this.connection = DriverManager.getConnection("jdbc:derby://localhost/BIBLIOTECA;create=false","biblioteca","biblioteca");
    }
    
    public static final DBAccess getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null){
            instance = new DBAccess();
        }
    return instance;        
    }

    public Connection getConnection() {
        return connection;
    }
}
