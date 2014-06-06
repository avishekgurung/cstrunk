import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P4
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of Digits");
		int n=Integer.parseInt(bf.readLine());
		int a[]=new int[n];
		System.out.println("Enter the digits");
		for(int i=0;i<n;i++)
		{
			System.out.print(1+i+": ");
			a[i]=Integer.parseInt(bf.readLine());
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		
		System.out.print("\n");
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		System.out.println("The sorted numbers are");
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}

OUTPUT

Enter the number of Digits
5
Enter the digits
1: 3
2: 2
3: 6
4: 3
5: 8
3 2 6 3 8 
The sorted numbers are
2 3 3 6 8 