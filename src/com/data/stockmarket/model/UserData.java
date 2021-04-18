package com.data.stockmarket.model;

import com.data.stockmarket.validations.exceptions.AccountNumberLengthException;
import com.data.stockmarket.validations.exceptions.PhoneNumberLengthException;

//import java.util.Scanner;

/** 
 * This Program is a data model for User Data
 * @author goutham.balaji
 * @date 06-04-2021
 * 
 * */

public class UserData {
	private int userId;
	private String userName;
	private long accountNumber;
	private long phoneNumber;
	private String address;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber)throws AccountNumberLengthException {
		try{int length=String.valueOf(accountNumber).length();
		if(length==8) {
			this.accountNumber = accountNumber;
		}
		else {
			throw new AccountNumberLengthException(accountNumber);
		}
		}catch (AccountNumberLengthException e) {
			System.out.println(e);
//			@SuppressWarnings("resource")
//			Scanner data= new Scanner(System.in);
//			this.accountNumber=data.nextLong();
//			this.setAccountNumber(accountNumber);
		}
		
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		try{int length=String.valueOf(phoneNumber).length();
		if(length==10) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new PhoneNumberLengthException(phoneNumber);
		}
		}catch (PhoneNumberLengthException e) {
			System.out.println(e);
//			@SuppressWarnings("resource")
//			Scanner data= new Scanner(System.in);
//			this.phoneNumber=data.nextLong();
//			this.setPhoneNumber(phoneNumber);
			// TODO: handle exception
		}
		
		
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
