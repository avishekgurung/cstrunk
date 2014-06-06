import java.util.HashMap;
import java.util.Map;

class P11
{
	public static void main(String[] args) 
	{
		int arr[]={5,3,2,4,6};
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		int k = 8;
		for(int i=0;i<arr.length;i++)
		{
			map.put(arr[i], 0);
		}
		
		for(int i=0;i<arr.length;i++)
		{	
			int diff = k - arr[i];
			map.remove(arr[i]);
			if(diff > 0)
			{
				if(map.containsKey(diff))
				{
					System.out.println(arr[i]+"\t"+diff);
				}
			}
		}
		
	}
}