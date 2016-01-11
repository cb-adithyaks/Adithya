package com.chargebee.adithya.training.StudentDemo;

public class ResultGenerator{
	public static void generateResult(Student ob){
		System.out.print(ob.getStudentId()+ "\t");
		System.out.print(ob.getStudentName()+ "\t");
		if(ob.getGender()){
			System.out.print("Male\t");
		}
		else{
			System.out.print("Female\t");
		}
		System.out.print(ob.getSubject().getMarks1()+"\t"+ob.getSubject().getMarks2()+"\t"+ob.getSubject().getMarks3()+"\t");
 	    System.out.print((ob.getSubject().getMarks1()+ob.getSubject().getMarks2()+ob.getSubject().getMarks3())+"\t");
 		System.out.println((ob.getSubject().getMarks1()+ob.getSubject().getMarks2()+ob.getSubject().getMarks3())/3);
	}
}