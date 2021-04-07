package com.data.stockmarket.model;
/** 
 * This Program is a Exception for Invalid Phone Number
 * @author goutham.balaji
 * @date 06-04-2021
 * 
 * */

public class PhoneNumberLengthException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	long phone_number;
	public PhoneNumberLengthException(long phone_number) {
		this.phone_number=phone_number;
	}
	@Override
	public String toString() {
		return "Invalid Phone Number please Re-enter";
	}


}
