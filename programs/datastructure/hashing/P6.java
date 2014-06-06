import java.util.HashMap;
import java.util.Map;

class P6
{
	public static void main(String[] args) 
	{
		int arr[]={6,10,10,9,10,5,11,2,10,1,3,10,11,9,8,6,1,7,1,8,7,3,7,9,2,3,6,6,5,4,3,11,10,4,7,2,10,11,8,1};
		int maxVal=0;
		int maxKey=0;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				int value = map.get(arr[i]);
				value++;
				if(value > maxVal)
				{
					maxVal = value;
					maxKey = arr[i];
				}
				map.put(arr[i], value);
			}
			else
			{
				map.put(arr[i], 0);
			}
		}
		
		System.out.println(maxKey+" appears "+maxVal+" times");
	}
}