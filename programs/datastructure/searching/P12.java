class P12
{
	public static void main(String[] args) 
	{
		int arr[] = {1,3,3,3,3,4,5,6};
		//int arr[] = {3,3,3,3,3,3,4,5,6,6,7};
		int element = 3;
		
		System.out.println("First Index of "+element+" is "+getFirstOccurrence(arr, element));
		System.out.println("Last Index of "+element+" is "+getLastOccurrence(arr, element));
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
			else if(element >= arr[mid])
				left = mid + 1;
			else
				right = mid -1;
		}
		return -1;
	}
}











