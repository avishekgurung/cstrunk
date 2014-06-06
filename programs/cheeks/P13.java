import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P13
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Lower Limit");
		int l=Integer.parseInt(bf.readLine());
		System.out.println("Enter the upper limit");
		int u=Integer.parseInt(bf.readLine());
		boolean flag=false;
		int counter=0;
		for(int i=l;i<=u;i++)
		{
			for(int j=1;j<=i/2;j++)
			{
				if(j*j==i)
				{
					flag=true;
				}
			}
			
			if(flag==true)
			{
				System.out.print(i+" ");
				counter++;
			}
			flag=false;
		}
		
		System.out.println("\nTotal: "+counter);
	}
}

output
Enter the Lower Limit
10
Enter the upper limit
50
16 25 36 49 
Total: 4