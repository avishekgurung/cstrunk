class P13
{
	public static void main(String[] args) 
	{
		int arr[] = {1,3,3,3,3,3,4,5,6,6,7};
		int element = 7;
		
		int first = getFirstOccurrence(arr, element);
		int last = getLastOccurrence(arr, element);
		
		System.out.println(first);
		System.out.println(last);
		
		int result = 0;
		if(first == last) // when the element occurs only 1 time
			result = 1;
		else
			result = last - first;
		
		System.out.println("Number of occurrences of "+element+" is "+result+" times");
		
	}
	
	public static int getFirstOccurrence(int arr[], int element)
	{
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right)
		{
			int mid = (left + right)/2;
			if(mid == left && arr[mid] == element || arr[mid] == element && arr[mid-1] < element)
				return mid;
			else if(element > arr[mid])
				left = mid + 1;
			else
				right = mid -1;
		}
		return -1;
	}
	
	public static int getLastOccurrence(int arr[], int element)
	{
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right)
		{
			int mid = (left + right)/2;
			if(mid == right && arr[mid] == element || arr[mid] == element && arr[mid+1] > element)
				return mid;
			else if(element > arr[mid])
				left = mid + 1;
			else
				right = mid -1;
		}
		return -1;
	}
}









