class P13
{
	static String text;
	static boolean result = false;
	public static void main(String[] args) 
	{
		text = "badfcge";
		String patt = "fcd";
		permutations(patt);
		System.out.println(result);
	}
	
	public static void permutations(String patt)
	{
		permutations("",patt);
	}
	
	public static void permutations(String prefix, String patt)
	{
		int l = patt.length();
		if(l == 0)
		{
			//System.out.println(prefix);
			if(search(text, prefix))
				result = true;
		}
		for(int i=0;i<l;i++)
			permutations(prefix+patt.charAt(i), patt.substring(0, i)+patt.substring(i+1, l));
	}
	
	
	public static boolean search(String text, String pattern)
	{
	
		for(int i=0;i<text.length()-pattern.length();i++)
		{
			int x = i;
			int count = 0;
			for(int j=0;j<pattern.length();j++,x++)
			{
				if(text.charAt(x) == pattern.charAt(j))
					count++;
			}
			if(count == pattern.length())
				return true;
		}
		return false;
	}
}

/*
 * Our approach would be as follows:
 * 1. We will generate all possible permutation of the smaller string
 * 2. For each permutation, we will do a KMP Search or any other search
 * 3. If the substring is present, we return true else return false. 

 	OR (More simpler approach)
 	1. Take the pattern and add all the elements, to get sum s.
 	2. Traverse the text, with a window of length of the pattern. Find the sum for every window.
 	If the both sums are equal, return true.

 	THis is similar to finding an anagram.
 */
