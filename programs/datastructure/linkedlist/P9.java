class Node
{
	int data;
	Node next;
	
	Node(int data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public int getData()
	{
		return data;
	}
}

class LinkedList
{
	Node node;
	
	public void insert(int data)
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
	
	public void removeOdd()
	{
		Node pointer = node.next;
		while(pointer.next != null)
		{
			pointer.next = pointer.next.next;
			pointer = pointer.next;
			if(pointer == null)
			{
				break;
			}
		}
		node = node.next;
	}
	
	public void removeEven()
	{
		Node pointer = node;
		while(pointer.next != null)
		{
			pointer.next = pointer.next.next;
			pointer = pointer.next;
			if(pointer == null)
			{
				break;
			}
		}
	}
	
}

class P9
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(5);
		l.insert(6);
		
		l.display();
		//l.removeOdd();
		l.removeEven();
		
		l.display();
		
	}
}
