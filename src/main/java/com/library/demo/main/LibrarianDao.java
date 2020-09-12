package com.library.demo.main;

import java.sql.*;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class LibrarianDao {

	public static int save(String name, String password, String email, String address, String city, String contact) {
		int status = 0;
		try {
			String con1 = DB.getConnection();
			Connection con = DriverManager.getConnection(con1);
			Statement stmt = con.createStatement();
			String SQL = "insert into librarian values('" + name + "','"
					+ password + "','" + email + "','" + address + "','" + city + "','" + contact + "')";
			status=stmt.executeUpdate(SQL);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			String con1 = DB.getConnection();
			Connection con = DriverManager.getConnection(con1);
			Statement stmt = con.createStatement();
			String SQL = "delete from librarian where id=" + id;
			status=stmt.executeUpdate(SQL);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static boolean validate(String name, String password) {
		boolean status = false;
		try {
			String con1 = DB.getConnection();
			Connection con = DriverManager.getConnection(con1);
			Statement stmt = con.createStatement();
			String ps = "select * from librarian where name=" + name + " and password=" + password;
			ResultSet rs = stmt.executeQuery(ps);
			status = rs.next();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
