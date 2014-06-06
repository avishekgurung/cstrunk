import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P29
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the text");
		String text=bf.readLine();
		String temp="";
		for(int i=0;i<text.length();i++)
		{
			char c=text.charAt(i);
			if(text.charAt(i)=='t' && text.charAt(i+1)=='h' && text.charAt(i+2)=='e' && text.charAt(i+3)==' ')
			{
				i=i+3;
				continue;
			}
			
			temp=temp+text.charAt(i);
		}
		System.out.println(temp);
	}
}

output
Enter the text
He is the man of the jungle.
He is man of jungle.