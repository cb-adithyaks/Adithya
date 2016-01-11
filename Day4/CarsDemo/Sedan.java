package com.chargebee.adithya.training.CarsDemo;

public class Sedan extends Car{
	private int length;
	public Sedan(int s,double rp,String c,int l){
		super(s,rp,c);
		length=l;

	}
	public double getSalePrice(){
		if(length>20){
			//System.out.print(super.getSalePrice());
			return(0.95*super.getSalePrice());
		}
		else{
			return(0.9*super.getSalePrice());
		}
	}
	public String print(){
		String ret="\n\nSedan car"+"\nCar speed : "+getSpeed()+"\nRegular price of car : "+getRegularPrice()+" \nColor of car : "+getColor()+"\nLength of the car : "+length+"\nSale price : Rs"+this.getSalePrice();
		return ret;
	}
}