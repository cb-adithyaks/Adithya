package com.chargebee.adithya.training.IncomeTax;
import java.util.*;
public class IncomeTaxMain{
	public static void main(String ar[]){
		Employee employee[]=new Employee[20];
		int i=0;
		Scanner in=new Scanner(System.in);
		while(true){
			System.out.print("Enter Employee`s name : ");
			String name=in.nextLine();
			System.out.print("Enter Employee`s gender(M/F) : ");
			char gender=in.next().toUpperCase().charAt(0);
			System.out.print("Enter Employee`s total annual income : ");
			Double salary=in.nextDouble();
			System.out.print("Enter number of Employee`s dependents : ");
			int d=in.nextInt();
			employee[i]=new Employee(name,gender,salary,d);
			System.out.print("Enter 'print' to display employees details :\n anyother to not print ");
			String ch=in.next();
			employee[i].setTaxableIncome(IncomeTaxCalculator.calculateTaxableIncome(employee[i].getTotalIncome(),employee[i].getDependents()));
			employee[i].setTaxAmount(IncomeTaxCalculator.taxCalculate(employee[i].getTaxableIncome(),employee[i].getGender()));
			if(ch.toLowerCase().equals("print")){
				for(int j=0;j<=i;j++){
					System.out.print((j+1)+". ");
					System.out.println(employee[j].print());
				}
			}
			System.out.print("Enter 'yes' to add more employee`s details, any other to quit : ");
			ch=in.next();			 
			i++;
			if(!ch.toLowerCase().equals("yes")){
					break;
			}
		}//while
		for(int j=0;j<i;j++){
					System.out.print((j+1)+". ");
					System.out.println(employee[j].print());
		}
	}
}