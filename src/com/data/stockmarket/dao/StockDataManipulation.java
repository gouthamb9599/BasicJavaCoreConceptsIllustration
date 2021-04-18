package com.data.stockmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class StockDataManipulation {
	static Connection conn=null;
	public void listStocks() {
		conn=MySqlConnection.MysqlConnection();
		String sql= "select * from stockdata";
 		try {
			PreparedStatement pstm1=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=pstm1.executeQuery();
			if(rs.next()) {
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				 int columnsNumber = rsmd.getColumnCount();
				 for (int i = 1; i <= columnsNumber; i++) {
			           String columnValue = rs.getString(i);
			           System.out.print(rsmd.getColumnName(i)+" : ");
			           System.out.println(columnValue);
			       }
			       System.out.println("");			   
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public String getStockName(String company) {
		String name=null;
		conn=MySqlConnection.MysqlConnection();
		String sql="select stockName from stockdata where stockId=?";
		try {
			PreparedStatement pstm1=(PreparedStatement) conn.prepareStatement(sql);
			pstm1.setString(1, company);
			ResultSet rs=pstm1.executeQuery();
			if(rs.next()) {
			     name = rs.getString(1);
			    System.out.println(name);
			   return name;
			}	
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		return name;
		
	}
	public float getFacevalue(String company) {
		float name=0.0f;
		conn=MySqlConnection.MysqlConnection();
		String sql="select facevalue from stockdata where stockId=?";
		try {
			PreparedStatement pstm1=(PreparedStatement) conn.prepareStatement(sql);
			pstm1.setString(1, company);
			ResultSet rs=pstm1.executeQuery();
			if(rs.next()) {
			     name = rs.getFloat(1);
			    System.out.println(name);
			   return name;
			}	
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		return name;
		
	}
	public int getStocks(String company) {
		conn=MySqlConnection.MysqlConnection();
		int stock=0;
		String sql="select InventoryCount from stockdata where stockId=?";
		try {
			PreparedStatement pstm1=(PreparedStatement) conn.prepareStatement(sql);
			pstm1.setString(1, company);
			ResultSet rs=pstm1.executeQuery();
			if(rs.next()) {
			     stock = rs.getInt(1);
			    System.out.println(stock);
			   return stock;
			}	
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		return stock;
	}
		
	public void updateStocks(String company,int stocks) {
		conn=MySqlConnection.MysqlConnection();
		String sql="update stockdata set InventoryCount=? where stockId=?";
		System.out.println("company"+company);
		System.out.println("Stock"+stocks);
		int count=new StockDataManipulation().getStocks(company);
		int current= count-stocks;
				try {
		 			PreparedStatement pstmt= (PreparedStatement)conn.prepareStatement(sql);
		 			pstmt.setInt(1, current);
		 			pstmt.setString(2,company );
		 			pstmt.execute();
		 			System.out.println("stocks modified");
		 		}catch (SQLException e) {
					// TODO: handle exception
		 			e.printStackTrace();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					
				}
		}
}
