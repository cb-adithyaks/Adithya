/** This application prints the summation of indices and prints even if its even else odd
*/
package Day_2;
import java.io.*;
class SumEvenOdd{
    public static void main(String ar[]){
        String str="";
	int sum=0,i;
	try{
	    str=ar[0];
	}
	catch(Exception e){
	    System.out.println("You forgot to pass string as command line arguments");
	    System.out.println("No problem, enter the string Now :");
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    try{
	        str=br.readLine();
	    }catch(Exception e1){}
	}
	for(i=0;i<str.length();i++){
	    sum+=str.charAt(i)-96;
	}
	if(sum%2==0){
	    System.out.println("even");
        }
	else{
            System.out.println("odd");
	}
    }
}