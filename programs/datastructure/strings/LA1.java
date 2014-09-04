import java.util.Stack;
class LA1{
	public static void main(String args[]){
		String s1 = "AB";
		String s2 = "CD";
		String str = s1+s2;
		permutation(str,s1,s2);
	}

	public static void permutation(String str,String s1, String s2){
		permutation("",str,s1,s2);
	}

	public static void permutation(String prefix,String str, String s1, String s2){
		int l = str.length();
		if(l == 0){
			//System.out.println(prefix);
			Stack<Character> s = new Stack<Character>();
			char arr[] = s1.toCharArray();
			for(int i=0;i<arr.length;i++){
				s.push(arr[i]);
			}

			Stack<Character> t = new Stack<Character>();
			arr = s2.toCharArray();
			for(int i=0;i<arr.length;i++){
				t.push(arr[i]);
			}

			char preArr[] = prefix.toCharArray();
			for(int i=prefix.length()-1;i>=0;i--){
				if(!s.isEmpty() && preArr[i] == s.peek()){
					s.pop();
				}

				if(!t.isEmpty() && preArr[i] == t.peek()){
					t.pop();
				}
			}

			if(s.isEmpty() && t.isEmpty()){
				System.out.println(prefix);
			}

		}

		for(int i=0;i<l;i++){
			permutation(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,l),s1,s2);
		}
	}
}

/*
Would use my naive way to do it. Generate a string = ABCD, i.e by combining two strings. Create a permutation of these strings. Before printing check if the above given condition is true. Put the characters of two strings in
seperate stacks and check the above conditions.
*/
