package com.library.demo.main;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

public class DisplayEmpData extends JFrame {

	public static void main(String ar[]) throws Exception {
		String con1 = "jdbc:sqlserver://localhost:1433;databaseName=libraryManagement;user=ajad;password=ajad123";
		Connection con = DriverManager.getConnection(con1);
		Statement st= con.createStatement();
		String query =  "select * from books" ;
		
		JTable t1 = new JTable();
		DefaultTableModel dm = new DefaultTableModel(); 
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		// Coding to get columns-
		int cols = rsmd.getColumnCount();
		String c[] = new String[cols];
		for (int i = 0; i < cols; i++) {
			c[i] = rsmd.getColumnName(i + 1);
			dm.addColumn(c[i]);
		}

		// get data from rows
		Object row[] = new Object[cols];
		while (rs.next()) {
			for (int i = 0; i < cols; i++) {
				row[i] = rs.getString(i + 1);
			}
			dm.addRow(row);
		}
		t1.setModel(dm);
		con.close();
		 JFrame f=new JFrame("Title");
	}
}