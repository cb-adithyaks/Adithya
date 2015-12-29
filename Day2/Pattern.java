/** To print the given pattern
*/
package Day_2;
import java.util.*;
class Pattern
{
    public static void main(String ar[]) throws Exception{
        int i,j;
	long pattern=1;
	Scanner in=new Scanner(System.in);
	System.out.print("Enter the pattern length :");
	int p=in.nextInt();
	if(p>1 || p<=9){
	    for(i=1;i<=p;i++){
                for(j=i;j<p;j++){
		    System.out.print(' ');
		    System.out.println(pattern*pattern);	// The pattern is 1,121,12321,1234321,...
		    pattern=pattern*10+1;		        // i.e, 1^2, 11^2, 111^2, 1111^2,...
                    }
		}			
	    }
	}
}