package com.chargebee.adithya.w1d5;
import java.util.*;
import java.io.*;
public class EmployeeSortedList{
	
	public static void main(String ar[])throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of employees : ");
		int n=Integer.parseInt(br.readLine());
		Employee emp[]=new Employee[n];
		int age,ch1,i=0;
		Double salary;
		String name,ch;
		while(i<n){
			System.out.println("Enter the Employee`s details : \n");
			System.out.print("Name : ");
			name=br.readLine();
			System.out.print("Age : ");
			age=Integer.parseInt(br.readLine());
			System.out.print("Salary : ");
			salary=Double.parseDouble(br.readLine());
			emp[i++]=new Employee(name,salary,age);
		}
		
		System.out.println("\n1 - Sort employees based on their name\n2 - Sort employees based on their age\nAnyother - Sort employees based on their salary");
		ch1=Integer.parseInt(br.readLine());
		if(ch1==1){
			Arrays.sort(emp,new Comparator<Employee>(){
				public int compare(Employee e1,Employee e2){
					return (e1.getName().compareTo(e2.getName()));
				}
			});
		}
		else if(ch1==2){
			Arrays.sort(emp,new Comparator<Employee>(){
				public int compare(Employee e1,Employee e2){
					return(e1.getAge()-e2.getAge());
				}
			});
		}
		else{
			Arrays.sort(emp,new Comparator<Employee>(){
				public int compare(Employee e1,Employee e2){
					if(e1.getSalary()>e2.getSalary()){
						return 1;
					}
					else{
						return -1;
					}
				}
			});

		}
		System.out.println("S.No\t\tName\t\tAge\t\tSalary");
		for(int j=0;j<n;j++){
			System.out.println((j+1)+"\t\t"+emp[j].print());
		}
		br.close();
	}
}