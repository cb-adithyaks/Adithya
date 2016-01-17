package com.chargebee.adithya.training.PhoneDirectory;
import java.io.*;
import java.util.*;
import com.chargebee.adithya.training.prefix.*;
import com.chargebee.adithya.training.mapbylength.*;
public class PhoneDirectory{
	public HashMap mapName(PhoneBook phonebook[]){
		HashMap<String, ArrayList<PhoneBook>> map = new HashMap<String,ArrayList<PhoneBook>>();
		ArrayList<PhoneBook> phb;
		for(int i=0;i<phonebook.length;i++){
			if(map.get(phonebook[i].getName())==null){
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
	public HashMap mapMobileNumber(PhoneBook phonebook[]){
		HashMap<String, PhoneBook> map = new HashMap<String, PhoneBook>();
		for(int i=0;i<phonebook.length;i++){
			map.put(phonebook[i].getPhone().getMobileNumber(),phonebook[i]);
		}
		return map;
	}
	public HashMap mapHomeNumber(PhoneBook phonebook[]){
		HashMap<String, PhoneBook> map = new HashMap<String, PhoneBook>();
		for(int i=0;i<phonebook.length;i++){
			map.put(phonebook[i].getPhone().getHomeNumber(),phonebook[i]);
		}
		return map;
	}
	public HashMap mapWorkNumber(PhoneBook phonebook[]){
		HashMap<String, PhoneBook> map = new HashMap<String, PhoneBook>();
		for(int i=0;i<phonebook.length;i++){
			map.put(phonebook[i].getPhone().getWorkNumber(),phonebook[i]);
		}
		return map;
	}
	public HashMap mapCity(PhoneBook phonebook[]){
		HashMap<String, ArrayList<PhoneBook>> map = new HashMap<String,ArrayList<PhoneBook>>();
		ArrayList<PhoneBook> phb;
		for(int i=0;i<phonebook.length;i++){
			if(map.get(phonebook[i].getAddress().getCity())==null){
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
	public String[][] getMulDimArray(){
		String arr[][]={{"Adithya K S","8939705452","9087762173","43562374","59","1st main road","chennai"},{"Ashwath Narayan","8939705453","9087762174","43562375","60","2nd main road","bangalore"},{"Ajay Vasudev","8939705454","9087762175","43562376","61","3rd main road","mumbai"},{"Aravind S","8939705455","9087762176","43562377","62","4th main road","kerala"},{"Vishnu P S","8939705456","9087762177","43562378","63","5th main road","kashmir"},{"Barath Venkatesan","8939239843","9962919728","22249898","90","6th main road","delhi"},{"Jeeva Shankar","8939705552","9087761173","43560374","59","7th main road","Hydreabad"},{"Sanju anand","8939701112","9087761112","43561112","12","8th main road","chennai"},{"Hemanth Subramani","8056005452","9080032173","43581234","13","9th main road","lucknow"},{"Abid C P","9444231452","9089923173","22562374","19","10th main road","kerala"}};
		return arr;
	}
	public String[] getNameArray(String arr[][]){
		String name[]=new String[arr.length];
		for(int i=0;i<arr.length;i++){
			name[i]=arr[i][0];
		}
		return name;
	}
	public PhoneBook[] getPhoneBook(String arr[][]){
		PhoneBook[] phonebook=new PhoneBook[10];
		for(int i=0;i<10;i++){
			phonebook[i]=new PhoneBook(arr[i]);
		}
		return phonebook;
	}
	public void print(ArrayList<PhoneBook> phonebook){
		
		int i=1;
    	System.out.println();
		for(PhoneBook ph: phonebook){
			Phone phone=ph.getPhone();
			Address address=ph.getAddress();
			System.out.format("%5d%30s%15s%15s%15s%30s",i++,ph.getName(),phone.getMobileNumber(),phone.getHomeNumber(),phone.getWorkNumber(),address.getAddress());
			System.out.println();	
		}
	}
	public void printTag(){
		System.out.println ("\n-----------------------------");
    	System.out.println ("Phone Directory - Details Found");
    	System.out.println ("-----------------------------\n");
    	System.out.format("%5s%30s%15s%15s%15s%30s","S.No","Name","Mobile","Home","Work","Address");

	}
	public void print(PhoneBook phonebook){
		System.out.println("\nName : "+phonebook.getName());
		Phone phone=phonebook.getPhone();
		Address address=phonebook.getAddress();
		System.out.println("Mobile, home and Work Numbers : "+phone.getMobileNumber()+","+phone.getHomeNumber()+","+phone.getWorkNumber());
		System.out.println("Address : "+address.getAddress());
	}
	public static void main(String ar[])throws Exception{
		PhoneDirectory phoneDirectory=new PhoneDirectory();
		String arr[][]=phoneDirectory.getMulDimArray();
		PhoneBook[] phonebook=phoneDirectory.getPhoneBook(arr);
		HashMap<String, ArrayList<PhoneBook>> mapCity=phoneDirectory.mapCity(phonebook);
		HashMap<String, ArrayList<PhoneBook>> mapName=phoneDirectory.mapName(phonebook);
		HashMap<String, PhoneBook> mapMobileNumber=phoneDirectory.mapMobileNumber(phonebook);
		HashMap<String, PhoneBook> mapHomeNumber=phoneDirectory.mapHomeNumber(phonebook);
		HashMap<String, PhoneBook> mapWorkNumber=phoneDirectory.mapWorkNumber(phonebook);
		List<String> Names=Arrays.asList(phoneDirectory.getNameArray(arr));
		ArrayList<String> nameArray=new ArrayList<String>(Names);
		HashMap<Integer,ArrayList<String>> mapNameByLength=new MapWordsWithLength().mapByLength(nameArray);
		TreeMap<String,ArrayList<String>> mapNameByFirst3Chars=new MapWordsWithPrefix().mapByPrefix(nameArray);
		ArrayList<PhoneBook> tempPhoneBook;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ch=1;
		while(true){
	
			System.out.println("\n\n\t\t*******************PHONE DIRECTORY*******************");
			System.out.println("\n\n\n\t1. Search details for given Name\n\t2. Search Details with partial Details\n\t3. Search Details with phone number\n\tAny other option to quit the application");
			System.out.print("Enter your choice : ");
			ch=Integer.parseInt(br.readLine());
	
			switch(ch){
				case 1:{
					System.out.print("Enter the full name of the person : ");
					String name=br.readLine().toLowerCase();
					ArrayList<PhoneBook> found=mapName.get(name);
					if(found!=null){
						phoneDirectory.printTag();
						phoneDirectory.print(found);
					}
					else{
						System.out.println("Sorry, no details found! Try again");
					}
					break;
				}
				case 2:{
					System.out.println("Search with partial information :");
					System.out.println("\n\t\t1. Enter the Prefix(first 3 characters) of the name of the person\n\t\t2. Enter the length of the name of the person\n\t\t3. Enter the city where person lives\n\t\t Any other to go back to previous menu ");
					int choice=Integer.parseInt(br.readLine());
					if(choice==1){
						System.out.print("Enter Prefix(first 3 chars) : ");
						String first=br.readLine().toLowerCase();
						ArrayList<String> names=mapNameByFirst3Chars.get(first);
						if(names==null){
							System.out.println("Sorry, no details found! Try again");
							break;
						}
						if(names.size()>=1){
							phoneDirectory.printTag();
						}
						else{
							System.out.println("Sorry, no details found! Try again");
						}
						Iterator itr=names.iterator();
						while(itr.hasNext()){
							String name=itr.next().toString();
							ArrayList<PhoneBook> found=mapName.get(name);
							if(found!=null){
								phoneDirectory.print(found);
							}
							else{
								System.out.println("Sorry, no details found! Try again");
							}
						}
					}
					else if(choice==2){
						System.out.print("Enter the Length : ");
						int length=Integer.parseInt(br.readLine());
						ArrayList<String> names=mapNameByLength.get(length);
						if(names.size()>=1){
							phoneDirectory.printTag();
						}
						Iterator itr=names.iterator();
						while(itr.hasNext()){
							String name=itr.next().toString();
							ArrayList<PhoneBook> found=mapName.get(name);
							if(found!=null){
								phoneDirectory.print(found);
							}
							else{
								System.out.println("Sorry, no details found! Try again");
							}
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
						phoneDirectory.print(found);
					}
					break;
				}//case2
				case 3:{
					System.out.println("Search with phone number :");
					System.out.println("\n\t\t1. Enter the Person`s Mobile number\n\t\t2. Enter the Person`s Home number\n\t\t3. Enter the Person`s work number\n\t\t Any other to go back to previous menu ");
					int choice=Integer.parseInt(br.readLine());
					if(choice==1){
						System.out.print("Enter the Person`s Mobile number : ");
						String number=br.readLine();
						PhoneBook found=mapMobileNumber.get(number);
						if(found==null){
							System.out.println("Sorry, no details found! Try again");
							break;
						}
						//phoneDirectory.printTag();
						phoneDirectory.print(found);
					}
					else if(choice==2){
						System.out.print("Enter the Person`s home number : ");
						String number=br.readLine();
						PhoneBook found=mapHomeNumber.get(number);
						if(found==null){
							System.out.println("Sorry, no details found! Try again");
							break;
						}
						//phoneDirectory.printTag();
						phoneDirectory.print(found);
						
					}
					else if(choice==3){
						System.out.print("Enter the Person`s work number : ");
						String number=br.readLine();
						PhoneBook found=mapWorkNumber.get(number);
						if(found==null){
							System.out.println("Sorry, no details found! Try again");
							break;
						}
						//phoneDirectory.printTag();
						phoneDirectory.print(found);					
					}
					break;
				}
				default:{
					ch=10;
				}
			}//switch
			if(ch==10)
				break;
		}//while
	}//main
}//class