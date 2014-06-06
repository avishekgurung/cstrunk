import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P28
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the String");
		String s=bf.readLine();
		int length=s.lastIndexOf("");
		System.out.println("String length: "+length);
	}
}

output
Enter the String
avishek
String length: 7