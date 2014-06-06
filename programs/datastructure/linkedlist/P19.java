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
	
	public void alternateAdd(Node n1, Node n2)
	{
		Node p1 = n1;
		Node p2 = n2;
		
		while(p1 != null && p2 != null)
		{
			Node x = p1.next;
			Node y = p2.next;
			
			p1.next = p2;
			if(x == null || y == null)
			{
				break;
			}
			p2.next = x;
			
			p1 = x;
			p2 = y;
			
			
		}
	}
	
	//by recursion
	public void altMerge(Node a, Node b, boolean flag)
	{
		if(a == null)
			return;
		if(b == null)
			return;
		if(flag == true)
		{
			Node x = a.next;
			a.next = b;
			altMerge(x, b, false);
		}
		else
		{
			Node x = b.next;
			b.next = a;
			altMerge(a, x, true);
		}
	}
}

class P19
{
	public static void main(String[] args) 
	{
		LinkedList l1 =  new LinkedList();
		
		l1.insert("A");
		l1.insert("B");
		l1.insert("C");
		l1.insert("D");
		l1.insert("E");
		l1.display(l1.node);
		
		LinkedList l2 = new LinkedList();
		l2.insert("1");
		l2.insert("2");
		l2.insert("3");
		//l2.insert("4");
		//l2.insert("5");
		l2.display(l2.node);
		
		l1.alternateAdd(l1.node, l2.node);
		
		l1.display(l1.node);
		
		//l1.altMerge(l1.node,l2.node, true);
		
	}
}


