import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P19
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		int n=Integer.parseInt(bf.readLine());
		int sum=0;
		while(n!=0)
		{
			int rem=n%10;
			n=n/10;
			sum=sum+rem;
			if(sum>9 && n==0)
			{
				n=sum;
				sum=0;
			}
		}
		System.out.println("The sum of a number is "+sum);
	}
}

output
Enter the number
987
The sum of a number is 6