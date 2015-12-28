/** This application calculates and prints simple and compound interest
*/
import java.util.*;
import java.lang.Math.*;
class InterestCalc
{
	public static void main(String ar[])
	{
		double p,r,t;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter principle, rate and time-yrs as type double");
		p=in.nextDouble();
		r=in.nextDouble();
		t=in.nextDouble();
		double si=p*r*t/100;
		double x=(1+r/100);
		double ci=p*Math.pow(x,t)-p;
		System.out.println("Simple interest :"+si);
		System.out.println("Compound interest :"+ci);
	}
}