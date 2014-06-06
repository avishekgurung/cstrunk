class P12
{
	public static void main(String[] args) 
	{
		//String path = "$/home/sorting/../strings/./../heaps/./../nodes";
		String path = "/home/abc/.././def/./ghi/../.";
		String arr[] = path.split("/");
		String temp[] = new String[arr.length];
		
		int j = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].equals(".."))
			{
				j--;
			}
			else if(arr[i].equals("."))
			{
				//do nothing
			}
			else
			{
				temp[j] = arr[i];
				j++;
			}
		}
		
		String absPath = "";
		for(int i=0;i<temp.length;i++)
		{
			if(temp[i] != null)
				absPath = absPath+temp[i]+"/";
		}
		System.out.println("Relative Path: "+path);
		System.out.println("Absolute Path: "+absPath);
	}
}