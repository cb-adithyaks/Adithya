package com.chargebee.adithya.training.Zoo;

public class Ostrich extends Bird{
	private char gender;
	private String color;
	private int age;
	public Ostrich(char g,String c,int a){
		color=c;
		age=a;
		gender=g;
	}
	public String movement(){
		return("Ostrich use their limbs for locomotion");
	}
	
	
	
	public String print(){
		String ret="\n Details of the Ostrich :\nOstrich is a Bird"+"\nGender : "+gender+"\n Color : "+color+"\nAge : "+age+"\nMode of locomotion :"+movement();
		return ret;
	}
}
