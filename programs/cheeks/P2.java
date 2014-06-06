import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P2
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the character");
		int n=bf.read();
		if(n>=48 && n<=57)
			System.out.println((char)n);
		else
			System.out.println(n);
	}
}

Output


Enter the character
A
65