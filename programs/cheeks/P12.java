import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class P12
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		int n=Integer.parseInt(bf.readLine());
		int sum=0;
		while(n!=0)
		{
			sum=sum+n;
			n--;
		}
		System.out.println("Triangular Number: "+sum);
	}
}

output
Enter the number
6
Triangular Number: 21