class P5
{
	public static void main(String[] args) 
	{
		String s = "avishek";
		System.out.println(reverseEditable(s));
		System.out.println(reverseUneditable(s));
	}
	
	public static char[] reverseEditable(String s)
	{
		int l = s.length()-1;
		int i=0;
		char arr[] = s.toCharArray();
		System.out.println(arr);
		while(i < l/2)
		{
			char temp = arr[i];
			arr[i] = arr[l-i];
			arr[l-i] = temp;
			i++;
		}
		return arr;
	}
	
	public static String reverseUneditable(String s)
	{
		String temp = "";
		for(int i=0;i<s.length();i++)
			temp = s.charAt(i)+""+temp;
		return temp;
	}
}