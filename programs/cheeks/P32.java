import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P32
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a paragraph");
		String s=bf.readLine();
		int wrd=0,sen=0,vow=0,con=0;
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u')
				vow++;
			else if(c==' ')
				wrd++;
			else if(c=='.')
				sen++;
			else
				con++;
		}
		
		System.out.println("words: "+wrd);
		System.out.println("Sentences: "+sen);
		System.out.println("Vowels: "+vow);
		System.out.println("Consonants: "+con);
		
	}

	
	output
	Enter a paragraph
The book audacity of hope. The book written by Barak Obama.
words: 10
Sentences: 2
Vowels: 19
Consonants: 28
