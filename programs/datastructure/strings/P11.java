class P11
{
	public static void main(String[] args) 
	{
		String s = "12345678910111213141516171819202122232425";
		String f = "20";
		System.out.println(search(s, f));
	}
	
	public static int search(String text, String pattern)
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
				return i;
		}
		return -1;
	}
}