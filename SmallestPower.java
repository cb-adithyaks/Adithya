/** An application that prints smallest power of X that is greater than Y
*/
import java.util.*;
class SmallestPower
{
	public static void main(String ar[])
	{
		int x,y,ans=0;
		Scanner in=new Scanner(System.in);
		x=in.nextInt();
		y=in.nextInt();
		if((x==1 && y>=1) ||(x==0))						//Corner case, if x=1 and y>=1 then there is no power of 1>1 
			System.out.println("No answer");
		else
			{
				while(y>1)
				{
					y/=x;
					ans++;
				}
	        		System.out.println("The smallest power of X that is greater than Y is "+ans);							
			}
	}
}