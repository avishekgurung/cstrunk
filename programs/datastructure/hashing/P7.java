import java.util.HashMap;
import java.util.Map;

class P7
{
	public static void main(String[] args) 
	{
		int a[] = {1,2,4,5,6,3,9,11,7};
		int b[] = {9,7,5,3};
		int k = 11;
		
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<a.length;i++)
		{
			map.put(a[i], 0);
		}
		
		for(int i=0;i<b.length;i++)
		{
			int x = k - b[i];
			if(map.containsKey(x))
				System.out.println(x+"\t"+b[i]);
		}
	}
}