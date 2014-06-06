import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P24
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		int n=Integer.parseInt(bf.readLine());
		int rem=0;
		int sum=0;
		int count=0;
		int dup=n;
		while(n!=0)
		{
			rem=n%10;
			n=n/10;
			if(count==0)
				sum=rem;
			else
				sum=sum*10+rem;
			count++;
		}
		if(dup==sum)
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	}
}

output
Enter the number
1223221
Palindrome
