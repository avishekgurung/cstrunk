import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P26
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the order of a matrix");
		int n=Integer.parseInt(bf.readLine());
		int m=Integer.parseInt(bf.readLine());
		System.out.println("Enter the elements of the 1st matrix");
		int a[][]=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				a[i][j]=Integer.parseInt(bf.readLine());
			}
		
		System.out.println("Enter the elements of the 2st matrix");
		int b[][]=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				b[i][j]=Integer.parseInt(bf.readLine());
			}
		
		int c[][]=new int[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				c[i][j]=a[i][j]+b[i][j];
			}
		
		System.out.println("Result");
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(c[i][j]+"  ");
			}
			System.out.println();
		}
			
		
		
	}
}

output
Enter the order of a matrix
3
3
Enter the elements of the 1st matrix
1
0
0
0
1
0
0
0
1
Enter the elements of the 2st matrix
1
2
3
4
5
6
7
8
9
Result
2  2  3  
4  6  6  
7  8  10  