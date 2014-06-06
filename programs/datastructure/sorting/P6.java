import java.util.HashMap;
import java.util.Map;

class P6
{
	public static void main(String[] args) 
	{
		int arr[] = {300,5,1,2,3,6,7,9,7,43,3,4,5,6,8,9,0,2,3,4,5,2,1,2,3,4,5,6,5,4,3,2,1,1,2,6,7,8,9,8,9,8,7,2,8,2,8};
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		
		//we can use heapSort or merge Sort and get the solution
		mergeSort(arr, new int[arr.length], 0, arr.length-1);
		int count = 1, maxCount = 0, element = 0;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i] == arr[i+1])
			{
				count++;
			}
			else
			{
				if(count > maxCount)
				{
					maxCount = count;
					element = arr[i];
				}
				count = 1;
			}
		}
		System.out.println("Element "+element+" appears "+maxCount+" times");
		
		//Time Complexity = O(nlogn)
		//Space Complexity = O(n)
		//we can use heapsort if there is restriction on space
		
		//Find a solution through Hashing
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		int maxVal = 0, val = 0 ;
		element = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				val = map.get(arr[i]);
				val++;
				if(val > maxVal)
				{
					maxVal = val;
					element = arr[i];
				}
				map.put(arr[i], val);
			}
			else
			{
				map.put(arr[i], 1);
			}
		}
		System.out.println("Element "+element+" appears "+maxVal+" times");
		//easy and short
		//Space Complexity = O(n)
		//Time Complexity = O(n)
	}
	
	
	public static void mergeSort(int arr[], int temp[], int left, int right)
	{
		if(left >= right)
			return;
		
		int mid = (left+right)/2;
		mergeSort(arr, temp, left, mid);
		mergeSort(arr, temp, mid+1, right);
		merge(arr, temp, left, mid+1, right);
	}
	
	public static void merge(int arr[], int temp[], int left, int mid, int right)
	{
		int left_end = mid - 1;
		int temp_pos = left;
		int size = (right - left) + 1;
		
		while(left <= left_end && mid <= right)
		{
			if(arr[left] < arr[mid])
			{
				temp[temp_pos] = arr[left];
				temp_pos++;
				left++;
			}
			else
			{
				temp[temp_pos] = arr[mid];
				temp_pos++;
				mid++;
			}
		}
		
		while(left <= left_end)
		{
			temp[temp_pos] = arr[left];
			temp_pos++;
			left++;
		}
		
		while(mid <= right)
		{
			temp[temp_pos] = arr[mid];
			temp_pos++;
			mid++;
		}
		
		for(int i=0;i<size;i++)
		{
			arr[right] = temp[right];
			right--;
		}
	}
}
























