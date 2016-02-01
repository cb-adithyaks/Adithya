package com.chargebee.adithya.training.json;

import org.json.simple.parser.*;
import org.json.*;

import java.io.*; 

import java.util.*;

public class JsonStudentTeacher{

	public static void main(String args[]) throws Exception{
		JSONParser parser = new JSONParser();

		Object ob = parser.parse(new BufferedReader(new FileReader("students-teachers.json")));

		JSONObject jsonObject = new JSONObject(ob.toString());

		JSONObject studentObject = jsonObject.getJSONObject("Student");
		JSONObject teacherObject = jsonObject.getJSONObject("Teacher");

		JSONArray studentMarks = studentObject.getJSONArray("Marks");
		Mark marks[] = new Mark[5];

		for(int index=0;index<studentMarks.length();index++){
			JSONObject markObject = studentMarks.getJSONObject(index);
			marks[index]=new Mark(markObject.getInt("Mark"),markObject.getString("Subject"));
		}
			
		Student student = new Student(	
						studentObject.getString("Date Of Joining"),
						studentObject.getString("ID"),
						studentObject.getString("Name"),
						studentObject.getString("Std"),
						marks
					     );


		JSONArray teacherClasses = teacherObject.getJSONArray("Classes Taking Care Of");
		String classesTakingCareOf[]=new String[12];

		for(int index=0;index<teacherClasses.length();index++){
			classesTakingCareOf[index]=teacherClasses.getString(index);
		}
	
		Teacher teacher = new Teacher(
						teacherObject.getString("Name"),
						teacherObject.getString("ID"),
						teacherObject.getString("Date Of Joining"),
						classesTakingCareOf,
						teacherObject.getInt("Salary")
					     );	
		
		System.out.println(student.getName()+","+student.getId()+","+student.getStd()+","+student.getDateOfJoining());
		System.out.println(teacher.getName()+","+teacher.getId()+","+teacher.getSalary()+","+teacher.getDateOfJoining());

	}
}