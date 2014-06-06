import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Math.*;

class P10
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Binary Number");
		int n=Integer.parseInt(bf.readLine());
		int sum=0;
		int rem=0;
		int m=1;
		
		while(n!=0)
		{
			rem=n%10;
			n=n/10;
			sum=sum+rem*m;
			m=m*2;
		}
		
		System.out.println("\nThe equivalent decimal number is: "+sum);
	}
}


output
Enter the Binary Number
1101

The equivalent decimal number is: 13