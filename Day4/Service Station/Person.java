package com.chargebee.adithya.training.ServiceStation;

public class Person{
	private String name;
	private int age;
	private String contact;
	private int emp_id;
	public Person(String n,int a,String c){		//Customer
		name=n;
		age=a;
		contact=c;
		emp_id=0;
	}
	public Person(String n,int a,String c,int id){	//Employee, can be a customer
		name=n;
		age=a;
		contact=c;
		emp_id=id;
	}
	public void setContact(String nc){
		contact=nc;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getContact(){
		return contact;
	}
	public int getEmp_id(){
		return emp_id;
	}
}