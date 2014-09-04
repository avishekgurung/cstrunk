class P16
{
	public static void main(String[] args) 
	{
		int arr[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int element = 17;

		int row = 0;

		for(int i=0; i< arr.length;i++){
			if(element >= arr[i][0] && element <= arr[i][arr.length-1]){
				row = i;
				break;
			}
		}

		for(int j=0;j<arr.length;j++){
			if(arr[row][j] == element){
				System.out.println("Found at "+row+","+j);
				break;
			}
		}
	}
}

/*
Search in which row it lies.
Then search that row.
*/