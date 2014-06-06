import java.util.HashMap;
import java.util.Map;

class Practice
{
	public static void main(String[] args) 
	{
		int arr[]={6,10,10,9,10,5,11,2,10,1,3,10,11,9,8,6,1,7,1,8,7,3,7,9,2,3,6,6,5,4,3,11,10,4,7,2,10,11,8,1};
		int max = 0;
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		int element = arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(!map.containsKey(arr[i]))
			{
				map.put(arr[i], 1);
			}
			else
			{
				int val = map.get(arr[i]);
				val++;
				map.put(arr[i], val);
				if(val > max)
				{
					max = val;
					element = arr[i];
				}
			}
		}
		
		System.out.println(element+" appears "+max+" times");
		
		
	}
}