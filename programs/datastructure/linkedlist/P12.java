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
	
	public void display()
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
	
	public void callReverse()
	{
		Node pointer = node;
		Node prev = null;
		reverse(pointer,prev);
	}
	
	public void reverse(Node pointer, Node prev)
	{
		if(pointer == null)
		{
			node = prev;
			return;
		}
		
		Node next = pointer.next;
		pointer.next = prev;
		prev = pointer;
		pointer = next;
		reverse(pointer, prev);
	}
	
	//simpler
	public Node reverse_recursion(Node node, Node prev)
	{
		if(node == null)
			return prev;
		Node x = node.next;
		node.next = prev;
		node = reverse_recursion(x, node);
		return node;
	}
	
	
}

class P12
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		
		l.display();
		
		l.callReverse();
		
		l.display();
	}
}
