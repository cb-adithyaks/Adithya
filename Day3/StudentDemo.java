//This application helps in understanding the static member concepts better, 


import java.io.*;
class Student{
	int studentId;
	String studentName;
	boolean gender;
	Subject subjects;
	BufferedReader br;
	Student(){
		studentId=0;
		studentName="Nil";
		subjects= new Subject();
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	void get(){
	    try{
	    		System.out.print("Enter Student Id :");
	        studentId=Integer.parseInt(br.readLine());
	        System.out.print("Enter Student Name :");
	        studentName=br.readLine();
	        System.out.print("Enter his gender(male/female)");
	        if(br.readLine().toLowerCase().equals("male")){
	            gender=true;
	       	}
		else{
		    gender=false;
		}
		subjects.get();
	    }catch(Exception e){}
	}
	void set(int id, String name, boolean gender, Subject sub){
	    studentId=id;
	    studentName=name;
	    this.gender=gender;
	    subjects=sub;
	}
}
class Subject{
    String subject1;
    float marks1;
    String subject2; 
    float marks2;
    String subject3;
    float marks3;

    void get(){
        try{
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));	
    	    System.out.print("Enter name of subject :");
    	    subject1=br.readLine();
    	    System.out.print("Enter mark in "+subject1+" :");
            marks1=Float.parseFloat(br.readLine());	
    	    System.out.print("Enter name of subject :");
    	    subject2=br.readLine();
    		System.out.print("Enter mark in "+subject2+" :");
    		marks2=Float.parseFloat(br.readLine());	
    		System.out.print("Enter name of subject :");
    		subject3=br.readLine();
    		System.out.print("Enter mark in "+subject3+" :");
    		marks3=Float.parseFloat(br.readLine());
    	}catch(Exception e){}
    }
    void set(String sub1,float m1,String sub2,float m2,String sub3,float m3){
    	subject1=sub1;
    		marks1=m1;
    	subject2=sub2;
    	marks2=m2;
    	subject3=sub3;
    	marks3=m3;
    }
}

class ResultGenerator{
	static void generateResult(Student ob){
		System.out.print(ob.studentId+"\t");
		System.out.print(ob.studentName+"\t");
		if(ob.gender){
			System.out.print("Male\t");
		}
		else{
			System.out.print("Female\t");
		}
		System.out.print(ob.subjects.marks1+"\t"+ob.subjects.marks2+"\t"+ob.subjects.marks3+"\t");
 	    System.out.print((ob.subjects.marks1+ob.subjects.marks2+ob.subjects.marks3)+"\t");
 		System.out.println((ob.subjects.marks1+ob.subjects.marks2+ob.subjects.marks3)/3);
	}
}

class StudentDemo{
	void storeStudentData(Student ob){
		Student temp= new Student();
		temp.get();

 ob.set(temp.studentId,temp.studentName,temp.gender,temp.subjects);
 		 
	}
	public static void main(String ar[])
	{
		Student ob=new Student();
		StudentDemo sd_ob= new StudentDemo();
		sd_ob.storeStudentData(ob);
		System.out.println("Id\t Name\t Gender\t"+ob.subjects.subject1+"\t"+ob.subjects.subject2+"\t"+ob.subjects.subject3+"\tTotal\t Average");
		ResultGenerator.generateResult(ob);
	}
}