/** This application rotates the given 2D matrix towards left or right
*/
package Day_2;
import java.util.*;
class Rotate{
    public static void main(String ar[]){
        int i,j,ch;
	Scanner in=new Scanner(System.in);
        int n=in.nextInt();
	int mat[][]=new int[n][n];
	int mat_rot[][]=new int[n][n];
	for(i=0;i<n;i++)
	for(j=0;j<n;j++)						// Input for the matrix
        mat[i][j]=in.nextInt();		
	System.out.print("Enter 0-left and 1-right rotation :");
		
	ch=in.nextInt();						//Choice - Left or right rotation
	int i1=0,j1=0;						//Indices for new rotated Matrix
	if(ch==1){
	    for(j=0;j<n;j++){
                for(i=n-1;i>=0;i--){
		    mat_rot[i1][j1++]=mat[i][j];
		    System.out.print(mat[i][j]+" ");		//Right rotation	
		}
		System.out.println();
		i1++;j1=0;
	     }
	}
	else{
            for(j=n-1;j>=0;j--){
	        for(i=0;i<n;i++){
	           mat_rot[i1][j1++]=mat[i][j];
	           System.out.print(mat[i][j]+" ");		//Left rotation
		}
		System.out.println();
	        i1++;j1=0;
	    }
	}
	}//Main
}// Class