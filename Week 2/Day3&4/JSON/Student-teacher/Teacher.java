package com.chargebee.adithya.training.json;

public class Teacher{
	private String name;
	private String classesTakingCareOf[];
	private String dateOfJoining;
	private String id;
	private int salary;
	public Teacher(String name,String id,String dateOfJoining,String classesTakingCareOf[],int salary){
		this.dateOfJoining=dateOfJoining;
		this.id=id;
		this.classesTakingCareOf=classesTakingCareOf;
		this.name=name;
		this.salary=salary;
	}
	public String getDateOfJoining(){	
		return dateOfJoining;
	}
	public String getId(){
		return id;
	}
	public String[] getclassesTakingCareOf(){
		return classesTakingCareOf;
	}
	public String getName(){
		return name;
	}
	public int getSalary(){
		return salary;
	}
}
