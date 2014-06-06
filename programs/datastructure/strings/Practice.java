import java.util.HashMap;
import java.util.Map;

class Practice
{
	public static void main(String[] args) 
	{
		//System.out.println(getWord(2));
		//System.out.println(compareWords("avi", "avishek"));
		String word = "bad";
		System.out.println(word+" appears at position "+	utilityWithLength(word)+" in the dictionary");
		System.out.println(word+" appears at position "+	utilityWithoutLength(word)+" in the dictionary");
		//String str = "Madam, I'm Adam!!";
		//advancePalindrome(str);
		/*String a = "briabaxmnaxzreo";
		String b = "zax";
		checkIfAnagram(a, b);*/
		//permutations(s);
		//reverseSentence(s);
		
		//System.out.println(search(s, p));
		//System.out.println(KMP(s, p));

		/*String sa[] = {"avi","amit","avinash","avishek","abram","amitabh","aron","abraham"};
		Trie trie = new Trie();
		
		for(int i=0;i<sa.length;i++)
			trie.insert(sa[i]);
		
		trie.display(trie.node, 0, new char[50]);
		System.out.println("\nSearch "+trie.search("avisheks"));
		System.out.println("\nAuto Complete");
		
		trie.autocomplete("ab");*/
		//System.out.println(longesSubstring(s, p));
		//System.out.println(editableReverse(s));
		//editableReverse(s);
	}
	
	static String dict[] = {"accuse","adamant","air","ant","bad","ball","bet","bird","but","came","camel","ceiling","cut","damp","dump","ear","fan","faint","funny","fur"};
	public static String getWord(int index)
	{
		return dict[index];
	}
	
	public static int utilityWithoutLength(String word) //Gallop search
	{
		int i = 1;
		while(compareWords(dict[i], word) != 0)
		{
			i = i * 2;
		}
		
		while(!dict[i].equals(word))
			i--;
		return i;
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
	
	public static int compareWords(String s, String t) //if s comes before t then return 1 else return 0
	{
		char a[] = new char[s.length()+1];
		char b[] = new char[t.length()+1];
		
		int i = 0;
		for(i=0;i<s.length();i++)
			a[i] = s.charAt(i);
		a[i] = '\0';
		
		i = 0;
		for(i=0;i<t.length();i++)
			b[i] = t.charAt(i);
		b[i] = '\0';
		
		int l = a.length;
		if(l < b.length)
			l = b.length;
		
		for(i=0;i<l;i++)
		{
			if(a[i] != b[i])
			{
				if(a[i] == '\0')
					return 1;
				if(b[i] == '\0')
					return 0;
				if(a[i] <= b[i])
					return 1;
				if(a[i] > b[i])
					return 0;
			}
		}
		return -1;
	}
	
	
	public static void advancePalindrome(String str)
	{
		String a = "", b = "";
		
		String temp = str.toLowerCase();
		for(int i=0;i<temp.length();i++)
		{
			if(temp.charAt(i) >= 97 && temp.charAt(i) <= 122)
				a = a + temp.charAt(i);
		}
		
		for(int i=0;i<a.length();i++)
			b = a.charAt(i)+b;
		
		System.out.println(a.equals(b));
		
	}
	
	static String arr[];
	static int index = 0;
	public static void checkIfAnagram(String a, String b)
	{
		arr = new String[factorial(b)];
		permutations(b);
		
		for(int i=0;i<index;i++)
		{
			int x = KMP(a, arr[i]);
			if(x != -1)
			{
				System.out.println(arr[i]+" found at position "+x);
			}
		}
	}
	
	public static int factorial(String s)
	{
		int l = s.length();
		int result = 1;
		for(int i = 1; i <= l; i++)
			result = result * i;
		return result;
	}
	
	public static void combinations(String s)
	{
		combinations("",s);
	}
	
	public static void combinations(String prefix, String s)
	{
		System.out.println(prefix);
		
		for(int i=0;i<s.length();i++)
			combinations(prefix+s.charAt(i), s.substring(i, s.length()));
	}
	
	public static void permutations(String s)
	{
		permutations("",s);
	}
	
	public static void permutations(String prefix, String s)
	{
		int len = s.length();
		if(len == 0)
		{
			arr[index] = prefix;
			index++;
		}
		
		for(int i=0;i<len;i++)
			permutations(prefix+s.charAt(i), s.substring(0, i)+s.substring(i+1, len));
	}
	
	public static void reverseSentence(String s)
	{
		char arr[] = s.toCharArray();
		int l = arr.length;
		for(int i = l-1; i >= 0; i--)
		{
			if(arr[i] == ' ')
			{
				int j = i+1;
				while(j != l && arr[j] != ' ')
				{
					System.out.print(arr[j]);
					j++;
				}
				System.out.print(' ');
			}
			
			if(i == 0)
			{
				int j = i;
				while(arr[j] != ' ')
				{
					System.out.print(arr[j]);
					j++;
				}
				System.out.print(' ');
			}
		}
	}
	
	public static String reverse(String s)
	{
		String temp = "";
		for(int i=0;i<s.length();i++)
			temp = s.charAt(i)+temp;
		return temp;
	}
	
	public static void editableReverse(String s)
	{
		int l = s.length()-1;
		char[] arr = s.toCharArray();
		for(int i=0;i<s.length()/2;i++)
		{
			char temp = arr[i];
			arr[i] = arr[l-i];
			arr[l-i] = temp;
		}
		System.out.println(arr);
	}
	
	public static int longesSubstring(String s, String t)
	{
		if(s.length() < t.length())
		{
			String temp = s;
			s = t;
			t = temp;
		}
		
		int n = s.length();
		int m = t.length();
		
		char text[] = s.toCharArray();
		char patt[] = t.toCharArray();
		
		int arr[][] = new int[n+1][m+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=m;j++)
				arr[i][j] = 0;
		int max = 0;
		int left = 0;
		int right = 0;
		int x = 0;
		int y = 0;
		String substr="";
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(text[i-1] == patt[j-1])
				{
					arr[i][j] = arr[i-1][j-1]+1;
					if(arr[i][j] > max)
					{
						max = arr[i][j];
						x = i;
						y = j;
					}
				}
			}
		}
		
		right = x-1;
		
		while(arr[x][y] != 1)
		{
			x--;
			y--;
		}
		left = x-1;
		
		for(int i=left;i<=right;i++)
			substr = substr+text[i];
		System.out.println(substr);
		
		return max;
	}
	
	public static int KMP(String s, String p)
	{
		char[] patt = p.toCharArray();
		int m = p.length();
		int f[] = new int[m];
		int i = 1;
		int j = 0;
		
		while(i < m)
		{
			if(patt[i] == patt[j])
			{
				f[i] = j + 1;
				i++;
				j++;
			}
			else if(j > 0)
			{
				j = f[j-1];
			}
			else
			{
				f[i] = 0;
				i++;
			}
		}
		
		int result = KMPSearch(s, p, f);
		return result;
	}
	
	public static int KMPSearch(String s, String p, int f[])
	{
		char[] text = s.toCharArray();
		char[] patt = p.toCharArray();
		int n = s.length();
		int m = p.length();
		int i = 0;
		int j = 0;
		
		while(i < n)
		{
			if(text[i] == patt[j])
			{
				if(j == m-1)
					return i-j;
				i++;
				j++;
			}
			else if(j > 0)
			{
				j = f[j-1];
			}
			else
			{
				i++;
			}
		}
		return -1;
	}
	
	
	public static int search(String s, String p)
	{
		char text[] = s.toCharArray();
		char patt[] = p.toCharArray();
		int n = s.length();
		int m = p.length();
		
		for(int i=0;i<n-m;i++)
		{
			int count = 0;
			int x = i;
			for(int j=0;j<m;j++,x++)
			{
				if(text[x] == patt[j])
					count++;
				else
					break;
			}
			if(count == m)
				return i;
		}
		return -1;
	}
}

class Node
{
	char letter;
	boolean wordEnd;
	Node[] list;
	
	public Node(char letter, boolean wordEnd)
	{
		this.letter = letter;
		this.wordEnd = wordEnd;
		list = new Node[26];
	}
}

class Trie
{
	Node node;
	int offset = 97;
	
	public Trie()
	{
		node = new Node('\0',false);
	}
	
	public void insert(String s)
	{
		char letters[] = s.toCharArray();
		int l = s.length();
		Node pointer = node;
		//System.out.println(pointer.letter);
		for(int i=0;i<l;i++)
		{
			int index = letters[i] - offset;
			boolean wordEnd = false;
			if(i == l-1)
				wordEnd = true;
			if(pointer.list[index] == null)
				pointer.list[index] = new Node(letters[i],wordEnd);
			pointer = pointer.list[index];
		}
	}
	
	public boolean search(String s)
	{
		char letters[] = s.toCharArray();
		int l = s.length();
		Node pointer = node;
		
		for(int i=0;i<l;i++)
		{
			int index = letters[i]-offset;
			if(pointer.list[index] == null)
				return false;
			pointer = pointer.list[index];
		}
		if(pointer.wordEnd)
			return true;
		else
			return false;
	}
	
	public void display(Node node, int level, char[] arr)
	{
		if(node == null)
			return;
		//System.out.println(node.letter);
		for(int i=0;i<node.list.length;i++)
		{
			arr[level] = node.letter;
			display(node.list[i], level+1, arr);
		}
		
		String temp = "";
		if(node.wordEnd)
		{
			for(int i=1;i<=level;i++)
				temp = temp+arr[i];
				//System.out.print(arr[i]);
			System.out.println(temp);
		}
	}
	
	public void autocomplete(String s)
	{
		int l = s.length();
		char[] letters = s.toCharArray();
		Node pointer = node;
		
		for(int i=0;i<l;i++)
		{
			if(pointer == null)
				return;
			int index = letters[i]-offset;
			pointer = pointer.list[index];
		}
		
		autoDisplay(pointer, 0, new char[50], s);
	}
	
	public void autoDisplay(Node node, int level, char[] arr, String s)
	{
		if(node == null)
			return;
		//System.out.println(node.letter);
		for(int i=0;i<node.list.length;i++)
		{
			arr[level] = node.letter;
			autoDisplay(node.list[i], level+1, arr,s);
		}
		
		String temp = s;
		if(node.wordEnd)
		{
			for(int i=1;i<=level;i++)
				temp = temp+arr[i];
				//System.out.print(arr[i]);
			System.out.println(temp);
		}
	}
}

























