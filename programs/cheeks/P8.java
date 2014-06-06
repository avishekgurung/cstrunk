import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P8
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int month=99;
		while(month!=0)
		{
		System.out.println("\n\nEnter the month");
		month=Integer.parseInt(bf.readLine());
		
		int sp=0;
		int dd=0;
		int tt=0;
		String name="";
		switch(month)
		{
			case 1: 
			sp=3;
			dd=31;
			name="JANUARY";
			break;
			
			case 2: 
			sp=1;
			dd=28;
			name="FEBRUARY";
			break;
			
			case 3: 
			sp=5;
			dd=31;
			name="MARCH";
			break;
			
			case 4: 
			sp=6;
			dd=30;
			name="APRIL";
			break;
			
			case 5: 
			sp=0;
			dd=31;
			name="JUNE";
			break;
			
			default:
			System.exit(0);
		}
		
		
		System.out.println("\nMonth: "+name);
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		for(int i=1;i<=sp;i++,tt++)
			System.out.print("\t");
		
		for(int i=1;i<=dd;i++,tt++)
		{
			if(tt%7==0)
				System.out.println("");
			System.out.print(i+"\t");
		}
		}
	}
}

output
Enter the month
2

Month: FEBRUARY
Sun	Mon	Tue	Wed	Thu	Fri	Sat
	1	2	3	4	5	6	
7	8	9	10	11	12	13	
14	15	16	17	18	19	20	
21	22	23	24	25	26	27	
28