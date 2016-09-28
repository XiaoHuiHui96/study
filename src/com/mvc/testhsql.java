package com.mvc;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class testhsql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		ResultSet rs=null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
