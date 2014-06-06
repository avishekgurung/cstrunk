class RobinKarp
{
	public static void main(String[] args) 
	{
		String text = "avishek gurung";
		String pattern = "gurng";
	
		System.out.println(search(text, pattern));
	}
	
	public static boolean search(String text, String pattern)
	{
		int x = hashFunction(pattern);
		
		String str="";
		int n = text.length();
		int m = pattern.length();
		int p = m;
		
		for(int i=0;i<n-p+1;i++)
		{
			for(int j=i;j<m;j++)
			{
				str = str + text.charAt(j);
			}
			m++;
			
			int y = hashFunction(str);
			if(x == y)
				return true;
			str = "";
		}
		return false;
	}
	
	public static int hashFunction(String str)
	{
		return str.hashCode();
	}
}

//Time Complexity = O(m*n) Space o(1)