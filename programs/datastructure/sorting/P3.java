class P3
{
	public static void main(String[] args) 
	{
		int arr[] = {5,2,3,4,1,2,3,4,2,2,1,3,1,2,3,5,5,2,1,2,3,4,1,2,1,4,3,2,1,2,1,2,3,4,5,5,5,5,5,3,1,3,4,5,5,2,3,3,3,4,1,2,1,2,5,4,2,3,2};
		bucketSort(arr, 5);
		
		int element = 0, count = 1, maxCount = 0;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i] == arr[i+1])
			{
				count++;
			}
			else
			{
				if(count > maxCount)
				{
					maxCount = count;
					element = arr[i];
				}
				count = 1;
			}
		}
		
		System.out.println("The election is won by candidate "+element+" with max vote of "+maxCount);
	}
	
	public static void bucketSort(int arr[], int maxVal)
	{
		int bucket[] = new int [maxVal + 1];
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
 * The question clearly states that the array will contain only elements in the range 1 to 5. 
 * The problem can be solved efficiently by using Hashing or Bucket Sort.
 * But we choose Bucket SOrt over Hashing. Because, hashing takes Space = O(n) and time = O(n)
 * But bucket takes time of O(n) and space = O(k). Where k is the number of candidates. 
 * And since in a voting system, the number of votes will always be far higher than the number of elected candidates hence k << n
 * So bucket sort is the efficient one.
 */
 
