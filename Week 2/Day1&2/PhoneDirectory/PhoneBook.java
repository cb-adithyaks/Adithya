package com.chargebee.adithya.training.phonedirectory;
import java.util.*;

public class PhoneBook{
	private String name;
	private	Phone phone;
	private	Address address;
	PhoneBook(String details[]){
		name=details[0];
		phone=new Phone(details[1],details[2],details[3]);
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
