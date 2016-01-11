package com.chargebee.adithya.training.CarsDemo;
public class Ford extends Car{
	private int year;
	private int manufacturerDiscount;
	public Ford(int s,double rp,String c,int y,int d){
		super(s,rp,c);
		year=y;
		manufacturerDiscount=d;

	}
	public double getSalePrice(){
		//System.out.print(super.getSalePrice());
		return((100-manufacturerDiscount)*super.getSalePrice()/100);
	}
	public String print(){
		String ret="\n\nFord car "+"\nCar speed : "+getSpeed()+"\nRegular price of car : "+getRegularPrice()+"\nColor of car : "+getColor()+"\nYear of manufacture of the car : "+year+"\nDISCOUNT :"+manufacturerDiscount+"%"+"\nSale price : Rs"+this.getSalePrice();
		return ret;
	} 
}
