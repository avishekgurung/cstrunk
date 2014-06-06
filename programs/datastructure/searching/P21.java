class P21
{
	public static void main(String[] args) 
	{
		int arr[] = {1,2,3,4,5,6,11,12,13,14,15,16};
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
		
		divide(arr, 0, arr.length-1);
		
		
	}
	
	public static void divide(int arr[], int left, int right)
	{
		if(left >= right)
			return;
		int mid = (left+right)/2;
		divide(arr, left, mid);
		divide(arr, mid+1, right);
		System.out.println(left+" "+mid+" "+right);
	}
	
	public static void conquer(int arr[])
	{
		
	}
}