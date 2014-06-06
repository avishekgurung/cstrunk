import java.util.HashMap;
import java.util.Map;

class P8
{
	public static void main(String[] args) 
	{
		String str = "heavens came down and glory filled the earth";
		String toRemove = "aeiou";
		String result = "";
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<toRemove.length();i++)
			map.put(toRemove.charAt(i), 0);
		
		for(int i=0;i<str.length();i++)
		{
			if(!map.containsKey(str.charAt(i)))
				result = result+str.charAt(i);
		}
		System.out.println("Output "+result);
	}
}

//Time = O(m)+O(n); Space = O(m)+O(n); 