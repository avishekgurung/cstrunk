class TrieImplementation
{
	public static void main(String[] args) 
	{
		//String sa[] = {"ball","adobe","balloon","cum","cumming","avi","coming","bad","baton","balli","avishek","avinash","avinan"};
		String sa[] = {"mun","muna","mua","mup","mund","mune","munz","munb"}; //Sorts these string lexicographically
		Trie trie = new Trie();
		
		for(int i=0;i<sa.length;i++)
			trie.insert(sa[i]);
		
		System.out.println("\nDictionary");
		trie.display(trie.node, 0, new char[50]);
		
		String search = "batoni";
		System.out.println("\nSearching "+search+" Result: "+trie.search(search)+"\n");
		
		String auto = "avi";
		System.out.println("\nAuto completion of "+auto);
		trie.autocompletion(auto);
	}
}

class Node
{
	char letter;
	boolean wordEnd;
	Node list[];
	
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
		int l = s.length();
		char[] letters = s.toCharArray();
		Node pointer = node;
		for(int i=0;i<l;i++)
		{
			int index = letters[i] - offset;
			boolean wordEnd = false;
			if(i == l-1)
				wordEnd = true;
			
			if(pointer.list[index] == null)
				pointer.list[index] = new Node(letters[i], wordEnd);
			pointer = pointer.list[index];
		}
	}
	
	public boolean search(String s)
	{
		int l = s.length();
		char[] letters= s.toCharArray();
		Node pointer = node;
		
		for(int i=0;i<l;i++)
		{
			int index = letters[i] - offset;
			if(pointer.list[index] == null)
				return false;
			pointer = pointer.list[index];
		}
		
		if(pointer.wordEnd == true)
			return true;
		else
			return false;
	}
	
	public void display(Node node, int level, char arr[])
	{
		if(node == null)
			return;
		
		for(int i=0;i<node.list.length;i++)
		{
			arr[level] = node.letter;
			display(node.list[i], level+1, arr);
		}
		
		if(node.wordEnd == true)
		{
			for(int i=1;i<=level;i++)
				System.out.print(arr[i]);
			System.out.println();
		}
	}
	
	public void autocompletion(String s)
	{
		int l = s.length();
		char[] letters = s.toCharArray();
		Node pointer = node;
		
		for(int i=0;i<l;i++)
		{
			int index = letters[i] - offset;
			pointer = pointer.list[index];
			if(pointer == null)
				return;
		}
		
		autoDisplay(pointer, 0, new char[50], s);
	}
	
	public void autoDisplay(Node node, int level, char[] arr, String s)
	{
		if(node == null)
			return;
		
		for(int i=0;i<node.list.length;i++)
		{
			arr[level] = node.letter;
			autoDisplay(node.list[i], level+1, arr, s);
		}
		
		String temp = s;
		
		if(node.wordEnd)
		{
			for(int i=1;i<=level;i++)
				temp = temp+arr[i];
			System.out.println(temp);
		}
	}
}
























