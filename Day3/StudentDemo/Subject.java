package com.chargebee.adithya.training.StudentDemo;
public class Subject{
    private String subject1;
    private float marks1;
    private String subject2; 
    private float marks2;
    private String subject3;
    private float marks3;
     
    public String getSubject1(){
	return subject1;
    }
    public String getSubject2(){
	return subject2;
    }
    public String getSubject3(){
	return subject3;
    }
    public float getMarks1(){
	return marks1;
    }
    public float getMarks2(){
	return marks2;
    }
    public float getMarks3(){
	return marks3;
    }
    public void set(String sub[],float m[]){
    	subject1=sub[0];
    	marks1=m[0];
    	subject2=sub[1];
    	marks2=m[1];
    	subject3=sub[2];
    	marks3=m[2];
    }
}
