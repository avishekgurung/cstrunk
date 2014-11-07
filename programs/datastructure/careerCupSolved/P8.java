import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class P8{
	public static void main(String args[])  throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String sentence = "";
		System.out.print("Enter the String: ");
		sentence = bf.readLine();
		//utility(sentence);
		raw(sentence);
	}

	public static void utility(String sentence){
		String arr[] = sentence.split(" ");
		for(int i=0;i<arr.length;i++){
			String temp = reverse(arr[i]);
			System.out.print(temp+" ");
		}
		System.out.println();
	}

	public static String reverse(String str){
		String temp = "";
		for(int i=0;i<str.length();i++){
			temp = str.charAt(i)+""+temp;
		}
		return temp;
	}

	public static void raw(String sentence){
		String temp = "";
		String output = "";
		for(int i=0;i<sentence.length();i++){
			if(sentence.charAt(i) == ' ' || i == sentence.length()-1){
				temp = reverse(temp);
				if(i == sentence.length()-1){
					temp = sentence.charAt(i)+""+temp;
				}
				output = output+" "+temp;
				temp="";
			}
			else{
				temp = temp+""+sentence.charAt(i);
			}
		}
		System.out.println(output);
	}
}
