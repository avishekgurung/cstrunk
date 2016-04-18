class MergeSort
{
	public static void main(String[] args) 
	{
		int arr[] = {10,4,8,0,1,7,5,3,6,2,4};
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println("\n");

		int[] temp = new int[arr.length];
		mergeSort(arr, temp, 0, arr.length-1);
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
	
	public static void mergeSort(int[] arr, int[] temp, int left, int right)
	{
		if(left >= right)
			return;
		int mid = (left + right)/2;
		mergeSort(arr, temp, left, mid);
		mergeSort(arr, temp,  mid+1, right);
		merge(arr, temp, left, mid+1, right);
	}
	
	public static void merge(int[] arr, int[] temp, int left, int mid,int right)
	{
		int left_end = mid-1;
		int temp_pos = left;
		int size = right - left + 1;
		
		while(left <= left_end && mid <= right)
		{
			if(arr[left] < arr[mid])
			{
				temp[temp_pos] = arr[left];
				left++;
				temp_pos++;
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
			left++;
			temp_pos++;
		}
		
		while(mid <= right)
		{
			temp[temp_pos] = arr[mid];
			mid++;
			temp_pos++;
		}
		
		for(int i=0;i<size;i++)
		{
			arr[right] = temp[right];
			right--;
		}
	}
}
/*
 * Time Complexity = O(nlogn)
 * Space Complexity = O(n)
 */
