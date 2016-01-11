package com.chargebee.adithya.training.StudentDemo;

import java.io.*;

public class StudentDemo{
	public void storeStudentData(Student ob){
		try{
	    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    		System.out.print("Enter Student Id :");
	    		ob.setStudentId(Integer.parseInt(br.readLine()));
	    		System.out.print("Enter Student Name :");
	    		ob.setStudentName(br.readLine());
	    		System.out.print("Enter Student`s gender(male/female)");
			if(br.readLine().toLowerCase().equals("male")){
	    		ob.setGender(true);
	   		}
			else{
			    ob.setGender(false);
			}
			String sub[]=new String[3];
			float m[]=new float[3];
			Subject subjects=new Subject();
			System.out.print("Enter name of subject :");
    			sub[0]=br.readLine();
    			System.out.print("Enter mark in "+sub[0]+" :");
       			m[0]=Float.parseFloat(br.readLine());	
    			System.out.print("Enter name of subject :");
    			sub[1]=br.readLine();
    			System.out.print("Enter mark in "+sub[1]+" :");
    			m[1]=Float.parseFloat(br.readLine());	
    			System.out.print("Enter name of subject :");
    			sub[2]=br.readLine();
    			System.out.print("Enter mark in "+sub[2]+" :");
    			m[2]=Float.parseFloat(br.readLine());
    			subjects.set(sub,m);
 			ob.setSubjects(subjects); 
			br.close();
		}catch(Exception e){}
	}
	public static void main(String ar[])
	{
		Student ob=new Student();
		StudentDemo sd_ob= new StudentDemo();
		sd_ob.storeStudentData(ob);
		System.out.println("Id\t Name\t Gender\t"+ob.getSubject().getSubject1()+"\t"+ob.getSubject().getSubject2()+"\t"+ob.getSubject().getSubject3()+"\tTotal\t Average");
		ResultGenerator.generateResult(ob);
	}
}