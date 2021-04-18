package com.data.stockmarket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;



public class MySqlConnection {
	private static String class_name=null;
	static Connection conn=null;
	private static String url=null;
	private static String dbname=null;
	private static String uid=null;
	private static String pwd=null;
	public static Connection MysqlConnection() {
		ResourceBundle rbundle= ResourceBundle.getBundle("dbdata",Locale.US);
		class_name=rbundle.getString("class_name");
		url=rbundle.getString("url");
		dbname=rbundle.getString("dbname");
		uid=rbundle.getString("uid");
		pwd=rbundle.getString("pwd");
		 String uri=url+dbname;
		System.out.println(uri);
		System.out.println(pwd);
		System.out.println(uid);
		System.out.println(class_name);
		try {
//			Class.forName(class_name);
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stockmarket","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
}
}