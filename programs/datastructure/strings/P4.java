class Node
{
	char letter;
	boolean wordEnd;
	Node[] list;
	
	public Node(char letter,boolean wordEnd)
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
		Node pointer = node;
		int l = s.length();
		
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
		Node pointer = node;
		int l = s.length();
		
		for(int i=0;i<l;i++)
		{
			int index = letters[i] - offset;
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
		
		for(int i=0;i<node.list.length;i++)
		{
			arr[level] = node.letter;
			display(node.list[i], level+1, arr);
		}
		
		if(node.wordEnd)
		{
			for(int i=1;i<=level;i++)
				System.out.print(arr[i]);
			System.out.println();
		}
	}
	
	public void nextWord(String s) //We assume that the given word also exits in the dictionary
	{
		char[] letters = s.toCharArray();
		Node pointer = node;
		int l = s.length();
		
		for(int i=0;i<l;i++)
		{
			int index = letters[i] - offset;
			pointer = pointer.list[index];
		}
		
		String temp = s;
		do
		{
			for(int i=0;i<pointer.list.length;i++)
			{
				if(pointer.list[i] != null)
				{
					
					pointer = pointer.list[i];//System.out.println("X");
					temp = temp+""+pointer.letter;
				}
			}
			//System.out.println("X");
		}
		while(!pointer.wordEnd);
		
		System.out.println("\nNext word in Dictitionary: "+temp);
	} 
	
}
class P4
{
	public static void main(String[] args) 
	{
		Trie trie = new Trie();
		
		String str[] = {"man","mango","manchestor"};
		
		for(int i=0;i<str.length;i++)
			trie.insert(str[i]);
		
		trie.display(trie.node, 0, new char[50]);
		System.out.println("\nSearch: "+trie.search("bane"));
		
		trie.nextWord("mango");
	}
}