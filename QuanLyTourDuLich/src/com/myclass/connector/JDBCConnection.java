package com.myclass.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	 public static String username = "root";
	 public static String password = "12345678";
	 public final static String URL = "jdbc:mysql://localhost:3306/quanlytourdulich";
	 
	 public static Connection getJDBCConnection(String tableName) {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn = DriverManager.getConnection(URL, username, password);
			 System.out.print("Đang kết nối đến table " + tableName);
			 if(conn != null) {
				 System.out.println("ĐÃ KẾT NỐI!");
			 }
			 else {
				 System.out.println("KẾT NỐI THẤT BẠI!");
			 }
			 
			 return conn;
		 } catch (ClassNotFoundException e) {
			 e.printStackTrace();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 
		return null;
	}

}
