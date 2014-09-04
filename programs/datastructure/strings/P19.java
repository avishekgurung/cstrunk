class P19
{
	public static void main(String[] args) 
	{
		String str = "abcmnodefjklghipqrlkjstu";
		
		for(int i=0;i<=str.length()-3;i++)
		{
			//Creating window
			String window="";
			int x = i;
			for(int j=1;j<=3;j++)
			{
				window = window+str.charAt(x);
				x++;
			}
			
			//reversing window
			window = reverse(window);
			
			//checking
			prefixTable(window);
			if(search(str, window) != -1)
			{
				int y = search(str, window);
				String temp = str.charAt(y)+""+ str.charAt(y+1) +""+ str.charAt(y+2);
				/*for(int j=0;j<3;j++)
					temp = temp+str.charAt(y+j);*/
				System.out.println(temp);
				break;
			}
		}
	}
	
	static int f[];
	
	public static String reverse(String window)
	{
		String temp = "";
		for(int i=0;i<3;i++)
			temp = window.charAt(i)+temp;
		return temp;
	}
	
	public static void prefixTable(String pattern)
	{
		int m = pattern.length();
		f = new int[m];
		int i = 1, j = 0;
		
		while(i<m)
		{
			if(pattern.charAt(i) == pattern.charAt(j))
			{
				f[i] = j + 1;
				j++;
				i++;
			}
			else if(j > 0)
			{
				j = f[j-1];
			}
			else
			{
				f[i] = 0;
				i++;
			}
		}
	}
	
	public static int search(String text, String pattern)
	{
		int i=0,j=0;
		int n = text.length();
		int m = pattern.length();
		
		while(i < n)
		{
			if(text.charAt(i) == pattern.charAt(j))
			{
				if(j == m - 1)
				{
					return i-j;
				}
				else
				{
					i++;
					j++;
				}
			}
			else if(j > 0)
			{
				j = f[j-1];
			}
			else
			{
				i++;
			}
		}
		return -1;
	}
}

/*
 * Iterate the string. Take three words at a time(i.e creating a window of size three). Reverse them. And do a KMP search on the main string.
So to iterate through string, it takes O(n). Reverse will take O(3) which is constant. And KMP search will take O(n). So total time complexity = O(n2)
And space complexity = O(3) for prefix function of KMP. Using suffix tree mite reduce the complexity.

Else another approach would be,
Iterate the string and create window of size 3. Put all the window in Map.
Iterate the string and create window of size 3. Reverse each window and search in map.
Time and Space Complexity = O(n)

 * */
