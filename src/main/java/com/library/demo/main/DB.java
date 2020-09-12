package com.library.demo.main;

/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class DB {
	public static String getConnection() {
		String con = null;
		try {
			 con = "jdbc:sqlserver://localhost:1433;databaseName=libraryManagement;user=ajad;password=ajad123";
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
