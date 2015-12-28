/** A simple application using conditional statements, to print the greatest number amoung three numbers
*/
import java.util.*;
class Greatest
{
	public static void main(String ar[])
	{
		int a,b,c;
		Scanner in= new Scanner(System.in);
		a=in.nextInt();					//Getting 3 numbers as input
		b=in.nextInt();
		c=in.nextInt();
		if(a>b && a>c)
			System.out.println("The greatest is "+a);
		else if(b>c)
			System.out.println("The greatest is "+b);
		else
			System.out.println("The greatest is "+c);
	}
}
