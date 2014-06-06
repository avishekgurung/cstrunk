import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P39
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a String");
		String s1=bf.readLine();
		
		System.out.println("Enter a another String");
		String s2=bf.readLine();
		
		int length=s2.length();
		int count;
		for(int i=0;i<s1.length();i++)
		{
			count=0;
			for(int j=0;j<s2.length();j++)
			{
				if(i<s1.length() && s1.charAt(i)==s2.charAt(j))
				{
					count++;
					i++;
				}
				else
					break;
			}
			if(count==length)
			{
				System.out.println(s2+" is a subset of "+s1);
				System.exit(0);
			}
		}
		System.out.println(s2+" is NOT a subset of "+s1);
	}
}

output
Enter a String
smells like teen spirit
Enter a another String
spirit
spirit is a subset of smells like teen spirit