import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P36
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the text");
		//int n=Integer.parseInt(bf.readLine());
		String a=bf.readLine();
		int x1=0,x2=0;
		String result="";
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)==' ')
			{
				x2=i;
				for(int j=x2-1;j>=x1;j--)
				{
					//System.out.print(a.charAt(j));
					result=result+a.charAt(j);
				}
				
				x1=x2+1;
				result=result+" ";
				//System.out.print(" ");
			}
			
			if(i==a.length()-1)
			{
				x2=i;
				for(int j=x2;j>=x1;j--)
				{
					//System.out.print(a.charAt(j));
					result=result+a.charAt(j);
				}
				
				x1=x2+1;
				result=result+" ";
				//System.out.print(" ");
			}
			
		}
		
		System.out.println(result);
		
	}
}


output
Enter the text
The man who sold the world
ehT nam ohw dlos eht dlrow 