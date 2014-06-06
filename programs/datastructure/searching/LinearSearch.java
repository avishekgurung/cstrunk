class LinearSearch
{
	public static void main(String[] args) 
	{
		int arr[] = {4,2,4,6,9,2,2,4,5,7,3,9};
		int element = 15;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] == element)
			{
				System.out.println("Element found");
				return;
			}
		}
		System.out.println("Element NOT found");
	}
}
/**
 * Time complexity = O(n)
 * Space Complexity = O(1)
 */