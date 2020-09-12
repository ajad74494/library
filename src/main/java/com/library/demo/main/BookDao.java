package com.library.demo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class BookDao {
	public static int save(String callno, String name, String author, String publisher, int quantity) {
		int status = 0;
		try {
			String con1 = DB.getConnection();
			try (Connection con = DriverManager.getConnection(con1); Statement stmt = con.createStatement();) { 
				String SQL="INSERT INTO books  VALUES ( '"+callno+"', '"+name+"', '"+author+"', '"+publisher+"',"+ quantity+")";
				
				status=stmt.executeUpdate(SQL);
				con.close();
			}
			// Handle any errors that may have occurred.
			catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
