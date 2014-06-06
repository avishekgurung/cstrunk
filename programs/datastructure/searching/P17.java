class P17
{
	public static void main(String[] args) 
	{
		int arr[][] = {{1,1,0,0},{1,1,1,0},{1,0,0,0},{1,1,1,0}};
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println("\t");
		}
		
		int i = arr.length-1;
		int j = 0;
		int count = 0;
		int maxCount = 0, row = 0;
		
		
		for(;i>=0 && j < arr.length-1;)
		{
			System.out.println(i+" "+j);
			if(arr[j][i] == 0)
			{
				i--;
				count++;
				if(i == 0)
				{
					row = j;
					System.out.println("Row "+j);
				}
			}
			else
			{
				j++;
				if(count > maxCount)
				{
					maxCount = count;
					row = j;
				}
			}
			
			
			
		}
		
		System.out.println("\nRow "+row+" has "+count+" no of zeroes "+i+" "+(j-1));
	}
}