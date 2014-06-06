import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Math.*;

class P20
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		int n=Integer.parseInt(bf.readLine());
		int x=n;
		int sum=0;
		while(x!=0)
		{
			int rem=x%10;
			x=x/10;
			sum=(int)pow(rem,3)+sum;
		}
		
		if(sum==n)
			System.out.println("Amstrong Number");
		else
			System.out.println("Not an Amstrong Number");
	}
}

output
Enter the number
370
Amstrong Number