import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P22
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the lower limit");
		int l=Integer.parseInt(bf.readLine());
		System.out.println("Enter the upper limit");
		int u=Integer.parseInt(bf.readLine());
		int count=0;
		for(int i=l;i<=u;i++)
		{
			boolean flag=true;
			for(int j=2;j<i/2;j++)
			{
				if(i%j==0)
					flag=false;
			}
			if(flag==true)
			{
				System.out.print(i+"  ");
				count++;
			}
		}
		System.out.println("\nTotal: "+count);
	}
}

output
Enter the lower limit
50
Enter the upper limit
100
53  59  61  67  71  73  79  83  89  97  
Total: 10