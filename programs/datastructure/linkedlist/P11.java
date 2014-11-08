class Node
{
	String data;
	Node next;
	
	Node(String data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public String getData()
	{
		return data;
	}
}

class LinkedList
{
	Node node;
	
	public void insert(String data)
	{
		Node pointer = node;
		if(node == null)
		{
			node =  new Node(data,null);
		}
		else
		{
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next =  new Node(data, null);
		}
	}
	
	public void display(Node node)
	{
		Node pointer = node;
		
		if(node == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			while(pointer != null)
			{
				System.out.print(pointer.getData()+" --> ");
				pointer = pointer.next;
			}
		}
		System.out.println();
	}

	//only two pointers
	public Node reverse_iteration(Node node){
		Node prev = null;
		while(node != null){
			Node next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		return prev;
	}

	//here too only two pointers
	public Node reverse_recursion(Node node, Node prev){
		if(node == null){
			return prev;
		}
		Node next = node.next;
		node.next = prev;
		return reverse_recursion(next,node);
	}

}

class P11
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		l.insert("F");
		l.insert("G");
		l.insert("H");
		l.insert("I");
		l.insert("J");
		l.insert("K");
		
		l.display(l.node);

		//l.display(l.reverse_iteration(l.node));
		l.display(l.reverse_recursion(l.node,null));
	}
}
