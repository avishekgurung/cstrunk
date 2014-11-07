import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

class P1{
	public static void main(String args[]) throws FileNotFoundException, IOException{
		File file = new File("input_P1.txt");

		if(!file.exists()){
			System.out.println("File does not exists");
			return;	
		}
		String line = "";
		int count = 0;
		Map<String,String> map = new HashMap<String,String>();
		BufferedReader bf = new BufferedReader(new FileReader(file));
		while(( line = bf.readLine()) != null){
			String arr[] = line.split(" ");
			for(int i=0;i<arr.length;i++){
				String val = arr[i];
				String key = sorted(val);
				if(!map.containsKey(key)){
					map.put(key,val+"XQZT");
				}
				else{
					String temp = map.get(key);
					if(temp.indexOf("XQZT") != -1){
						System.out.println(temp.replace("XQZT",""));
					}
					else{
						map.put(key,val);
					}
					System.out.println(val);
				}
			}
		}
	}


	public static String sorted(String str){
		char arr[] = str.toCharArray();
		for(int i = 0; i < arr.length-1; i++){
			for(int j=i+1; j < arr.length; j++){
				if(arr[i] > arr[j]){
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		String result = new String(arr);
		return result;
	}
}

/*

Explanation:
I tried to implement as efficient method as possible where we iterate file only once 
And iterate map only once.

First we to see if the two strings are anagram, we must remember that if we sort the two strings
and if they are same then we can say that these strings are anagrams.

Now going to main logic.

1. We read the line one at a time from file and split it into Strings.
2. We sort the Strings. The real string is used as value and the sorted string as key
3. if the key appears, first time in the map then we appen XQZT in the val and push them in map
4. if the key already appears (This means that the conditon for anagram is satisfied)
	if the value has XQZT then we print the value after removing XQZT and also print the current string
	Else we print the current string and replace the value by the current String

*/