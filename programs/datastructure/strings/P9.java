class P9
{
	public static void main(String[] args) 
	{
		String str = "Ma' am";//"Madam";", I'm Adam!!","Ma'am", "boB"
		System.out.println(str+" is "+checkPalindrome(str));
	
	}
	
	public static boolean checkPalindrome(String str)
	{
		str = str.toLowerCase();
		char letters[] = str.toCharArray();
		String temp = "";
		String rev = "";
		for(int i=0;i<str.length();i++)
		{
			if(letters[i] >=97 && letters[i] <=122)
			{
				temp = temp+letters[i];
				rev = letters[i]+rev;
			}
		}	
		//System.out.println(temp+"\tVs"+str);
		if(temp.equals(rev))
			return true;
		else
			return false;
	}
}