package com.launchclub.dataBaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

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
        Connection connection = null;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection(DATABASEURL, USERNAME, DATABASEPASSWORD);
                  
        } catch (Exception exception) {
            System.out.println("ConnectionIsNull");
        }
        
        return connection;
    }
    
}
