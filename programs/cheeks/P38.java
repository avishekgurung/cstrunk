import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P38
{
	public static void main(String args[]) throws IOException
	{
		int a[]=new int[]{1,3,5,2,3,0,8,0,5,3,4,5,1,2,8,5,4,6,9,0,3,4,5,6};
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		for(int x:a)
			System.out.print(x+" ");
		System.out.println();
		
		int count;
		for(int i=0;i<a.length;i++)
		{
			count=0;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]==a[j])
					count++;
			}
			i=i+count;
			System.out.println(a[i]+" occurs "+(count+1)+" times");
		}
		
	}
}

output
0 0 0 1 1 2 2 3 3 3 3 4 4 4 5 5 5 5 5 6 6 8 8 9 
0 occurs 3 times
1 occurs 2 times
2 occurs 2 times
3 occurs 4 times
4 occurs 3 times
5 occurs 5 times
6 occurs 2 times
8 occurs 2 times
9 occurs 1 times
