/** This application uses abstract methods and interfaces
*/
package com.chargebee.adithya.training.Zoo;
import java.io.*;
class Zoo{
	public static void main(String ar[])throws Exception{
		System.out.println("\nWelcome to Zoo \n\n");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Animal animals[]=new Animal[20];
		int i=0;
		while(true){
			System.out.println("\n1 - Add a dog to zoo\n2 - Add a Cow to zoo\n3 - Add a Bat to zoo\n4 - Add a Ostrich to zoo\n5 - Add a Parrot to zoo\n6 - Print the animals in zoo\n7 - Print animals that can fly\n8 - Print animals that are herbivores\nAny other to exit from Zoo");
			int ch=Integer.parseInt(br.readLine());
			switch(ch){
				case 1:{
					animals[i]=new Dog('M',"white",15);
					break;
				}
				case 2:{
					animals[i]=new Cow('F',"black",10);
					break;
				}
				case 3:{
					animals[i]=new Bat('M',"white",5);
					break;
				}
				case 4:{
					animals[i]=new Ostrich('F',"black",8);
					break;
				}
				case 5:{
					animals[i]=new Parrot('M',"green",3);
					break;
				}
				case 6:{
					for(int j=0;j<i;j++){
						try{
							System.out.println(animals[j].print());
						}catch(Exception e){}
					}
					break;
				}
				case 7:{
					for(int j=0;j<i;j++){
					    try{
							if(animals[j] instanceof CanFly){
								System.out.println(animals[j].print());
							}
						}catch(Exception e){}
					}
					break;
				}
				case 8:{
					for(int j=0;j<i;j++){
						try{
							if((animals[j]) instanceof IsHerbivorous){
								System.out.println(animals[j].print());
							}
						}catch(Exception e){}
					}
					break;
				}
				default:{
					ch=-1;
					break;
				}
			}
			i++;
			if(ch==-1)
				break;
		}	
		br.close();
	}
}