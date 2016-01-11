package com.chargebee.adithya.training.Zoo;

public class Parrot extends Bird implements IsHerbivorous,CanFly{
	private char gender;
	private String color;
	private int age;
	public Parrot(char g,String c,int a){
		color=c;
		age=a;
		gender=g;
	}
	public String movement(){
		return("Parrot use their limbs for locomotion");
	}
	
	
	public boolean isHerbivorous(){
		return true;
	}
	public boolean canFly(){
	return true;
	}
	public String print(){
		String ret="\n Details of the Parrot :\nParrot is a Bird"+"\nGender : "+gender+"\n Color : "+color+"\nAge : "+age+"\nMode of locomotion :"+movement();
		return ret;
	}
}
