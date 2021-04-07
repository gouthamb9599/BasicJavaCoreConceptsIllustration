package com.data.stockmarket.model;
/** 
 * This Program is a Exception for Invalid Account Number
 * @author goutham.balaji
 * @date 06-04-2021
 * 
 * */
public class AccountNumberLengthException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	long acc_number;
	public AccountNumberLengthException(long acc_number) {
		this.acc_number=acc_number;
	}
	@Override
	public String toString() {
		return "Invalid Account Number please Re-enter";
	}

}
