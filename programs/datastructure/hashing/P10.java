import java.util.HashMap;
import java.util.Map;

class P10
{
	public static void main(String[] args) 
	{
		String str = "asdzddbs";
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		char result = '\0';
		
		for(int i=0;i<str.length();i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				result = str.charAt(i);
				break;
			}
			map.put(str.charAt(i), 1);
		}
		System.out.println("Result "+result);
	}
}