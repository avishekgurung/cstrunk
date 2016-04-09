class P1
{
	public static void main(String[] args) 
	{
		int arr[] = {3,1,2,5,2,4};
		boolean result = false;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[Math.abs(arr[i])] < 0)
			{
				result = true;
				break;
			}
			
			arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
		}
		
		if(result)
			System.out.println("Duplicates present");
		else
			System.out.println("Duplicates NOT present");
	}
	
	//alternative more simpler logic
	public static void searchDuplicates(int arr[]){
		int n = arr.length-1;
		int mathSum = (n*(n+1))/2;
		int sum = 0;
		for(int i=0;i<arr.length;i++){
			sum = sum+arr[i];
		}
		if(sum == mathSum){
			System.out.println("NO Duplicates present");	
		}
		else{
			System.out.println("Duplicates present");
		}
	}
}

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 * 
 * Else instead of minus, u can make the already visited element to be (arr.length+1), since no elements can be higher than array size. 
 * And instead of checking negative no, check if the number is greater than array size. 
 */
