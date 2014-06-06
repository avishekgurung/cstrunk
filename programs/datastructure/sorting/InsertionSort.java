class InsertionSort
{
	public static void main(String[] args) 
	{
		int arr[] = {10,4,8,0,1,7,5,3,6,2,4};
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println("\n");
		
		for(int i=1;i<arr.length;i++)
		{
			int key = arr[i];
			int j = i;
			
			while(j> 0 && key < arr[j-1])
			{
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = key;
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