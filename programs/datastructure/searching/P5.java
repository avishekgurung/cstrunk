class P5
{
	public static void main(String[] args) 
	{
		int arr[] = {4,2,4,5,2,3,1};
		int n = 5; //Should be given to us according to the question
		
		bucketSort(arr, n);
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i] == arr[i+1])
				System.out.println(arr[i]);
		}
	}
	
	public static void bucketSort(int arr[], int maxVal)
	{
		int bucket[] = new int[maxVal+1];
		
		for(int i=0;i<bucket.length;i++)
			bucket[i] = 0;
		
		for(int i=0;i<arr.length;i++)
			bucket[arr[i]] = bucket[arr[i]] + 1;
		
		int x = 0;
		for(int i=0;i<bucket.length;i++)
		{
			for(int j=0;j<bucket[i];j++)
			{
				arr[x] = i;
				x++;
			}
		}	
	}

	//without sorting
	public static void alternateSol(int arr[]){
		int arr[] = {4,2,5,1,4,3,2};
		for(int i=0;i<arr.length;i++){
			int index = Math.abs(arr[i]);
			int val = arr[index];
			if(val < 0){
				System.out.println(index);
			}
			else{
				arr[index] = -arr[index];
			}
		}
	}
}
