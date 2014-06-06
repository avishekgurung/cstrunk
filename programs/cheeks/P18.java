import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P18
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter any number of your choice");
		int n=Integer.parseInt(bf.readLine());
		int zero=0,one=0,two=0,three=0,four=0,five=0,six=0,seven=0,eight=0,nine=0;
		for(int i=1;i<=n;i++)
		{
			int x=i;
			while(x!=0)
			{
				int rem=x%10;
				x=x/10;
				switch(rem)
				{
					case 0: zero++;break;
					case 1: one++;break;
					case 2: two++;break;
					case 3: three++;break;
					case 4: four++;break;
					case 5: five++;break;
					case 6: six++;break;
					case 7: seven++;break;
					case 8: eight++;break;
					case 9: nine++;break;
				}
			}
		}
			System.out.println("0 occurs "+zero+" times");
			System.out.println("1 occurs "+one+" times");
			System.out.println("2 occurs "+two+" times");
			System.out.println("3 occurs "+three+" times");
			System.out.println("4 occurs "+four+" times");
			System.out.println("5 occurs "+five+" times");
			System.out.println("6 occurs "+six+" times");
			System.out.println("7 occurs "+seven+" times");
			System.out.println("8 occurs "+eight+" times");
			System.out.println("9 occurs "+nine+" times");
	}
}
output
Enter any number of your choice
15
0 occurs 1 times
1 occurs 8 times
2 occurs 2 times
3 occurs 2 times
4 occurs 2 times
5 occurs 2 times
6 occurs 1 times
7 occurs 1 times
8 occurs 1 times
9 occurs 1 times
