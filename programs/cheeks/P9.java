import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P9
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the decimal number");
		int n=Integer.parseInt(bf.readLine());
		int sum=0;
		int rem=0;
		int m=1;
		while(n!=0)
		{
			rem=n%2;
			n=n/2;
			sum=sum+rem*m;
			m=m*10;
		}
		
		System.out.println("The equivalent binary number is: "+sum);
	}
}

output
Enter the decimal number
13
The equivalent binary number is: 1101
