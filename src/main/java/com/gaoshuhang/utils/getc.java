package com.gaoshuhang.utils;

import java.beans.PropertyVetoException;   
import java.sql.Connection;   
import java.sql.SQLException;   
import com.mchange.v2.c3p0.ComboPooledDataSource;   
  
public class getc {   
  
    private getc(){   
    }       
  
    private static ComboPooledDataSource ds = null;   
  
    static {   
        try {   

            ds = new ComboPooledDataSource();   
            ds.setDriverClass("com.mysql.jdbc.Driver");  
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/company");   
            ds.setUser("root");   
            ds.setPassword("");   
            ds.setMaxPoolSize(200);   
            ds.setMinPoolSize(20);   
        } catch (PropertyVetoException e) {   
            e.printStackTrace();   
        }   
    }   
     
    public static synchronized Connection getConnection() {   
        Connection con = null;   
        try {   
            con = ds.getConnection();   
        } catch (SQLException e1) {   
            e1.printStackTrace();   
        }   
        return con;   
    }   
    // C3P0 end   
}  
