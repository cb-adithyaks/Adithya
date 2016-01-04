/** This application implements a simple animal class
*/
import java.io.*;
class Animal{
	boolean is_pet;
	String name;
	String ownerName;
	BufferedReader br;
	public void animalEating(){
		System.out.println(name+" is eating");
	}
	private void animalSleeping(){
		System.out.println(name+" is sleeping");
	}
	public void getInput(){
		try{
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the animal name");
			name=br.readLine();
			System.out.println("Enter 'yes' if animal is a pet");
			if((br.readLine()).toLowerCase().equals("yes")){
				is_pet=true;
			}
			else{	
				is_pet=false;
			}
			System.out.println("Enter the owner`s name:");
			ownerName=br.readLine();
			//br.close();
		}catch(Exception e){}
	}
	public void printDetails(){
		System.out.print(name+"\t\t");
		System.out.print(ownerName+"\t\t");
		if(is_pet){
			System.out.println("yes");
		}
		else{
			System.out.println("No");
		}
	}
	public static void main(String ar[]) throws Exception{
		Animal ob[]=new Animal[20];
		int j,i=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			ob[i]=new Animal();
			ob[i].getInput();
			System.out.println("Total animals created is :"+(i+1));
			System.out.println("The details of those animals: ");
			System.out.println("S.No\t\t Name\t\t Owner\t\t Pet");
			for(j=0;j<=i;j++){
				System.out.print((j+1)+"\t\t");
				ob[j].printDetails();
			}
			i++;
			System.out.print("Enter 'quit' to quit:");
			if((br.readLine()).toLowerCase().equals("quit")){
				break;
			}
		}
		br.close();
	}
}