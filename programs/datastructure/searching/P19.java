class P19
{
	public static void main(String[] args) 
	{
		int arr[] = {1,0,1,1,0,0,0,1,1,0};
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
		
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right)
		{
			switch (arr[left]) 
			{
			case 0:
				left++;
				break;

			case 1:
				swap(arr, left, right);
				right--;
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