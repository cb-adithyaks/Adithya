/** This application helps in adding Author details
*/
package com.chargebee.training.day3;
class Author{
	private String name;
	private String email;
	private char gender;
	Author(String Name,String Email,char Gender){
		name=Name;
		email=Email;
		gender=Gender;
	}
	public String getName(){
		return name;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String newEmail){
		email=newEmail;
	}
	public char getGender(){
		return gender;
	}
	public String toDisplay(){
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
