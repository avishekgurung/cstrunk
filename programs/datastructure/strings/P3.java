class P3
{
	public static void main(String[] args) 
	{
		String string2 = "liril";
		String string1 = reverse(string2);
		
		if(string2.length() > string1.length())
		{
			String temp = string1;
			string1 = string2;
			string2 = temp;
		}
		
		System.out.println("Lenght of the longest palindrome is "+longestSubstring(string1, string2));
	}
	
	public static String reverse(String s)
	{
		char arr[] = s.toCharArray();
		String temp = "";
		
		for(int i=arr.length-1;i>=0;i--)
			temp = temp+""+arr[i];
		return temp;
	}
	
	public static int longestSubstring(String string1, String string2)
	{
		int n = string1.length();
		int m = string2.length();
		int maxVal = 0;
		
		int x = 0;
		int y = 0;
		
		char[] s1 = string1.toCharArray();
		char[] s2 = string2.toCharArray();
		
		int arr[][] = new int[n+1][m+1];
		
		for(int i=0;i<=n;i++)
			for(int j=0;j<=m;j++)
				arr[i][j] = 0;
		
		for(int i=1;i<=n;i++) //main part. Others are just simple
		{
			for(int j=1;j<=m;j++)
			{
				if(s1[i-1] == s2[j-1])
				{
					arr[i][j] = arr[i-1][j-1]+1;
				}
				
				if(arr[i][j] > maxVal)
				{
					maxVal = arr[i][j]; //note the co-ordinates where the val is maximun, to use later to print the substring
					x = i;
					y = j;
				}
			}
		}
		
		//Just calculating the initial and final index , in order to print the substring
		int right = x-1;
		
		while(arr[x][y] != 1) //from the maxVal, go back to the co-ordinates where the count first started 
		{
			x--;
			y--;
		}
		int left = x-1;
		
		System.out.println();
		System.out.print("The longest palindrome is ");
		for(int i=left;i<=right;i++)
			System.out.print(s1[i]);
		System.out.println("\n");
		
		return maxVal;
	}
}
//Time Complexity = O(m*n)
//Space Complexity = O(m*n)
//Very smart logic by me: Just reverse the string and find the longest substring