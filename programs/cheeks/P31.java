import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P31
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string");
		String s=bf.readLine();
		String temp="";
		for(int i=s.length()-1;i>=0;i--)
			temp=temp+s.charAt(i);
		if(temp.equals(s))
			System.out.println("Palindrome");
		else
			System.out.println("not Palindrome");
			
	}
}

output
Enter the string
malayalam
Palindrome