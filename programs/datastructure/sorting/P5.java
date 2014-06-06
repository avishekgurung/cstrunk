class P5
{
	public static void main(String[] args) 
	{
		int arr[] = {2,2,1,2,0,1,2,0,1,1,0,2,1,1,1,2,0,0};
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"   ");
		System.out.println();
		
		bucketSort(arr, 2);
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"   ");
		System.out.println();
	}
	
	public static void bucketSort(int arr[], int maxVal)
	{
		int bucket[] = new int[maxVal + 1];
		
		for(int i=0;i<bucket.length;i++)
			bucket[i] = 0;
		
		for(int i=0; i < arr.length; i++)
			bucket[arr[i]] = bucket[arr[i]] + 1;
		
		int x = 0;
		for(int i=0;i<bucket.length;i++)
		{
			for(int j=0;j<bucket[i];j++)
			{
				arr[x] = i;
				x++;
			}
		}
			
	}
}

/*
 * Time Complexity = O(n)
 * Space complexity = O(k) where k = 3, so its constant
 * */
