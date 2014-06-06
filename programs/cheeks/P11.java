import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P11
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("");
		int counter=0;
		for(int i=1;i<=1000;i++)
		{
			if(i%2==0 && i%3==0 && i%5==0)
			{
				System.out.print(i+" ");
				counter++;
			}
		}
		System.out.println("\nTotal: "+counter);
	}
}


output
30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540 570 600 630 660 690 720 750 780 810 840 870 900 930 960 990 
Total: 33