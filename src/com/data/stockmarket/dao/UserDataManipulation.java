package com.data.stockmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.data.stockmarket.model.UserData;

public class UserDataManipulation {
	static Connection conn=null;
	public void createUser(UserData user) {	
		conn=MySqlConnection.MysqlConnection();
		 String query = " insert into userdata(userId,userName,accountnumber,phonenumber,address)"
		            + " values (?, ?, ?, ?, ?)";
		try {
	          // create the mysql insert preparedstatement
	          PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
	          preparedStmt.setInt (1, user.getUserId());
	          preparedStmt.setString (2, user.getUserName());
	          preparedStmt.setFloat   (3, user.getAccountNumber());
	          preparedStmt.setLong (4, user.getPhoneNumber());
	          preparedStmt.setString (5, user.getAddress());		          
		      
	          // execute the preparedstatement
		      preparedStmt.execute();
		      System.out.println(" user value entered successfully");
			} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public int getPreviousUserid() {
		conn=MySqlConnection.MysqlConnection();
		int id=0;
		String sql= "select max(userId) from userdata";
 		try {
			PreparedStatement pstm1=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=pstm1.executeQuery();
			if(rs.next()) {
			    id = rs.getInt(1);
			    System.out.println(id);
			   return id;
			}	
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		return id;
	}
	
}
