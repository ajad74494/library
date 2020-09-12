package com.library.demo.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class ViewLibrarian extends JFrame {

	private JPanel contentPane; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLibrarian frame = new ViewLibrarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewLibrarian() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		try {
			String con1 = DB.getConnection();
			Connection con = DriverManager.getConnection(con1);
			Statement stmt = con.createStatement();
			String ps =  "select * from librarian" ;
			ResultSet rs = stmt.executeQuery(ps);

			JTable t1 = new JTable();
			DefaultTableModel dm = new DefaultTableModel(); 
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
			JScrollPane sp = new JScrollPane(t1);

			contentPane.add(sp, BorderLayout.CENTER);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
