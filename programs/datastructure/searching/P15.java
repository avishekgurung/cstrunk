class P15
{
	public static void main(String[] args) 
	{
		//int arr[] = {3,2,10,2,2,5,2,2}; //Since one element repeats more than n times, so there can be only two arrangements possible. Either the repeating element will appear alternatively else atleast two repeating elements will lay side by side
		int arr[] = {3,2,10,2,5,2,1,2};
		int repeatElement = 0;
		
		for(int i=0;i<arr.length-1;i++)
			if(arr[i] == arr[i+2])
			{
				repeatElement = arr[i];
				break;
			}
		
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i] == arr[i+1])
			{
				repeatElement = arr[i];
				break;
			}
		}
		System.out.println("Repeating ELement: "+repeatElement);
	}
}