class P6
{
	public static void main(String[] args) 
	{
		//int arr[] = {4,2,0,5,2,3,1};
		int arr[] = {5,9,4,3,7,6,1};
		
		int left = 0, right = arr.length-1;
		//int k = 6;
		int k = 12;
		while(left < right)
		{
			int sum = arr[left] + arr[right];
			if(sum == k)
			{
				System.out.println(arr[left]+" "+arr[right]);
				break;
			}
			else if(k > sum)
			{
				left++;
			}
			else
			{
				right--;
			}	
		}
	}
}

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 * But if we are asked to find all possible pairs then its necessary to sort the array
 
 The above logic will not work. Solution
 1. If the array is sorted follow the above condition.
 2. Else use a map
 
 */
