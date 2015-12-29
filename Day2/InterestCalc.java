/** This application calculates and prints simple and compound interest
*/
package Day_2;
import java.util.*;
import java.lang.Math.*;
class InterestCalc{
    public static void main(String ar[]){
	double p,r,t;
	//Using scanner to get i/p
	Scanner in=new Scanner(System.in);		
	// Getting values for p,r,t
	System.out.print("Enter principle :");
	p=in.nextDouble();
	System.out.print("Enter rate :");
	r=in.nextDouble();
	System.out.print("Enter period in yrs :");
	t=in.nextDouble();
	double si=p*r*t/100;
	double x=(1+r/100);	
	double ci=p*Math.pow(x,t)-p;
	System.out.println("Simple interest :"+si);
	System.out.println("Compound interest :"+ci);
    }
}