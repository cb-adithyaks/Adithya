package com.chargebee.adithya.training.IncomeTax;

public class IncomeTaxCalculator{
	int mb1,mb2,mb3;	//Male Income bases
	int fb1,fb2,fb3;	//Female Income bases
	int mr1,mr2,mr3;	//Male tax rates for different bases
	int fr1,fr2,fr3;	//Female tax rates for different bases
	public IncomeTaxCalculator(int mb[],int fb[],int mr[],int fr[]){
		mb1=mb[0];mb2=mb[1];mb3=mb[2];
		fb1=fb[0];fb2=fb[1];fb2=fb[2];
		mr1=mr[0];mr2=mr[1];mr3=mr[2];
		fr1=fr[0];fr2=fr[1];fr3=fr[2];
	}
	public static double calculateTaxableIncome(double sal,int d){
		return (sal-(10000*d)-15000);
	}
	public static double taxCalculate(double taxableIncome,char gender){
		double taxAmount=0;
		if(taxableIncome>250000 && gender=='M'){
			if(taxableIncome>500000){
				if(taxableIncome>1000000){
					taxAmount+=0.1*(250000)+0.2*(500000)+(taxableIncome-1000000)*0.3;		
				}
				else{
					taxAmount=0.2*(taxableIncome-500000)+0.1*250000;
				}																							// For men, 10% ->250 to 500k
			}																							    // 20% -> 500k to 1000k
			else{																							// 30% -> greater than 1000k
				taxAmount+=0.1*(taxableIncome-250000);										
			}
		}
		else if(taxableIncome>300000 && gender=='F'){
				if(taxableIncome>600000){																	// For women, 10% ->300k to 500k
					if(taxableIncome>1000000){																// 20% -> 600k to 1000k	
						taxAmount+=0.1*(300000)+0.2*(600000)+(taxableIncome-1000000)*0.3;					// 30% -> greater than 1000k
					}
					else{
						taxAmount=0.2*(taxableIncome-600000)+0.1*300000;
					}		
				}	
				else{
					taxAmount+=0.1*(taxableIncome-300000);
				}
		}
		return taxAmount;

	}	
}