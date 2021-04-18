package com.data.stockmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockPurchaseManipulation {
	static Connection conn=null;
	public int getPurchase( String company) {
		conn=MySqlConnection.MysqlConnection();
		int purchase=0;
		String query="select purchasecount from userstockpurchase where stockId=?";
		try {
			PreparedStatement pstm1=(PreparedStatement) conn.prepareStatement(query);
			pstm1.setString(1, company);
			ResultSet rs=pstm1.executeQuery();
			if(rs.next()) {
				purchase = rs.getInt(1);
			    System.out.println(purchase);
			   return purchase;
			}	
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		return purchase;
	}
	public void stockpurchase(int uid,String sid,int stock) {
		
			conn=MySqlConnection.MysqlConnection();
			 String query = " insert into userstockpurchase(userId,stockId,purchasecount)"
			            + " values (?, ?, ?)";
			try {
		          // create the mysql insert preparedstatement
				
		          PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
		          preparedStmt.setInt(1, uid);
		          preparedStmt.setString(2, sid);
		          preparedStmt.setInt(3, stock);	          
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
	
}
