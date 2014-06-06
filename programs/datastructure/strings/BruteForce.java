class BruteForce
{
	public static void main(String[] args) 
	{
		String text = "avishek gurung";
		String pattern = "avishek";
		System.out.println(search(text, pattern));
	}
	
	/*public static boolean search(String text, String pattern)
	{
		int count = 0;
		for(int i=0;i<text.length();i++)
		{
			int j = 0;
			while(j < pattern.length() && i < text.length() && text.charAt(i) == pattern.charAt(j))
			{
				i++;
				j++;
			}
			if(j == pattern.length())
				return true;
		}
		return false;
	}*/
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

//Time Complexity = O(n*m) Space Complexity = O(1)