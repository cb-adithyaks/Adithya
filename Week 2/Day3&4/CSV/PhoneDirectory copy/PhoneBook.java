//package com.chargebee.adithya.training.phonedirectory;
import java.util.*;

public class PhoneBook{
	private String name;
	private	Phone phone;
	private	Address address;
	PhoneBook(String details[]){
		name=details[0];
		Map<String,String> phoneNumbers=new HashMap<String,String>();
		phoneNumbers.put("Mobile",details[1]);
		phoneNumbers.put("Work",details[2]);
		phoneNumbers.put("Home",details[3]);
		System.out.println(phoneNumbers);
		phone=new Phone(phoneNumbers);
		address=new Address(details[4],details[5],details[6]);
	}
	public String getName(){
		return name;
	}
	public Phone getPhone(){
		return phone;
	}
	public Address getAddress(){
	        return address;
	}
		
}
