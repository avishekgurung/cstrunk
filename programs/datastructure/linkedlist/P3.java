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
	public void getFifthFromEnd()
	{
		Node pointer = node;
		while(pointer.next.next.next.next.next != null)
		{
			pointer = pointer.next;
		}
		
		System.out.println("Fifth Element from Last "+pointer.getData());
		
	}
	
	//main Item
	public void getNthElementFromLast(int n)
	{
		Node p1 = node;
		Node p2 = node;
		for(int i=2;i<=n;i++)
		{
			p1 = p1.next;
		}
		
		while(p1.next != null)
		{
			p2 = p2.next;
			p1 = p1.next;
			
		}
		
		System.out.println("The "+n+" element from the last is "+p2.getData());
	}
}

class P3
{
	public static void main(String[] args) {
		LinkedList ll =new LinkedList();
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
		ll.insert("F");
		ll.insert("G");
		ll.insert("H");
		ll.insert("I");
		ll.insert("K");
		ll.insert("L");
		
		ll.display();
		ll.getFifthFromEnd();
		ll.getNthElementFromLast(4);
	}
}
