class P6
{
	public static void main(String[] args) 
	{
		String s = "abc efg";
		simple(s);
		complex(s);
	}
	
	
	public static void simple(String s)
	{
		String arr[] = s.split(" ");
		String temp = "";
		
		for(int i=0;i<arr.length;i++)
		{
			temp = arr[i]+" "+temp;
		}
		System.out.println(temp);
		//Space complexity O(n)
	}
	
	//With zero space complexity
	public static void reverseSentence(String s)
	{
		char arr[] = s.toCharArray();
		int l = arr.length;
		for(int i = l-1; i >= 0; i--)
		{
			if(arr[i] == ' ')
			{
				int j = i+1;
				while(j != l && arr[j] != ' ')
				{
					System.out.print(arr[j]);
					j++;
				}
				System.out.print(' ');
			}
			
			if(i == 0)
			{
				int j = i;
				while(arr[j] != ' ')
				{
					System.out.print(arr[j]);
					j++;
				}
				System.out.print(' ');
			}
		}
	}
}