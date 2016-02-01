package com.chargebee.adithya.training.phonedirectory;
import java.util.*;
public class Phone{
	private Map<String,String> phoneNumbers;

	public Phone(Map<String,String> phoneNumbers){
		this.phoneNumbers=new HashMap<String,String>();
		System.out.println(phoneNumbers);
		this.phoneNumbers=phoneNumbers;
	}

	public Map<String,String> getPhoneNumbers(){
		return phoneNumbers;
	}
	public String getMobileNumber(){
		return(phoneNumbers.get("Mobile"));
	}
	public String getHomeNumber(){
		return(phoneNumbers.get("Home"));
	}
	public String getWorkNumber(){
		return(phoneNumbers.get("Work"));
	}

	public void addContact(String tag,String phoneNumber){
		phoneNumbers.put(tag,phoneNumber);
	}
}
