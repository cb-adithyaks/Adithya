package com.chargebee.adithya.w1d5;
public class Employee{
	private String name;
	private double salary;
	private int age;	
	Employee(String n,Double s,int a){
		name=n;
		salary=s;
		age=a;
	}
	public Double getSalary(){
	    return salary;
	}
	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
	public String print(){
		return(name+"\t\t"+age+"\t\t"+salary+" ");
	}	    		
}