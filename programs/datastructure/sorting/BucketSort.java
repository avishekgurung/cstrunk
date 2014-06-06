class BucketSort
{
	public static void main(String[] args)
	{
		//int arr[] = {10,4,8,0,1,7,5,3,6,2,4};
		int arr[] = {6,200,4};
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println("\n");
		
		bucketSort(arr, 200);
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
	
	public static void bucketSort(int arr[], int maxVal)
	{
		int bucket[] = new int[maxVal + 1];
		for(int i=0;i<bucket.length;i++)
			bucket[i] = 0;
		
		for(int i=0;i<arr.length;i++)
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
 * Space Complexity = O(n);
 */