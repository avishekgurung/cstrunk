import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Sample
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the digits");
		int n=Integer.parseInt(bf.readLine());
		int x=n;
		int r,s=0;
		while(n!=0)
		{
			r=n%10;
			n=n/10;
			s=s*10+r;
		}
		
		System.out.println("Reverse: "+s);
	}
}

output
Enter the digits
123456
Reverse: 654321