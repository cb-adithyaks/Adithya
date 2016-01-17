package com.chargebee.adithya.training.servicestation;

public class Vehicle{
	private String brand;
	private String color;
	private String service;
	private String service_type;
	private int service_charge;
	public Vehicle(String a,String b,String c,String type){
		brand=a.toLowerCase();
		color=b.toLowerCase();
		service=c.toLowerCase();
		service_type=type.toLowerCase();
	}
	public void setServiceCharge(int serviceCharge){
		service_charge=serviceCharge;
	}
	
	public String getBrand(){
		return brand;
	}
	public String getColor(){
		return color;
	}
	public String getService(){
		return service;
	}
	public String getServiceType(){
		return service_type;
	}
	public int getServiceCharge(){
		return service_charge;
	}
}