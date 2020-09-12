package com.library.demo.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class ViewIssuedBooks extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewIssuedBooks frame = new ViewIssuedBooks();
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
	public ViewIssuedBooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String data[][]=null;
		String column[]=null;
		try{
			String con1 = DB.getConnection();
			Connection con = DriverManager.getConnection(con1);
			Statement stmt = con.createStatement();
			String ps =  "select * from issuebooks" ;
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
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
	}

}
