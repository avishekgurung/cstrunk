class LA2{
	public static void main(String args[]){
		String map = "a=1,b=2,c=1"; //Say this is our map
		String patt = mapManupulation(map);
		String text = "kjabcbabbc";
		System.out.println("Pattern: "+patt);
		System.out.println("Text: "+text);
		System.out.println(search(text,patt));
	}

	public static boolean search(String text, String patt){
		char t[] = text.toCharArray();
		char p[] = patt.toCharArray();

		int n = t.length;
		int m = p.length;

		for(int i=0;i<=n-m;i++){
			String window = "";
			for(int j=i;j<i+m;j++){
				window = window + t[j];
			}
			if(window.equals(patt)){
				return true;
			}
		}
		return false;
	}
	public static String mapManupulation(String str){
		String s[] = str.split(",");
		String res = "";
		for(int i=0;i<s.length;i++){		
			String key = s[i].split("=")[0];
			int val = Integer.parseInt(s[i].split("=")[1]);
			for(int j=0;j<val;j++)
				res = res + key;
		}
		return res;
	}
}