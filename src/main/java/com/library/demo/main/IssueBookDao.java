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
public class IssueBookDao {

	public static boolean checkBook(String bookcallno) throws SQLException {
		boolean status = false;
		String con1 = DB.getConnection();
		Connection con = DriverManager.getConnection(con1);
		Statement stmt = con.createStatement();
		try {
			String SQL = "select * from books where callno=" + bookcallno;
			ResultSet rs = stmt.executeQuery(SQL);
			status = rs.next();
		 
		}catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static int save(String bookcallno, int studentid, String studentname, String studentcontact) {
		int status = 0;
		try {
			String con1 = DB.getConnection();

			status = updatebook(bookcallno);// updating quantity and issue

			if (status > 0) {
				try (Connection con = DriverManager.getConnection(con1); Statement stmt = con.createStatement();) {
					String SQL = "insert into books values(" + bookcallno + "," + studentid + "," + studentname + ","
							+ studentcontact + ")";
					status=stmt.executeUpdate(SQL);
//				ResultSet rs1 = stmt.executeQuery(rs);
				}
				// Handle any errors that may have occurred.
				catch (SQLException e) {
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int updatebook(String bookcallno) {
		int status = 0;
		int quantity = 0, issued = 0;
		try {
			String con1 = DB.getConnection();
			Connection con = DriverManager.getConnection(con1);
			Statement stmt = con.createStatement();

			try {
				String SQL = "select * from books where callno=" + bookcallno;
				ResultSet rs = stmt.executeQuery(SQL);
				if (rs.next()) {
					quantity = rs.getInt("quantity");
					issued = rs.getInt("issued");
				}
				// Iterate through the data in the result set and display it.
				if (quantity > 0) {
					String SQL1 = "update books set quantity=" + bookcallno + ",issued=" + bookcallno + " where callno="
							+ bookcallno;
					status = stmt.executeUpdate(SQL1);
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (

		Exception e) {
			System.out.println(e);
		}
		return issued;
	}
}
