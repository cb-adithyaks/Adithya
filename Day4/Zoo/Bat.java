package com.chargebee.adithya.training.Zoo;
public class Bat extends Mammal implements CanFly{
	private char gender;
	private String color;
	private int age;
	public Bat(char g,String c,int a){
		gender=g;
		color=c;
		age=a;
	}
	public String movement(){
		return("They use their wings for locomotion");
	}
	public boolean canFly(){
		return true;
	}

	
	
	public String print(){
		String ret="\n Details of the bat :\n"+"Gender : "+gender+"\nColor : "+color+"\n Age : "+age+"\nMode of locomotion :"+movement();
		return ret;
	}
}
