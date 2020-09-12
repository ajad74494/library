package com.library.demo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class ReturnBookDao {
	public static int delete(String bookcallno, int studentid) {
		int status = 0;
		try {
			String con1 = DB.getConnection(); 
			Connection con = DriverManager.getConnection(con1);
			Statement stmt = con.createStatement();
			status = updatebook(bookcallno);// updating quantity and issue

			if (status > 0) {
				String SQL = "delete from issuebooks where bookcallno="+bookcallno+" and studentid="+studentid;
				ResultSet rs = stmt.executeQuery(SQL);
				status = ((PreparedStatement) rs).executeUpdate();
			}

			con.close();
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

			String SQL =("select quantity,issued from books where callno="+bookcallno);
			ResultSet rs = stmt.executeQuery(SQL);
			if (rs.next()) {
				quantity = rs.getInt("quantity");
				issued = rs.getInt("issued");
			}

			if (issued > 0) {
				PreparedStatement ps2 = con.prepareStatement("update books set quantity=?,issued=? where callno=?");
				ps2.setInt(1, quantity + 1);
				ps2.setInt(2, issued - 1);
				ps2.setString(3, bookcallno);

				status = ps2.executeUpdate();
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
