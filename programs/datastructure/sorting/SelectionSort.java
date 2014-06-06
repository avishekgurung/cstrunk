class SelectionSort
{
	public static void main(String[] args) 
	{
		int arr[] = {10,4,8,0,1,7,5,3,6,2,4};
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println("\n");
		
		for(int i=0;i<arr.length-1;i++)
		{
			int min = arr[i];
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[min] > arr[j])
					min = j;
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
}

/*
 * Time Complexity = O(n2)
 * Space Complexity = O(1) 
 */
 
