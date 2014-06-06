import java.util.HashMap;
import java.util.Map;

class P3
{
	public static void main(String[] args) 
	{
		int[] arr = {3,2,1,2,2,3};
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++)
			map.put(arr[i], 0);
		
		for(int i=0;i<arr.length;i++)
			if(map.containsKey(arr[i]))
			{
				System.out.println("First Repeating Element "+arr[i]);
				break;
			}
	}
	
}
