package com.chargebee.adithya.training.CarsDemo;

public class Truck extends Car{
	private int weight;
	public Truck(int s,double rp,String c,int w){
		super(s,rp,c);
		weight=w;
	}
	public double getSalePrice(){
		if(weight>2000){
			return (0.9*super.getSalePrice());
		}
		else{
		 	return (0.8*super.getSalePrice());
		}
	}
	public String print(){
		String ret="\n\nTruck"+"Car speed : "+getSpeed()+”\nRegular price of car : "+getRegularPrice()+"\nColor of car : "+getColor()+"\nWeight of the car : "+weight+"\nSale price : Rs"+this.getSalePrice();
		return ret;
	} 
}
