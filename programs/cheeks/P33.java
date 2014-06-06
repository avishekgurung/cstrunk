import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P33
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter any three numbers");
		int a=Integer.parseInt(bf.readLine());
		int b=Integer.parseInt(bf.readLine());
		int c=Integer.parseInt(bf.readLine());
		int largest=0;
		if(a>b && a>c)
			largest=a;
		else if(b>a && b>c)
			largest=b;
		else
			largest=c;
		int lcm=0;
		while(true)
		{
			if(largest%a==0 && largest%b==0 && largest%c==0)
			{
					lcm=largest;
					break;
			}
			largest++;
		}
		
		System.out.println("LCM: "+lcm);
	}
}


output
Enter any three numbers
4
8
12
LCM: 24
