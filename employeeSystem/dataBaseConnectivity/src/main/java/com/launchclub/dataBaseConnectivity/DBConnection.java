package com.launchclub.dataBaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

import com.launchclub.employeeExceptions.ConnectionNotFoundException;

/**
 * Used to get the database connection 
 * 
 * @author DeviDurgaA
 */
public class DBConnection {
   
    private static final String DATABASEURL = "jdbc:mysql://localhost:3306/employeedao";
    private static final String USERNAME = "root";
    private static final String DATABASEPASSWORD = "Deepi@123";
    
    /**
     * Determines the connection for database 
     *    
     * @return connection
     */
    public Connection getConnection() { 
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); 
            final Connection connection = DriverManager.getConnection(DATABASEURL, USERNAME, DATABASEPASSWORD);
            
            return connection;
                  
        } catch (Exception exception) {
            throw new ConnectionNotFoundException("ConnectionIsNull");
        }
     }
    
}
