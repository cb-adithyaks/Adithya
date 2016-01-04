package com.chargebee.training.day3;
import java.util.*;
class IncomeTax{
	String name;
	char gender;
	double totalIncome;
	double taxableIncome;
	double taxAmount;
	int dependents;
	IncomeTax(String nam,char gen,double Inc,int d){
		name=nam;
		gender=gen;
		totalIncome=Inc;
		dependents=d;
	}
	static void taxCalulate(IncomeTax employee[],int n){
		for(int i=0;i<n;i++){
		    employee[i].taxableIncome=employee[i].totalIncome-15000-employee[i].dependents*5000;	//Standard 15k off for all
		    employee[i].taxAmount=0;
			if(employee[i].taxableIncome>250000 && employee[i].gender=='M'){
				if(employee[i].taxableIncome>500000){
					if(employee[i].taxableIncome>1000000){
						employee[i].taxAmount+=0.1*(250000)+0.2*(500000)+(employee[i].taxableIncome-1000000)*0.3;		// For men, 10% ->250 to 500k
					}
					else{
						employee[i].taxAmount=0.2*(employee[i].taxableIncome-500000)+0.1*250000;
					}		
				}																									    // 20% -> 500k to 1000k
				else{																									// 30% -> greater than 1000k
					employee[i].taxAmount+=0.1*(employee[i].taxableIncome-250000);										
				}
			}
			else if(employee[i].taxableIncome>300000 && employee[i].gender=='F'){
				if(employee[i].taxableIncome>600000){																	// For women, 10% ->300k to 500k
					if(employee[i].taxableIncome>1000000){																// 20% -> 600k to 1000k	
						employee[i].taxAmount+=0.1*(300000)+0.2*(600000)+(employee[i].taxableIncome-1000000)*0.3;		// 30% -> greater than 1000k
					}
					else{
						employee[i].taxAmount=0.2*(employee[i].taxableIncome-600000)+0.1*300000;
					}		
				}	
				else{
					employee[i].taxAmount+=0.1*(employee[i].taxableIncome-300000);
				}
			}
		}
	}
	public void display(){
		System.out.println(name+" | "+gender+" | "+taxableIncome+" | "+taxAmount);
	}
	public static void main(String ar[]){
		IncomeTax employee[]=new IncomeTax[20];
		int i=0;
		Scanner in=new Scanner(System.in);
		while(true){
			System.out.print("Enter Employee`s name : ");
			String name=in.next();
			System.out.print("Enter Employee`s gender(M/F) : ");
			char gender=in.next().toUpperCase().charAt(0);
			System.out.print("Enter Employee`s total annual income : ");
			Double salary=in.nextDouble();
			System.out.print("Enter number of Employee`s dependents : ");
			int d=in.nextInt();
			employee[i++]=new IncomeTax(name,gender,salary,d);
			System.out.print("Enter 'print' to display employees details :");
			String ch=in.next();
			IncomeTax.taxCalulate(employee,i);
			if(ch.toLowerCase().equals("print")){
				for(int j=0;j<i;j++){
					System.out.print((j+1)+". ");
					employee[j].display();
				}
			}
			System.out.print("Enter 'yes' to add more employee`s details, any other to quit : ");
			ch=in.next();			 
			if(!ch.toLowerCase().equals("yes")){
					break;
			}
		}//while
		
	}
}