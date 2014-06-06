class P8
{
	public static void main(String[] args) 
	{
		String a = "briabaxmnaxzreo";
		String b = "zax";
		checkIfAnagram(a, b);
	}
	
	static String arr[];
	static int index = 0;
	public static void checkIfAnagram(String a, String b)
	{
		arr = new String[factorial(b)];
		permutations(b);
		
		for(int i=0;i<index;i++)
		{
			int x = KMP(a, arr[i]);
			if(x != -1)
			{
				System.out.println("\n"+b+" found at position "+x+" in "+a);
			}
		}
	}
	
	public static int factorial(String s)
	{
		int l = s.length();
		int result = 1;
		for(int i = 1; i <= l; i++)
			result = result * i;
		return result;
	}
	
	public static void permutations(String s)
	{
		permutations("",s);
	}
	
	public static void permutations(String prefix, String s)
	{
		int len = s.length();
		if(len == 0)
		{
			arr[index] = prefix;
			index++;
		}
		
		for(int i=0;i<len;i++)
			permutations(prefix+s.charAt(i), s.substring(0, i)+s.substring(i+1, len));
	}
	
	public static int KMP(String s, String p)
	{
		char[] patt = p.toCharArray();
		int m = p.length();
		int f[] = new int[m];
		int i = 1;
		int j = 0;
		
		while(i < m)
		{
			if(patt[i] == patt[j])
			{
				f[i] = j + 1;
				i++;
				j++;
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
		
		int result = KMPSearch(s, p, f);
		return result;
	}
	
	public static int KMPSearch(String s, String p, int f[])
	{
		char[] text = s.toCharArray();
		char[] patt = p.toCharArray();
		int n = s.length();
		int m = p.length();
		int i = 0;
		int j = 0;
		
		while(i < n)
		{
			if(text[i] == patt[j])
			{
				if(j == m-1)
					return i-j;
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
		return -1;
	}
}