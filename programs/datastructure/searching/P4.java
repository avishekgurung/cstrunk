/*
 * Lets understand the question first
 * The elements are in the range 1 to n, lets say n=5. So all the elements will be in the range 1 to 5
 * Now the array of size n-1 i.e 4, So array can accomodate only 4 elements which are all non repeated.
 * So this array will always have one missing number. We need to find that missing number
 */

class P4
{
	public static void main(String[] args) 
	{
		//int arr[] = {4,2,5,1};
		int arr[] = {3,1,4,2};
		
		int n = 5; //n from the range 1 to n, which should be given to us
		int sum = (n*(n+1))/2; //Finding the sum of n natural number
		
		int arrSum=0;
		for(int i=0;i<arr.length;i++)
			arrSum = arrSum + arr[i];
		
		int missing_number = sum - arrSum;
		
		System.out.println("Missing Number "+missing_number);
		
		System.out.println(3^7);
	}
}
/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */