import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P6
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of digits");
		int n=Integer.parseInt(bf.readLine());
		int arr[]=new int[n];
		System.out.println("Enter the digits");
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(bf.readLine());
		
		int temp=arr[0];
		for(int i=0;i<n-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				temp=arr[i];
			}
		}
		
		System.out.println("The largest digit: "+temp);
		
	}
}

output
Enter the number of digits
5
Enter the digits
1
5
3
7
5
The largest digit: 7