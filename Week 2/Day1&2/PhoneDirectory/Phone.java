package com.chargebee.adithya.training.phonedirectory;


public class Phone{
	private String mobile;
	private String work;
	private String home;
	public Phone(String mobile,String work,String home){
		this.mobile=mobile;
		this.work=work;
		this.home=home;
	}
	public String getMobileNumber(){
		return mobile;
	}
	public String getWorkNumber(){
		return work;
	}
	public String getHomeNumber(){
		return home;
	}
	
	//
}
