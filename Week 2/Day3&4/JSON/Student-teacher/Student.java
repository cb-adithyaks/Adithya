package com.chargebee.adithya.training.json;

public class Student{
	private String name;
	private String std;
	private String dateOfJoining;
	private String id;
	private Mark marks[];
	public Student(String dateOfJoining,String id,String name,String std,Mark marks[]){
		this.dateOfJoining=dateOfJoining;
		this.id=id;
		this.marks=marks;
		this.name=name;
		this.std=std;
	}
	public String getDateOfJoining(){	
		return dateOfJoining;
	}
	public String getId(){
		return id;
	}
	public Mark[] getMarks(){
		return marks;
	}
	public String getName(){
		return name;
	}
	public String getStd(){
		return std;
	}
}
