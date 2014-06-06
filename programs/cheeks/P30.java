import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P30
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string");
		String s=bf.readLine();
		String temp="";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
				continue;
			temp=temp+s.charAt(i);
		}
		System.out.println(temp);
	}
	
}

output
Enter the string
never give up
nvr gv p
