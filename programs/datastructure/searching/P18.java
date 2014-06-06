class P18
{
	public static void main(String[] args) 
	{
		//int arr[] = {1,2,1,0,2,0,1,0,0,2,1};
		//int arr[] = {1,0,2,2,0,1,2,0,1,2,1,1,2,0,2,2,1};
		int arr[] = {2,1,0,2,1,2,0,1};
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
		
		int left = 0;
		int right = arr.length-1;
		int mid = left; //if we take mid = (left+right)/2, then it cannot be efficient. Cannot solve arr like {2,1,0,2,1,2,0,1}
		
		while(mid <= right)
		{
			
			switch (arr[mid]) 
			{
			case 0:
				swap(arr, left, mid);
				left++;
				break;
				
			case 1:
				mid++;
				break;

			case 2:
				swap(arr, mid, right);
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