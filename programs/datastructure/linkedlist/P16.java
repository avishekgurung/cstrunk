class Node
{
	String data;
	Node next;
	
	Node(String data, Node next)
	{
		this.next = next;
		this.data = data;
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
		if(node == null)
		{
			node = new Node(data,null);
		}
		else
		{
			Node pointer = node;
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
		if(node == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			Node pointer = node;
			while(pointer != null)
			{
				System.out.print(pointer.getData()+" --> ");
				pointer = pointer.next;
			}
			System.out.println();
		}
	}
	
	//create loop
	public void createLoop()
	{
		Node pointer = node;
		int i=1;
		Node x=null,y=null;
		while(pointer.next != null)
		{
			if(i == 4)
			{
				x = pointer;
			}
			pointer = pointer.next;
			i++;
		}
		
		//System.out.println("x "+x.getData()+"\t y "+y.getData());
		pointer.next = x;
	}
	
	//Main Item detect Loop
	public void detectLoop()
	{
		Node pointer = node;
		Node faster = node;
		boolean loop = false;
		int count = 1;
		
		//detecting the Loop
		while(faster.next != null)
		{
			pointer = pointer.next;
			faster = faster.next;
			faster = faster.next;
			if(pointer == faster)
			{
				loop = true;
				break;
			}
		}
		
		if(loop)
		{
			System.out.println("Loop  is present");
		}
		else
		{
			System.out.println("Loop is absent");
		}
	
		//Find the point of intersection
		pointer = node;
		
		while(pointer != faster)
		{
			pointer = pointer.next;
			faster = faster.next;
		}
		
		System.out.println("The point of intersection is "+pointer.getData());
		
		//Finding the length of the loop
		faster = faster.next;
		while(faster != pointer)
		{
			count++;
			faster = faster.next;
		}
		
		System.out.println("The length of the loop is "+count);
		
		//removing the loop
		pointer.next = null;
		
		
	}
	
}

class P16
{
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		l.insert("F");
		l.insert("G");
		l.insert("H");
		l.insert("I");
		//l.insert("J");
		
		
		l.createLoop();
		l.detectLoop();
		l.display();	
	}
}
