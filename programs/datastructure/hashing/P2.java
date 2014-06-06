import java.util.Map;
import java.util.HashMap;

class P2
{
	public static void main(String[] args) {
		int a[] = {1,2,2,3,3,4,6};
		int b[] = {3,2,2,1,1,5};
		boolean flag = true;
		
		
		Map<Integer, Integer> map_a = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map_b = new HashMap<Integer, Integer>();
		
		for(int i=0;i<a.length;i++)
		{
			map_a.put(a[i], 0);
		}
		
		for(int i=0;i<b.length;i++)
		{
			map_b.put(b[i], 0);
		}
		
		if(map_b.size() != map_a.size())
			flag = false;
		
		for(int i=0;i<a.length;i++)
		{
			map_b.remove(a[i]);
		}
		
		if(map_b.size() != 0)
			flag = false;
		
		if(flag)
			System.out.println("same");
		else
			System.out.println("not same");
	}
}
