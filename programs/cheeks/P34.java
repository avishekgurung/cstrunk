import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P34
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter any three numbers");
		int a=Integer.parseInt(bf.readLine());
		int b=Integer.parseInt(bf.readLine());
		int c=Integer.parseInt(bf.readLine());
		int smallest=0;
		if(c<a && c<b)
			smallest=c;
		else if (b<a && b<c)
			smallest=b;
		else
			smallest=a;
			
		int hcf=0;
		
		for(int i=2;i<=smallest;i++)
		{
			if(a%i==0 && b%i==0 && c%i==0)
				hcf=i;
		}
		
		System.out.println("HCF: "+hcf);
	}
}

output
Enter any three numbers
12
16
20
HCF: 4