package com.data.stockmarket.model;
/** 
 * This Program is a Interface that consists of the Stock Operational methods 
 * @author goutham.balaji
 * @date 06-04-2021
 * 
 * */
public interface StockUI {
	public StockData setStock (StockData data);
	public float purchaseStock(int stocks,StockData data);
}
