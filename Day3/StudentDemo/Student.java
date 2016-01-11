package com.chargebee.adithya.training.StudentDemo;
public class Student{
	private int studentId;
	private String studentName;
	private boolean gender;
	private Subject subjects;
	
	public Student(){
		studentId=0;
		studentName="Nil";
		subjects= new Subject();
	}
	public void setStudentId(int id){
		studentId=id;
	}
	public void setStudentName(String n){
		studentName=n;
	}
	public void setGender(boolean g){
		gender=g;
	}
	public void setSubjects(Subject sub){
	    subjects=sub;
	}
	public int getStudentId(){
	    return studentId;
	}
	public String getStudentName(){
	    return studentName;
	}
	public boolean getGender(){
	    return gender;
	}
	public Subject getSubject(){
	    return subjects;
	}
}