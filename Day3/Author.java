/** This application helps in adding Author details
*/
package com.chargebee.training.day3;
class Author{
	String name;
	String email;
	char gender;
	Author(String Name,String Email,char Gender){
		name=Name;
		email=Email;
		gender=Gender;
	}
	String getName(){
		return name;
	}
	String getEmail(){
		return email;
	}
	void setEmail(String newEmail){
		email=newEmail;
	}
	char getGender(){
		return gender;
	}
	String toDisplay(){
		String ret=name+"("+gender")"+" at "+email;
		return ret;
	} 
	public static void main(String ar[]){
		Author ob=new Author("R.K Narayan","rknarayan@gmail.com",'M');
        	System.out.println(ob.toDisplay());
		ob.setEmail("rknarayan@yahoo.com");
		System.out.println(ob.toDisplay());
	}
}
