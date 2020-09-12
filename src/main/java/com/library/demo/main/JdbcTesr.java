package com.library.demo.main;

import java.sql.*;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class JdbcTesr {
 

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Create a variable for the connection string.

//		sou
		String con1 ;
//		Class.forName("com.mysql.jdbc.Driver");
//		con=DriverManager.getConnection("jdbc:mysql://localhost:3307/sys","root","root");
					
		con1 = "jdbc:sqlserver://localhost:1433;databaseName=libraryManagement;user=ajad;password=ajad123";
		Connection con = DriverManager.getConnection(con1);
		Statement stmt = con.createStatement();
		if (con != null) {
			String SQL="INSERT INTO books  VALUES ( '23', 'C In Depth', 'Shrivastav', 'BPB', 2)";
			 stmt.executeUpdate(SQL);
		}else {
			System.out.println("no");
		}

	}

}
