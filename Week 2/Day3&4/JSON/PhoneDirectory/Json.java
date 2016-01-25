package com.chargebee.adithya.training.phonedirectory;

import org.json.simple.parser.*;
import org.json.*;

import java.io.*; 

import java.util.*;

public class Json{
	public static PhoneBook[] getPhonebook(){
		try{
		JSONParser parser = new JSONParser();

		Object ob = parser.parse(new BufferedReader(new FileReader("PhoneBook.json")));

		JSONObject jsonObject = new JSONObject(ob.toString());

		JSONArray phonebook = jsonObject.getJSONArray("PhoneBook");
		System.out.println(phonebook.length());
		PhoneBook phoneBook[]=new PhoneBook[phonebook.length()];
		for(int index=0;index<phonebook.length();index++){
			JSONObject phonebookObject = phonebook.getJSONObject(index);
			String details[]=new String[7];
			details[0]=phonebookObject.getString("Name");
			details[1]=phonebookObject.getString("Mobile number");
			details[2]=phonebookObject.getString("Work number");
			details[3]=phonebookObject.getString("Home number");
			details[4]=phonebookObject.getString("Flat No");
			details[5]=phonebookObject.getString("Road");
			details[6]=phonebookObject.getString("City");
			phoneBook[index]=new PhoneBook(details);
		}	
		return phoneBook;}catch(Exception e){}
		return new PhoneBook[10];
	}
	public static ArrayList<String> getNameArray(){
		try{
		PhoneBook phonebook[]=getPhonebook();
		ArrayList<String> nameArray=new ArrayList<String>();
		for(int i=0;i<phonebook.length;i++){
			nameArray.add(phonebook[i].getName());
		}
		return nameArray;}catch(Exception e){}
		return new ArrayList<String>();
	}
}