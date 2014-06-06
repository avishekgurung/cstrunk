import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P15
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the two numbers");
		int n=Integer.parseInt(bf.readLine());
		int m=Integer.parseInt(bf.readLine());
		int x=n;
		int mul=0;
		while(n!=0)
		{
			mul=mul+m;
			n--;
		}
		
		System.out.println(x+" * "+m+" = "+mul);
	}
}

output
Enter the two numbers
2
3
2 * 3 = 6