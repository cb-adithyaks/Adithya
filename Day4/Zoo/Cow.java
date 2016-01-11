package com.chargebee.adithya.training.Zoo;

public class Cow extends Mammal implements IsHerbivorous{
	private char gender;
	private String color;
	private int age;
	Cow(char g,String c,int a){
		color=c;
		age=a;
		gender=g;
	}
	public String movement(){
		return("Cows use their limbs for locomotion ");
	}
	
	
	public boolean isHerbivorous(){
	return true;
	}
	public String print(){
		String ret="\n Details of the Cow :\nCow is a mammal"+"\nGender : "+gender+"\n Color : "+color+"\nAge : "+age+"\nMode of locomotion :"+movement();
		return ret;
	}
}
