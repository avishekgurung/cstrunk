class Node
{
	String data;
	Node next;
	
	Node(String data, Node next)
	{
		this.data =  data;
		this.next = next;
	}
	
	public String getData()
	{
		return data;
	}
}

class LinkedList
{
	Node node1;
	Node node2;
	
	//insert in node1
	public void insert1(String data)
	{
		Node pointer = node1;
		if(node1 == null)
		{
			node1 = new Node(data,null);
		}
		else
		{
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next =  new Node(data,null);
		}
	}
	
	//insert2
	public void insert2(String data)
	{
		Node pointer = node2;
		if(node2 == null)
		{
			node2 =  new Node(data, null);
		}
		else
		{
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next =  new Node(data,null);
		}
	}
	
	public void display()
	{
		Node pointer = node1;
		while(pointer != null)
		{
			System.out.print(pointer.getData()+" --> ");
			pointer = pointer.next;
		}
		System.out.println();
		
		pointer = node2;
		while(pointer != null)
		{
			System.out.print(pointer.getData()+" --> ");
			pointer = pointer.next;
		}
		System.out.println();
	}
	
	//merge
	public void merger()
	{
		Node p1 = node1;
		Node p2 = node2;
		
		for(int i=1;i<=1;i++)
		{
			p2 = p2.next;
		}
		
		for(int i=1;i<=4;i++)
		{
			p1 = p1.next;
		}
		
		p2.next = p1;
		
	}
	
	//finding point of intersection
	public void pointOfIntersection()
	{
		Node p1 = node1;
		Node p2 = node2;
		int l1 = 0;
		int l2 = 0;
		int diff = 0;
		
		while(p1!= null)
		{
			l1++;
			p1 = p1.next;
		}
		
		while(p2 != null)
		{
			l2++;
			p2 = p2.next;
		}
		
		p1 = node1;
		p2 = node2;
		
		if(l1 > l2)
		{
			diff = l1 - l2;
			for(int i=1;i<=diff;i++)
			{
				p1 = p1.next;
			}
		}
		else
		{
			diff = l2 - l1;
			for(int i=1;i<=diff;i++)
			{
				p2 = p2.next;
			}
		}
		
		while(p1 != p2)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		
		System.out.println("Point of intersection "+p1.getData());
		
		
	}
}

class P17
{
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert1("A");
		l.insert1("B");
		l.insert1("C");
		l.insert1("C");
		l.insert1("X");
		l.insert1("D");
		l.insert1("E");
		l.insert1("F");
		
		
		l.insert2("M");
		l.insert2("N");
		
		l.display();
		l.merger();
		l.display();
		l.pointOfIntersection();
		
	}
}
