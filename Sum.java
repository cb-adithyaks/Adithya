/** This application simply displays "Hello World" in standard output screen
*/
import java.util.*;
class Sum
{
	public static void main(String ar[])
	{
		Scanner in= new Scanner(System.in);
		int x=in.nextInt();
		int y=in.nextInt();
		int sum=x+y;
		System.out.println("Their sum is :"+sum);
	}
}

