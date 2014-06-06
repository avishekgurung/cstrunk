import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class P3
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int ch=3;
		while(ch!=0)
		{
			System.out.println("Enter your choice 1.Ascii to Character 2.Character to Ascii");
			ch=Integer.parseInt(bf.readLine());
			switch(ch)
			{
			case 1:
				System.out.println("Enter the ascii value");
				int n=Integer.parseInt(bf.readLine());
				char c=(char)n;
				System.out.println("The equivalent character is: "+c);
				break;
			
			case 2:
				System.out.println("Enter the character");
				int k=bf.read();
				//int n=c;
				System.out.println("The equivalent ascii value is: "+k);
				System.out.println("executed");
				break;
				
			default:
				System.out.println("Wrong choice entered, Bye Bye!!!");
				break;
			
			}
		}
	}
}


output
Enter your choice 1.Ascii to Character 2.Character to Ascii
1
Enter the ascii value
65
The equivalent character is: A
Enter your choice 1.Ascii to Character 2.Character to Ascii
2
Enter the character
A
The equivalent ascii value is: 65
executed