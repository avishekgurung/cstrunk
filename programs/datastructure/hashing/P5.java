import java.util.HashMap;
import java.util.Map;

class P5
{
	public static void main(String[] args) 
	{
		//lets not take 101 elements as it will be very tidious, find the element which is repeated thrice here
		int arr[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,11,24,25,26,27,28,29,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		int thrice = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				int value = map.get(arr[i]);
				value++;
				map.put(arr[i], value);
				if(value == 3)
					thrice = arr[i];
			}
			else
			{
				map.put(arr[i], 1);
			}
		}
		
		System.out.println("Element Repeating thrice is "+thrice);
		
	}
}