class P7
{
	public static void main(String[] args) 
	{
		String s = "abc";
		
		System.out.println("\nPermutations\n");
		permutations(s);
		
		System.out.println("\nCombinations");
		combinations(s);
	}
	
	public static void combinations(String s)
	{
		combinations("",s);
	}
	
	public static void combinations(String prefix, String s)
	{
		int len = s.length();
		
		System.out.println(prefix);
		for(int i=0;i<len;i++)
			combinations(prefix+s.charAt(i),s.substring(i+1, len));
	}
	
	public static void permutations(String s)
	{
		permutations("", s);
	}
	
	public static void permutations(String prefix, String s)
	{
		int len = s.length();
		if(len == 0)
			System.out.println(prefix);
		
		for(int i=0;i<len;i++)
			permutations(prefix+s.charAt(i), s.substring(0, i)+s.substring(i+1, len));
	}
}