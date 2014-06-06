class KMP
{
	static int f[];
	public static void main(String[] args) 
	{
		String text = "BACBABABABACACA";
		String pattern = "ABABACA";
		
		prefixTable(pattern);
		System.out.println(search(text, pattern));
		/*System.out.println(pattern);
		for(int i=0;i<f.length;i++)
			System.out.print(f[i]+" ");*/
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
}