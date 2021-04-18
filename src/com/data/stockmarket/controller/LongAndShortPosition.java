package com.data.stockmarket.controller;

//import com.data.stockmarket.model.StockData;

/** 
 * This Program performs all the Business Logic Operations
 * @author goutham.balaji
 * @date 06-04-2021
 * 
 * */

public abstract class LongAndShortPosition {
	
	public LongAndShortPosition() {
		super();
	}
	public abstract void callLongPosition();
	public abstract void callShortPosition();
	public float longPosition(float facevalue,int stocks) {
		float profitGained=0.0f;
		int dividentProfit=150;
//		float facevalue=data.getFaceValue();
		System.out.println("Divident value of increased points:  "+dividentProfit+" %");
		try{
			profitGained=(facevalue-2)*(dividentProfit/100)*stocks;//facevalue can be modified 
		}catch(ArithmeticException ae)
		{
			System.out.println(ae.getMessage());
		}
		return profitGained;
	}
	public float shortPosition(float facevalue,int stocks) {
		float LossInccured=0.0f;
		int dividentLoss=70;
//		float facevalue=data.getFaceValue();
		System.out.println("Divident value of decreased points:  " +dividentLoss+" %"); 
		try{LossInccured=(facevalue+3)*(dividentLoss/100.0f)*stocks;//facevalue can be modified
		}catch (ArithmeticException ae) {
			// TODO: handle exception
			System.out.println(ae.getMessage());
		}
		
		return LossInccured;
	}
}
