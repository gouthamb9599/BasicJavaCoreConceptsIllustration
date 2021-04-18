package com.data.stockmarket.view;
/** 
 * This Program performs all the UI action and connects with both User POJO and Stock POJO
 * @author goutham.balaji
 * @date 06-04-2021
 * 
 * */

import java.util.Date;
import java.util.Scanner;

import com.data.stockmarket.controller.LongAndShortPosition;
import com.data.stockmarket.dao.StockDataManipulation;
import com.data.stockmarket.dao.StockPurchaseManipulation;
import com.data.stockmarket.dao.UserDataManipulation;
import com.data.stockmarket.model.StockData;
import com.data.stockmarket.model.UserData;

public class UserUI extends LongAndShortPosition implements StockUI {
	@Override
	public StockData setStock(StockData data) {
			data.setStockId("SID1");
			data.setStockName("Company x");
			data.setFaceValue(12.21f);
			data.setxDate(new Date());
			data.setInventoryCount(1000);
			data.setPoints(1000);
//			System.out.println(data.getStockId());
			System.out.println("Current Owner: "+data.getStockName());
			System.out.println("Face Value: " +data.getFaceValue());
			System.out.println("Price Modification Date(X-date): "+data.getxDate());
			System.out.println("Total Count: "+data.getInventoryCount());
			return data;
	}
	public void callLongPosition() {
		System.out.println("Considering long position of 12 points from base conditions");
	}
	public void callShortPosition(){
	System.out.println("Considering short position of 12 points from base conditions");
}
	public float purchaseStock(int stocks,StockData data) {
		data.setInventoryCount(1000-stocks);
//		System.out.println(1000-stocks);//inventory
		float facevalue=data.getFaceValue();
		float price=(float)stocks*facevalue;
		return price;
	}
	public static void main(String[] args) {
		UserData user= new UserData();
		try (Scanner getdata = new Scanner(System.in)) {
			System.out.println("Welcome to xyz Company");
			System.out.println("Enter the Following Details for Registration");
			UserDataManipulation um= new UserDataManipulation();
			int previd=um.getPreviousUserid();
//			System.out.println(previd);
			//customer details
			user.setUserId(previd+1);
			System.out.println("Enter your Name");
			user.setUserName(getdata.next());
			System.out.println("Enter your account number");
			user.setAccountNumber(getdata.nextLong());
			System.out.println("Enter your phone number");
			user.setPhoneNumber(getdata.nextLong());
			System.out.println("Enter your Address");
			user.setAddress(getdata.next());
			um.createUser(user);
			//stock details
			System.out.println("Current Stock For Purchase");
			UserUI ui=new UserUI();
//			StockData data= new StockData();
//			ui.setStock(data);
			StockDataManipulation st= new StockDataManipulation();
//			int count=st.listStocks();
			System.out.println("Choose from the following....by entering the stock id");
			String company = getdata.next();
			System.out.println("Enter the Number of Stocks you want to buy");
			int stocks=getdata.nextInt();
			
			st.updateStocks(company,stocks);
			new StockPurchaseManipulation().stockpurchase(previd+1, company, stocks); 

			
			//purchase and illustrations
//			System.out.println("Considering the stocks "+stocks+" are purchased for Rs:  "+rate);
			System.out.println("");
			System.out.println("");
			System.out.println("The Below two are just sample illustrations on how the points modifications will effect on your stocks");
			System.out.println("");
			System.out.println("");
			
			String name=st.getStockName(company);
			ui.callLongPosition();
			System.out.println("Dear "+user.getUserName());
			System.out.println("Your Purchase of stock in: "+name+ "has resulted in Profit");
			System.out.println("Details Below:");
			int stockpurchased=new StockPurchaseManipulation().getPurchase( company);
			float facevalue=st.getFacevalue(company);
			float profitGained=ui.longPosition(facevalue,stocks);
			System.out.println("Profit Gained for your " +stockpurchased+" Stocks Rs: "+profitGained);
			
			
			System.out.println("");
			System.out.println("");
			
			ui.callShortPosition();
			System.out.println("Dear "+user.getUserName());
			System.out.println("Your Purchase of stock in: "+name+ "has resulted in Loss");
			System.out.println("Details Below:");
			float LossInccured=ui.shortPosition(facevalue,stocks);
			System.out.println("Loss Inccured for your " +stocks+" Stocks Rs: "+LossInccured);
			
		}
		
	}

}
