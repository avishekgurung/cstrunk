import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P17
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string");
		String s=bf.readLine();
		int pos=0;
		for(int i=0;i<s.length();i++)
		{
			int x=s.charAt(i);
			if(x>=65 && x<=90)
				pos=x-64;
			else
				pos=x-96;
			
			System.out.print(s.charAt(i)+" "+pos+", ");
		}
		
	}
}

output
Enter the string
avishek
a 1, v 22, i 9, s 19, h 8, e 5, k 11, 