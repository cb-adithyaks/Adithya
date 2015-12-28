/** This application prints fibonacci series upto N
*/

class Fibonacci
{
	public static void main(String ar[])
	{
		int n=Integer.parseInt(ar[0]);
		int i;
		int a[]=new int[n];
		a[0]=0;a[1]=1;a[2]=1;
		for(i=3;i<n;i++)
		{
			a[i]=a[i-1]+a[i-2];
		}
		for(i=0;i<n-1;i++)
			System.out.print(a[i]+",");
		System.out.println(a[i]);
	}
}