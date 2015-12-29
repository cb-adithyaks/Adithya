/** This application prints fibonacci series upto N
*/
package Day_2;
public class Fibonacci
{
    public void print_fibonacci(int N){
	if(N==0){
	    System.out.print(“0,”);
	    return 0;		
	}	
	else if(N==1){
	    System.out.print(“1,”);			//base case
	    return 1;
	}
	else{
	    System.out.print((fibonacci(N-1)+fibonacci(N-2))+”,”);
	}
    }
    public static void main(String ar[]){
	int n=Integer.parseInt(ar[0]);	//Number of terms is passed command line
	print_fibonacci(n);
    }	
}