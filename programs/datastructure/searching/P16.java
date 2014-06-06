class P16
{
	public static void main(String[] args) 
	{
		int arr[][] = {{1,3,4,5,6},{10,13,14,15,16},{25,26,27,28,29},{43,44,48,49,50},{63,65,66,68,72}};
		System.out.println();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println("\t");
		}
		
		int element = 72;
		
		//main part
		int i = arr.length-1; 
		for(;i>=0;i--)
		{
			if(arr[i][0] < element)
				break;
		}
		
		boolean found = false;
		
		int j = 0;
		for(;j<arr.length;j++)
		{
			if(arr[i][j] == element)
			{
				found = true;
				break;
			}
		}
		
		if(found)
			System.out.println("\nElement found at ["+i+","+j+"]");
		else
			System.out.println("\nElement NOT found");
	}
}