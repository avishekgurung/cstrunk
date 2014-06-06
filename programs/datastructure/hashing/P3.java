import java.util.Map;
import java.util.HashMap;
class P3
{
	public static void main(String[] args) {
		int arr[][]={{1,3},{2,6},{3,5},{7,4},{5,3},{8,7},{4,7}};
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		//Just inserting into map in naive way
		for(int i=0;i<arr.length;i++)
		{
			boolean flag = true;
			int a=0,b=0;
			for(int j=0;j<arr[i].length;j++)
			{
				if(flag)
					a = arr[i][j];
				else
					b = arr[i][j];
				flag = false;
			}
			map.put(a, b);
		}
		
		//main operation
		for(int i=0;i<arr.length;i++)
		{
			int x = map.get(arr[i][0]);
			if(map.containsKey(x))
			{
				int y = map.get(x);
				if(y == arr[i][0])
				{
					System.out.println("{"+arr[i][0]+","+x+"}");
				}
			}
		}
	}
}

/*
 *Algo is pretty simple
 *we insert all the elements of the array in a map, such that, the first element of a pair is the key and the second is the value
 *x will get the value of an element
 *if x is present as key too
 *then y will be the value of x
 *Now if y is same as element, we print 
 */