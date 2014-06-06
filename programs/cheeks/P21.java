import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P21
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		int n=Integer.parseInt(bf.readLine());
		boolean flag=true;
		for(int i=2;i<n/2;i++)
		{
			if(n%i==0)
				flag=false;
		}
		
		if(flag==true)
			System.out.println("Prime Number");
		else
			System.out.println("Composite Number");
	}
}

output
Enter the number
23
Prime Number