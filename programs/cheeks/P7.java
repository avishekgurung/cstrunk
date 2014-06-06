import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P7
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the year");
		int n=Integer.parseInt(bf.readLine());
		if(n%4==0)
				System.out.println("Leap Year");
		else
			System.out.println("Ordinary Year");
	}
}

output
Enter the year
1992
Leap Year