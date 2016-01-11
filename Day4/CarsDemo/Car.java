package com.chargebee.adithya.training.CarsDemo;
public class Car{
	private int speed;
	private double regularPrice;
	private String color;
	public Car(int s,double rp, String c){
		speed=s;
		regularPrice=rp;
		color=c;
	}
	public double getSalePrice(){
		return (regularPrice+30000);// Registration fee and road tax
	}
	public int getSpeed(){
		return speed;
	}
	public double getRegularPrice(){
		return regularPrice;
	}
	public String getColor(){
		return color;
	}
	public String print(){
		String ret="\n\nCar "+"\nCar speed : "+speed+"\nRegular price of car : "+regularPrice+"\nColor of car : "+color+"\nSale price : Rs"+getSalePrice();
		return ret;
	}
}