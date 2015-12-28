/** This application prints the smallest and largest number in a given array
*/
package Day_2;
import java.util.*;
class MinMax{
    public static void main(String ar[]){
    	int i,min,max;
    	Scanner in=new Scanner(System.in);
    	int n=in.nextInt();				//Array size
    	int a[]=new int[n];
    	for(i=0;i<n;i++){
        a[i]=in.nextInt();			//Input
    	}
    	min=max=a[0];
    	for(i=1;i<n;i++){
	    if(a[i]<min){
	    min=a[i];
            }
            else if(a[i]>max){			
	    max=a[i];		
	    }
	}
	System.out.println("Smallest :"+min+"\t"+"Largest :"+max);
    }
}