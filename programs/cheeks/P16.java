import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P16
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the two numbers x/y");
		int n=Integer.parseInt(bf.readLine());
		int m=Integer.parseInt(bf.readLine());
		int div=n;
		while(div>=m)
		{
			div=div-m;
		}
		
		System.out.println(n+ " / "+m+" = "+div);
	}
}

output
Enter the two numbers x/y
5
3
5 / 3 = 2