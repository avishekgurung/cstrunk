import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P25
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the String");
		String s=bf.readLine();
		String temp="";
		for(int i=s.length()-1;i>=0;i--)
		{
			temp=temp+s.charAt(i);
		}
		
		System.out.println(temp);
	}
}

output
Enter the String
avishek
kehsiva