import java.util.HashMap;
import java.util.Map;

class P18
{
	public static void main(String[] args) 
	{
		String text = "bananas";
		func1(text);
		func2(text);
	}
	
	public static String func1(String text)
	{
		String temp = "";
		for(int i=text.length()-1;i>=0;i--)
		{
			boolean flag = true;
			for(int j=i-1;j>=0;j--)
			{
				if(text.charAt(i) == text.charAt(j))
					flag = false;
			}
			
			if(flag)
				temp = text.charAt(i)+temp;
		}
		System.out.println(temp); //O(n2)
		return temp;
	}
	
	public static String func2(String text)
	{
		String temp = "";
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		
		for(int i=0;i<text.length();i++)
		{
			if(!map.containsKey(text.charAt(i)))
			{
				temp = temp+text.charAt(i);
				map.put(text.charAt(i), 0);
			}
				
		}
		System.out.println(temp); //O(n)
		return temp;
	}
}