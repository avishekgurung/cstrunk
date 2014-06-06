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
	
	//insert
	public void insert(String data)
	{
		Node pointer = node;
		if(node == null)
		{
			node = new Node(data,null);
		}
		else
		{
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next = new Node(data,null);
		}
	}
	
	//display
	public void display()
	{
		Node pointer = node;
		if(node == null)
		{
			System.out.println("The List is empty");
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
	
	//main item
	public void reverse(int n)
	{
		Node pointer = node;
		for(int i=1;i<=n;i++)
		{
			pointer = pointer.next;
		}
		
		Node pointer1 = node;
		while(pointer.next != null)
		{
			pointer1 = pointer1.next;
			pointer = pointer.next;
		}
		Node x = pointer1.next;
		
		pointer1.next = null;
		pointer.next = node;
		node = x;
	}
}

class P8
{
	public static void main(String[] args) {
		LinkedList ll =new LinkedList();
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
	/*	ll.insert("F");
		ll.insert("G");
		ll.insert("H");*/
		
		ll.display();
		ll.reverse(5);
		ll.display();
		
	}
}
