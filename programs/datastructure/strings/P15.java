class P15
{
	public static void main(String[] args) 
	{
		String pattern = "shel";
		prefixTable(pattern);
		
		char[] stream = {'a','v','i','s','h','e','k','g','u','r','u','n','g','\0'};
		
		System.out.println(search(stream, pattern));
	}
	
	//Here we have some constraints, we cannot find the length of the stream, we do not know the next character in the stream, we get only one character in the stream
	//The end of the stream is represented by null character
	public static boolean search(char[] stream, String pattern)
	{
		int i = 0;
		int j = 0;
		int m = pattern.length();
		char[] patt = pattern.toCharArray();
		while(stream[i] != '\0')
		{
			if(stream[i] == patt[j])
			{
				if(j == m -1)
					return true;
				i++;
				j++;
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
		return false;
	}
	
	public static int f[];
	
	public static void prefixTable(String pattern)
	{
		int n = pattern.length();
		char patt[] = pattern.toCharArray();
		int i = 1, j = 0;
		f = new int[n];
		f[0] = 0;
		
		while(i<n)	
		{
			if(patt[i] == patt[j])
			{
				f[i] = j + 1;
				i++;
				j++;
			}
			else if(j > 0)
			{
				j = f[j] - 1;
			}
			else
			{
				f[i] = 0;
				i++;
			}
		}
	}
}
//simple solving by Knuth Morris and Pratt Algorithm
