import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class GenerateQuestions{
	public static void main(String[] args) throws IOException{
		
		//Compulsory Questions
		String definite[] = {"Implement Hash Table from scratch","Implement Max Heap or Min Heap from scratch","Implement Selection Sort","Implement Insertion Sort","Implement Merge Sort","Implement Bucket Sort","Implement KMP Algorithm","Implement Trie DS","Implement Preorder with iteration","Implement Inorder with iteration","Implement Postorder with Iteration"}; 
		FileWriter fw = new FileWriter("megaIndex.txt"); //output file
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0;i<definite.length;i++){
			bw.write("*"+(i+1)+". "+definite[i]+"\n");
		}
		
		int range = 139; //give the no of columns of the input file
		int count = 1;
		Set<Integer> set = new HashSet<Integer>();
		int arr[] = new int[range];
		
		while(count != range+1){
			Integer random = (int)(Math.random() * range)+1;
			if(!set.contains(random)){
				set.add(random);
				arr[count-1] = random;
				count++;
			}
		}
		
		//Read file
		FileReader fr = new FileReader("megaList.txt");
		BufferedReader bf = new BufferedReader(fr);
		String str = "";
		int i = 0;
		
		Map<String, String> map = new HashMap<String,String>();
		
		while((str = bf.readLine()) != null){
			int spaceIndex = str.indexOf(' ');
			String val = str.substring(spaceIndex, str.length());
			String key = "P"+arr[i]+".";
			map.put(key, val);
			i++;
		}
		
		for(i=1;i<=range;i++){
			String key = "P"+i+".";
			String val = map.get(key);
			String output = key+" "+val+"\n";
			bw.write(output);
		}
		bw.close();
	}
}
