import java.util.HashMap;
import java.util.Map;

class P9
{
	public static void main(String[] args) 
	{
		String str = "abzddab";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char result='\0';
		
		for(int i=0;i<str.length();i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				int value = map.get(str.charAt(i));
				value++;
				map.put(str.charAt(i), value);
			}
			else
			{
				map.put(str.charAt(i), 1);
			}
		}
		
		for(int i=0;i<str.length();i++)
		{
			int value = map.get(str.charAt(i));
			if(value == 1)
				result = str.charAt(i);
		}
		System.out.println("Result: "+result);
	}
}