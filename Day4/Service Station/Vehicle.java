package com.chargebee.adithya.training.ServiceStation;

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
		service_charge=Vehicle.calculateServiceCharge(service,service_type);
	}
	public static int calculateServiceCharge(String service,String service_type){
		int service_charge=0;
		if(service_type.equals("Normal service")){
			if(service.equals("Car")){
				service_charge=5000;
			}
			else if(service.equals("Bike")){
				service_charge=3000;
			}
			else{
				service_charge=10000;
			}
		}
		else if(service_type.equals("Engine breakdown")){
			if(service.equals("Car")){
				service_charge=10000;
			}
			else if(service.equals("Bike")){
				service_charge=5000;
			}
			else{
				service_charge=20000;
			}
		}
		else{
			if(service.equals("Car")){
				service_charge=15000;
			}
			else if(service.equals("Bike")){
				service_charge=10000;
			}
			else{
				service_charge=30000;
			}
		}
		return service_charge;
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