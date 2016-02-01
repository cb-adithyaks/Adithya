package com.chargebee.adithya.training.phonedirectory;
import java.io.*;
import java.util.*;
import com.chargebee.adithya.training.prefix.MapWordsWithPrefix;
import com.chargebee.adithya.training.mapbylength.MapWordsWithLength;
public class PhoneDirectory{

	public Map <String, ArrayList<PhoneBook> >mapName(PhoneBook phonebook[]){
		Map<String, ArrayList<PhoneBook>> map = new HashMap<String,ArrayList<PhoneBook>>();					//Mapping Name with Phonebook object
		ArrayList<PhoneBook> phb;
		for(int i=0;i<phonebook.length;i++){
			if(map.get(phonebook[i].getName().toLowerCase())==null){
				phb=new ArrayList<PhoneBook>();
			}
			else{
				phb=map.get(phonebook[i].getName().toLowerCase());
			}
			phb.add(phonebook[i]);
			map.put(phonebook[i].getName().toLowerCase(),phb);
			
		}
		return map;
	}
	
	public Map mapPhoneNumbers(PhoneBook phonebook[]){
		Map<String, PhoneBook> map = new HashMap<String, PhoneBook>();
		
		for(int i=0;i<phonebook.length;i++){
			Phone phone=phonebook[i].getPhone();
			map.put(phone.getMobileNumber(),phonebook[i]);									//Mapping Numbers with Phonebook object
			map.put(phone.getHomeNumber(),phonebook[i]);
			map.put(phone.getWorkNumber(),phonebook[i]);
		}
		return map;
	}
	public Map mapCity(PhoneBook phonebook[]){
		Map<String, ArrayList<PhoneBook>> map = new TreeMap<String,ArrayList<PhoneBook>>();
		ArrayList<PhoneBook> phb;
		for(int i=0;i<phonebook.length;i++){
			if(map.get(phonebook[i].getAddress().getCity())==null){												//Mapping City with Phonebook object
				phb=new ArrayList<PhoneBook>();
			}
			else{
				phb=map.get(phonebook[i].getAddress().getCity().toLowerCase());
			}
			phb.add(phonebook[i]);
			map.put(phonebook[i].getAddress().getCity().toLowerCase(),phb);
			
		}
		return map;
	}
	
	public PhoneBook[] getPhoneBook(String arr[][]){
		PhoneBook[] phonebook=new PhoneBook[10];
		for(int i=0;i<10;i++){																					//returns phonebook object array
			phonebook[i]=new PhoneBook(arr[i]);
		}
		return phonebook;
	}
	
	public int print(ArrayList<PhoneBook> phonebook,int sno){
    	System.out.println("");
		for(PhoneBook ph: phonebook){
			Phone phone=ph.getPhone();
			Address address=ph.getAddress();
			System.out.format("%5d%30s%15s%15s%15s%30s",sno++,ph.getName(),phone.getMobileNumber(),phone.getHomeNumber(),phone.getWorkNumber(),address.getAddress());
			System.out.println();	
		}
		return sno;
	}
	
	public void printTag(){
		System.out.println ("\n-----------------------------");
    	System.out.println ("Phone Directory - Details Found");
    	System.out.println ("-----------------------------\n");
    	System.out.format("%5s%30s%15s%15s%15s%30s","S.No","Name","Mobile","Home","Work","Address");

	}
	
	//part of phonebook 
	public void print(PhoneBook phonebook){
		System.out.println("\nName : "+phonebook.getName());
		Phone phone=phonebook.getPhone();
		Address address=phonebook.getAddress();
		Map<String,String> phoneNumbers=phone.getPhoneNumbers();
		for(Map.Entry<String,String> entry:phoneNumbers.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println("Address : "+address.getAddress());
	}
	
	public static void main(String ar[])throws Exception{
		PhoneDirectory phoneDirectory=new PhoneDirectory();
		PhoneBook[] phonebook=Json.getPhonebook();
		//city vs pbook
		ArrayList<String> nameArray=Json.getNameArray();
		Map<String, ArrayList<PhoneBook>> mapCity=phoneDirectory.mapCity(phonebook);
		//name vs book
		Map<String, ArrayList<PhoneBook>> mapName=phoneDirectory.mapName(phonebook);
		Map<String, PhoneBook> mapPhoneNumbers=phoneDirectory.mapPhoneNumbers(phonebook);
				//small
		
		HashMap<Integer,ArrayList<String>> mapNameByLength=new MapWordsWithLength().mapByLength(nameArray);
		TreeMap<String,ArrayList<String>> mapNameByFirst3Chars=new MapWordsWithPrefix().mapByPrefix(nameArray);
		
		List<PhoneBook> tempPhoneBook=new ArrayList<PhoneBook>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ch=1;
		while(true){
			System.out.println("\n\n\t\t*******************PHONE DIRECTORY*******************");
			System.out.println("\n\n\n\t1. Search details for given Name\n\t2. Search Details with partial Details\n\t3. Search Details with phone number\n\tAny other option to quit the application");
			System.out.print("Enter your choice : ");
			ch=Integer.parseInt(br.readLine());
	
			switch(ch){
				case 1:{
					System.out.print("Enter the name of the person : ");
					String name=br.readLine().toLowerCase();
					ArrayList<PhoneBook> found=mapName.get(name);
					if(found!=null){
						phoneDirectory.printTag();
						phoneDirectory.print(found,1);
					}
					else{
						System.out.println("Sorry, no details found! Try again");
					}
					break;
				}
				case 2:{
					System.out.println("Search with partial information :");
					System.out.println("\n\t\t1. Enter the Prefix(first 3 characters) of the name of the person\n\t\t2. Enter the length of the name of the person\n\t\t3. Enter the city where person lives\n\t\t Any other to go back to previous menu ");
					System.out.print("Enter your choice : ");
					int choice=Integer.parseInt(br.readLine());
					if(choice==1){
						System.out.print("Enter Prefix(first 3 chars) : ");
						String first=br.readLine().toLowerCase();
						ArrayList<String> Names=new ArrayList<String>();
						if(mapNameByFirst3Chars.get(first)!=null){
							Names=mapNameByFirst3Chars.get(first);
							phoneDirectory.printTag();
							
						}else{
							System.out.println("Sorry, no details found! Try again");
							break;
						}
						int sno=1;
						Iterator itr=Names.iterator();
						while(itr.hasNext()){
							String name=itr.next().toString();
							ArrayList<PhoneBook> found=mapName.get(name);
							sno=phoneDirectory.print(found,sno);
						}
					}
					else if(choice==2){
						System.out.print("Enter the Length : ");
						int length=Integer.parseInt(br.readLine());
						ArrayList<String> Names=new ArrayList<String>();
						if(mapNameByLength.get(length)!=null){
							phoneDirectory.printTag();
							Names=mapNameByLength.get(length);
						}else{
							System.out.println("Sorry, no details found! Try again");
							//break;
						}
						int sno=1;																			//Serial Number, used for printing in format
						Iterator itr=Names.iterator();
						while(itr.hasNext()){
							String name=itr.next().toString();
							ArrayList<PhoneBook> found=mapName.get(name);
							sno=phoneDirectory.print(found,sno);
						}
					}
					else if(choice==3){
						System.out.print("Enter the city name : ");
						String city=br.readLine().toLowerCase();
						ArrayList<PhoneBook> found=mapCity.get(city);
						if(found==null){
							System.out.println("Sorry, no details found! Try again");
							break;
						}
						phoneDirectory.printTag();
						phoneDirectory.print(found,1);
					}
					break;
				}//case2
				case 3:{
					System.out.println("Search with phone number :");
					System.out.println("\nEnter the Person`s contact number");
					String number=br.readLine();
					PhoneBook found=mapPhoneNumbers.get(number);
					if(found==null){
						System.out.println("Sorry, no details found! Try again");
						break;
					}
					//phoneDirectory.printTag();
					phoneDirectory.print(found);
					break;
				}
				default:
					ch=10;
			}
			if(ch==10){
				break;
			}
		}//while
	}//main
}//class