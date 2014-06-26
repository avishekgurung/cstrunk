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
	
	
	public void altDelete(int m, int n)
	{
		Node pointer = node;
		Node start = null;
		int count = 1;
		
		while(pointer != null)
		{
			if(count == m)
				start = pointer;
			if(count == m+n)
			{
				count = 1;
				pointer = pointer.next;
				start.next = pointer;
				if(pointer == null)
					break;
			}
			pointer = pointer.next;
			if(pointer == null && count > m)
			{
				start.next = null;
			}
			count++;
		}
	}
}

class P25
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
		l.insert(7);
		l.insert(8);
		
		
		l.display();
		l.altDelete(2,3);
		l.display();
	}
}

