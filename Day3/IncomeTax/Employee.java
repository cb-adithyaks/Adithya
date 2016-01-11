package com.chargebee.adithya.training.IncomeTax;

public class Employee{
	String name;
	char gender;
	double totalIncome;
	double taxableIncome;
	double taxAmount;
	int dependents;
	Employee(String nam,char gen,double Inc,int d){
		name=nam;
		gender=gen;
		totalIncome=Inc;
		dependents=d;
	}
	public char getGender(){
		return gender;
	}
	public double getTotalIncome(){
		return totalIncome;
	}
	public double getTaxableIncome(){
		return taxableIncome;
	}

	public int getDependents(){
		return dependents;
	}
	public void setTaxableIncome(double ti){
		taxableIncome=ti;
	}
	public void setTaxAmount(double amount){
		taxAmount=amount;
	}


	public String print(){
		String ret=name+" | "+gender+" | "+taxableIncome+" | "+taxAmount;
		return ret;
	}
}