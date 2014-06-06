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
	
	public void createLoop()
	{
		Node pointer = node;
		Node x = null;
		while(pointer.next != null)
		{
			if(pointer.getData().equals("B"))
			{
				x = pointer;
			}
			pointer = pointer.next;
		}
		
		pointer.next = x;
	}
	
	public void loopEvaluation()
	{
		Node p1 = node;
		Node p2 = node;
		int count = 0;
		boolean loop = true;
		
		do
		{
			p1 = p1.next;
			p2 = p2.next;
			if(p2 == null)
			{
				System.out.println("No Loop present");
				loop  = false;
				break;
			}
			p2 = p2.next;
		}
		while(p1 != p2);
		
		if(loop)
		{
			System.out.println("Loop present");
			p1 = node;
			
			while(p1 != p2)
			{
				count++;
				p1 = p1.next;
				p2 = p2.next;
			}
			
			do
			{
				count++;
				p2 = p2.next;
			}
			while(p1 != p2);
		}
		else
		{
			p1 = node;
			while(p1 != null)
			{
				count++;
				p1 = p1.next;
			}
		}
		
		System.out.println("Length "+count);
	}
}

class P18
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		l.createLoop();
		l.loopEvaluation();
		//l.display();
	}
}
