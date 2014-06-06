class P20
{
	public static void main(String[] args) 
	{
		int arr[] = {12,34,90,8,9,45,3};
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
		
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right)
		{
			int rem = arr[left]%2;
			
			switch (rem) 
			{
			case 1:
				swap(arr, left, right);
				right--;
				break;
			
			case 0:
				left++;
				break;
			}
		}
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
	
	public static void swap(int arr[], int x, int y)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}