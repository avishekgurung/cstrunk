class P11
{
	public static void main(String[] args) 
	{
		int arr[] = {9,10,11,12,1,2,3,4,5,6,7,8}; //This is called rotating array
		//int arr[] = {9,1,2,3,4,5,6,7,8};
		int element = 122;
		int pivot = getPivot(arr, 0, arr.length-1); 
		System.out.println("pivot "+pivot);
		System.out.println(binarySearch(arr, pivot, element));
	}
	
	public static boolean binarySearch(int arr[], int pivot, int element)
	{
		int left = 0, right = 0;
		if(element >= arr[0] && element <= arr[pivot]) //check the range where element falls
		{
			left = 0;
			right = pivot;
		}
		else 
		{
			left = pivot + 1;
			right = arr.length-1;
		}
		
		while(left <= right)
		{
			int mid = (left + right)/2;
			if(arr[mid] == element)
				return true;
			if(element > arr[mid])
			{
				left = mid + 1;
			}
			else
			{
				right = right = mid - 1;
			}
		}
		return false;
	}
	
	/*public static int getPivot(int arr[], int left, int right)
	{
		if(right == left + 1) //only two elements are present
		{
			if(arr[left] >= arr[right])
				return left;
			else
				return right;
		}
		
		int mid = (left + right)/2;
		if(arr[left] >= arr[mid])
			return getPivot(arr, left, mid);
		else
			return getPivot(arr, mid, right);
	}*/
	
	public static int getPivot(int arr[])
	{
		int left =  0;
		int right = arr.length-1;
		
		//if its already a sorted array EDGE CONDITIONS
		if(arr[left] < arr[right])
			return arr[right];
		
		while(left <= right)
		{
			int mid = (left+right)/2;
			if(arr[mid] > arr[mid+1])
				return arr[mid];

			if(arr[left] < arr[mid])
				left = mid;
			else
				right = mid;
		}
		return -1;
	}
}
//Time Complexity = O(logn)