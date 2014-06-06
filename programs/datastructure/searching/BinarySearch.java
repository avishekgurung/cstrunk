class BinarySearch
{
	public static void main(String[] args) 
	{
		int arr[] = {1,2,3,4,5,6,7,8,9};
		int element = 19;
		
		if(binarySearch(arr, element))
			System.out.println("Element found");
		else
			System.out.println("element NOT found");
	}
	
	public static boolean binarySearch(int arr[], int element)
	{
		int left = 0, right = arr.length-1;
		
		while(left <=  right)
		{
			int mid = (left + right)/2;
			if(arr[mid] == element)
				return true;
			else if(element > arr[mid])
				left = mid+1;
			else
				right = mid-1;
		}
		return false;
	}
}

/* 
 * Time complexity = O(logn)
 * Space Complexity = O(1)
 * But we need a sorted data for Binary Searchx 
 */