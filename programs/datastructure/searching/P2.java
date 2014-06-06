class P2
{
	public static void main(String[] args) 
	{
		int arr[] = {3,2,5,4,3,1,3,3};
		int n = arr.length;
		
		for(int i=0;i<arr.length;i++)
		{
			int x = arr[i]%n;
			arr[x] = arr[x]+n;
		}
		
		int maxVal = 0;
		int element = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] > maxVal)
			{
				maxVal = arr[i];
				element = i;
			}
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"  ");
		System.out.println();
		
		///System.out.println(maxVal);
		
		int repeat = maxVal / n;
		
		System.out.println("Element "+element+" appears "+repeat+" no of times");
		
	}
}

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */