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
	
	//reversing 
	
	public void alternateReverse()
	{
		Node p  = node;
		Node p1 = null;
		Node p2 = null;
		boolean firstCheck = true;
		while(p.next != null)
		{
			p1 = p.next;
			p2 = p1.next;
			p1.next = p;
			
			if(p2 == null)
			{
				p.next = null; 
				break;
			}
			else if(p2.next == null)
			{
				p.next = p2;
			}
			else
			{
				p.next = p2.next;
			}
			p = p2;
			if(firstCheck)
			{
				node = p1;
				firstCheck = false;
			}
		}
	}
	
	//simpler
	public Node altReverse(Node node)
	{
		Node temp = node;
		Node result = node.next;
		while(temp != null)
		{
			Node x = temp.next;
			Node y = x.next;
			x.next = temp;
			if(y == null)
			{
				temp.next = null;
				break;
			}
			else if(y.next == null)
				temp.next = y;
			else
				temp.next = y.next;
			temp = y;
		}
		return result;
	}
	
}

class P15
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert("1");
		l.insert("2");
		l.insert("3");
		l.insert("4");
		l.insert("5");
		l.insert("6");
		l.insert("7");
		l.insert("8");
		l.insert("9");
		
		l.display();
		l.alternateReverse();
		l.display();
	}
}
