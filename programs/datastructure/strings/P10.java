class P10
{
	//let us suppose that our dictionary is 1D array as follows, we assume that dictionary has millions of word
	static String dict[] = {"accuse","adamant","air","ant","bad","ball","bet","bird","but","came","camel","ceiling","cut","damp","dump","ear","fan","faint","funny","fur"};
	
	public static void main(String[] args) 
	{
		String word = "bad";
		System.out.println();
		System.out.println(word+" appears at position "+	utilityWithLength(word)+" in the dictionary");
		System.out.println(word+" appears at position "+	utilityWithoutLength(word)+" in the dictionary");
	}
	
	public static String getWord(int index)
	{
		return dict[index];
	}
	
	
	public static int utilityWithLength(String word)
	{
		int len = dict.length;
		int left = 0;
		int right = dict.length-1;
		
		while(left <= right)
		{
			int mid = (left+right+1)/2;//System.out.println(mid);
			String midWord = getWord(mid);
			if(midWord.equals(word))
				return mid;
			int x = compareWords(word, midWord);
			if(x == 1)
				right = mid-1;
			else 
				left = mid+1;
		}
		return -1;
	}

	public static int utilityWithoutLength(String word) //Gallop search
	{
		if(word.equals(dict[0]))
			return 0;
		
		int i = 1;
		while(compareWords(dict[i], word) != 0)
		{
			i = i * 2;
		}
		
		while(!dict[i].equals(word))
			i--;
		return i;
	}
	
	public static int compareWords(String a, String b) //if s comes before t then return 1 else return 0
	{
		if(a.equals(b))
			return 0 ;
		char[] s = a.toCharArray();
		char[] t = b.toCharArray();

		for(int i=0;;i++){
			if(s[i] < t[i])
				return 1;
			else if(s[i] > t[i])
				return -1;
			if(i== s.length-1)
				return 1;
			if(i == t.length-1)
				return -1;
		}
	}
}

/*No complex logic or rocket science involved here.
 * We simply search for a middle element (incase of BS) and then compare if out given word lies before or after the word in that middle element.
 * For gallop search too, we simply search elements based on iteration.
 * Both cases use O(logn) time. Not considering compare function 
 */

