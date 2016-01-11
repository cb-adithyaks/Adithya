package com.chargebee.adithya.training.CarsDemo;
public class MyOwnAutoShop{

	public static void main(String ar[]){
		System.out.println("\n\nCars available in showroom:\nOne Sedan car\nTwo Ford cars\nOne car");
		System.out.println("\nThe details of the cars available one by one :");
		Sedan sedan=new Sedan(120,500000,"white",15);
		Ford ford1=new Ford(150,800000,"Black",2011,10);
		Ford ford2=new Ford(180,1000000,"Blue",2012,8);
        	Car car=new Car(100,450000,"Grey"); 
        	System.out.println(sedan.print());
    	System.out.println(ford1.print());
        	System.out.println(ford2.print());
       	System.out.println(car.print());
	}
}