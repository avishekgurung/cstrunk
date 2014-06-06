class BubbleSort
{
	public static void main(String[] args) {
		int arr[] = {10,4,8,0,1,7,5,3,6,2,4};
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println("\n");
		
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
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
