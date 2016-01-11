package com.chargebee.adithya.training.Zoo;

class Dog extends Mammal{
	private char gender;
	private String color;
	private int age;
	Dog(char g,String c,int a){
		color=c;
		age=a;
		gender=g;
	}
	public String movement(){
		return("Dogs use their limbs for locomotion ");
	}
	
	
	
	public String print(){
		String ret="\n Details of the Dog :\nDog is a mammal"+"\nGender : "+gender+"\n Color : "+color+"\nAge : "+age+"\nMode of locomotion :"+movement();
		return ret;
	}
}
