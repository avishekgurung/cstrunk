import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P42
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter any prime number");
		int n=Integer.parseInt(bf.readLine());
		
		boolean flag=true;
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
				flag=false;
		}
		
		if(flag==false)
		{
			System.out.println(n+" is not prime");
			System.exit(0);
		}
		
		for(int i=n+1;;i++)
		{
			flag=true;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
					flag=false;
			}
			
			if(flag==true)
			{
				System.out.println("Next prime number: "+i);
				break;
			}
		}
	}
}

output
Enter any prime number
23
Next prime number: 29