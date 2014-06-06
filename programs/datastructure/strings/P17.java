import java.util.HashMap;
import java.util.Map;

class P17
{
	public static void main(String[] args) 
	{
		String text = "amazon development center";
		String patt = "aenr";
		
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<patt.length();i++)
			map.put(patt.charAt(i), 0);
		
		int x = 0;
		
		char []arr = text.toCharArray();
		int l = arr.length;
		for(int i=0;i<l;i++)
		{
			if(!map.containsKey(arr[i]))
			{
				arr[x] = arr[i];
				x++;
			}
			if(i == l-1)
			{
				while(x != l)
				{
					arr[x] = '\0';
					x++;
				}
			}
		}
		
		System.out.println(arr);
	}
}

/*
The solution is manageable. It might not be very very accurate because of the text is like "AAAAAAAAAAAAAAAAA" and pattern = A, then, the iteration will be doing twice.
Therefore, time complexity = O(n2) 
*/