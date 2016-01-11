package com.chargebee.adithya.w1d4;
import java.util.Random;
import java.io.*;
public class MobileList{
	public static void main(String ar[])throws Exception{
		int ch,i=0;
		Mobile list[]=new Mobile[10];
		Random r=new Random();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("1- Add a mobile\n2- Print the list of Mobiles\nAny other to exit\nEnter your choice: ");
			ch=Integer.parseInt(br.readLine());
			if(ch==1){
				list[i]=new Mobile(){
					public void remainingCharge(){
						try{
							System.out.print("Enter Mobile Name : ");
							setName(br.readLine());
							setRemainingCharge(r.nextInt(100));
						}catch(Exception e){}
					}
				};
				list[i].remainingCharge();
				i++;
			}
			else if(ch==2){
				for(int j=0;j<i;j++){
					System.out.println("\nName : "+list[j].getName());
					System.out.println("Remaining Charge : "+list[j].getRemainingCharge()+"\n");
				}
			}
			else{
				break;
			}
		}
		br.close();	
	}
}