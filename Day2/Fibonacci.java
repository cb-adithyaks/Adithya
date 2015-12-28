/** This application prints fibonacci series upto N
*/
package Day_2;
public class Fibonacci
{
    public static void main(String ar[]){
	int n=Integer.parseInt(ar[0]);	//Number of terms is passed command line
	int i;
	int a[]=new int[n];
	a[0]=0;a[1]=1;a[2]=1;
	for(i=3;i<n;i++){
		a[i]=a[i-1]+a[i-2];	// Storing the N fibonacci terms	
	}
	for(i=0;i<n-1;i++){
		System.out.print(a[i]+",");  // Printing the fibonacci series
	}
	System.out.println(a[i]);
    }	
}