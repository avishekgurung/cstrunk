import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P37
{
	public static void main(String args[]) throws IOException
	{
		int a[]=new int[]{1,2,4,3,6,4,3,5,1,2,7,5,2,8,9,2,3,5,8,4,4,1,7,4,5,6,2,9,8,7,9,9,0,0,0};
		int b[]=a;
		
		for(int i=0;i<b.length-1;i++)
		{
			for(int j=i+1;j<b.length;j++)
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		for(int x:b)
			System.out.print(x+" ");
		int count=0;
		
		for(int i=0;i<b.length-1;i++)
		{
			if(a[i]!=a[i+1])
				count++;
		}
		System.out.println("\nCount: "+count);
		int l=count+1;
		int c[]=new int[l];
		int j=0;
		for(int i=0;i<b.length-1;i++)
		{
			if(a[i]!=a[i+1])
			{
				c[j]=a[i];
				j++;
			}
			if(i==b.length-2)
			{
				c[j]=b[b.length-1];
			}
		}
		System.out.println();
		for(int x:c)
			System.out.print(x+"\t");
		
	}
}

output
0 0 0 1 1 1 2 2 2 2 2 3 3 3 4 4 4 4 4 5 5 5 5 6 6 7 7 7 8 8 8 9 9 9 9 
Count: 9

0	1	2	3	4	5	6	7	8	9