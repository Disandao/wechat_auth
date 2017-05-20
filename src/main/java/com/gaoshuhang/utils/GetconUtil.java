package com.gaoshuhang.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.*;

import java.sql.*;



public class GetconUtil {
	 public static DataSource init() throws ServletException {  
	        try{  
	            Context initCtx = new InitialContext();  
	            Context jndi = (Context) initCtx.lookup("java:comp/env");  
	            DataSource source = (DataSource) jndi.lookup("jdbc/wechat");  
	            return source;
	        }catch (Exception e) {  
	            e.printStackTrace();  
	            throw new RuntimeException(e);  
	        }  
	    }

	
}
