class P17
{
	public static void main(String[] args) 
	{
		int arr[][] = {{1,1,0,0},{1,1,1,0},{1,0,0,0},{1,1,1,0}};
		
		int count 		= 0;
		int maxCount 	= 0;

		int i = arr.length-1;
		int j = arr.length-1;
		int row = 0;

		while(i >= 0){
			if(arr[i][j] == 0){
				count++;
				j--;
			}
			else{
				if(count > maxCount){
					maxCount = count;
					row = i;
				}
				i--;
			}	
		}
		
		System.out.println("Row with max 0s "+row);
	}
}

// Take the last element of the array, and start going backward in every row when 0 is encountered.
//