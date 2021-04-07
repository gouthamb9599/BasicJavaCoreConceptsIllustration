package com.data.stockmarket.model;
/** 
 * This Program is a data model for Stock Data
 * @author goutham.balaji
 * @date 06-04-2021
 * 
 * */
import java.util.Date;
public class StockData {
	private String stockName;
	private String stockId;
	private float faceValue;
	private Date xDate;
	private int stocksCount;
	private float points;
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
	public int getStocksCount() {
		return stocksCount;
	}
	public void setStocksCount(int stocksCount) {
		this.stocksCount = stocksCount;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public float getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(float faceValue) {
		this.faceValue = faceValue;
	}
	public Date getxDate() {
		return xDate;
	}
	public void setxDate(Date xDate) {
		this.xDate = xDate;
	}
	
}
