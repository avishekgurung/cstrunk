import java.util.HashMap;
import java.util.Map;

class P16
{
	public static void main(String[] args) 
	{
		String text = "AAAABBBCXYZEEEEPPPPPKKABC";
		char[] arr = text.toCharArray();
		System.out.println(arr);
		int l = arr.length;
		
		int x = 0;
		int count = 1;
		for(int i=0;i<l-1;i++)
		{
			if(arr[i] == arr[i+1])
			{
				count++;
			}
			else
			{
				if(count > 1)
				{
					arr[x] = arr[i];
					x++;
					arr[x] = (char)('0'+count); //simply converting count to character
					x++;
				}
				else
				{
					arr[x] = arr[i];
					x++;
				}
				count = 1;
			}
			
			if(i == l-2)
			{
				while(x != l)
				{
					arr[x] = '\0';
					x++;
				}
			}
		}
		System.out.println(arr);
	}
}

/*
The solution is manageable. It might not be very very accurate because of the text is like "AAAAAAAAAAAAAAAAA" then, the iteration will be doing twice.
Therefore, time complexity = O(n2) 
*/


