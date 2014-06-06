import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P5
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter any String");
		String s=bf.readLine();
		int l=s.length();
		int arr[]=new int[l];
		for(int i=0;i<l;i++)
		{
			int x=s.charAt(i);
			arr[i]=x;
		}
		 
		System.out.println("\nSorted letters");
		for(int i=0;i<l-1;i++)
		{
			for(int j=i+1;j<l;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		for(int i=0;i<l;i++)
		{
			System.out.print (" "+(char)arr[i]);
		}
	}
}


output
Enter any String
avishek

Sorted letters
 a e h i k s v