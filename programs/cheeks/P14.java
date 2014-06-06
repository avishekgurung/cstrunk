import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P14
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of digts");
		int n=Integer.parseInt(bf.readLine());
		int a[]=new int[n];
		System.out.println("Enter the digits");
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(bf.readLine());
		
		int small=a[0];
		int large=a[0];
		for(int i=0;i<n;i++)
		{
			if(small>a[i])
				small=a[i];
			if(large<a[i])
				large=a[i];
		}
		
		System.out.println("Largest: "+large+"\t Smallest: "+small);
	}
}

output
Enter the number of digts
5
Enter the digits
12
22
14
33
26
Largest: 33	 Smallest: 12
