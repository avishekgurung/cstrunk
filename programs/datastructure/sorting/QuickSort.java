class QuickSort
{
	public static void main(String[] args) 
	{
		//int arr[] = {5,2,8,9,3,5,1,3};
		int arr[] = {6,3,4,1,2,5};
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
		
		quickSort(arr, 0, arr.length-1);
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
	
	public static void quickSort(int arr[], int left, int right)
	{
		if(left >= right)
			return;
		int pivot = partition(arr,left,right);
		
		quickSort(arr, left, pivot-1);
		quickSort(arr, pivot+1, right);
	}
	
	public static int partition(int arr[], int left, int right)
	{
		int x = left;
		int y = right;
		int pivot = arr[left];
		
		while(x <= y)
		{
			while(arr[x] < pivot)
				x++;
				
			while(arr[y] > pivot)
				y--;

			if(x < y )
			{
				int temp = arr[x];
				arr[x] = arr[y];
				arr[y] = temp;
				x++;
				y--;
			}
		}
		
		arr[left] = arr[y];
		arr[y] = pivot;
		return y;
	}
}

/*
 * Time Complexity(Worst Case) = O(n2)
 * Time Complexity(Best and Average) = O(nlogn)
 * Space Complexity = O(1) 
 */