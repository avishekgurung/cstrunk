import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class P1
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		//String str = "remember";
		System.out.print("Enter string: ");
		String str = bf.readLine();
		String output = "";
		Map<Character,Character> map = new HashMap<Character,Character>();
		for(int i=0;i<str.length();i++)
		{
			if(!map.containsKey(str.charAt(i)))
			{
				output = output+str.charAt(i);
				map.put(str.charAt(i), str.charAt(i));
			}
		}
		
		System.out.println("Unique Characters: "+output);
	}
}
