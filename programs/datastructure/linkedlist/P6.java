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
	
	//remove Duplicates
	public void removeDuplicates()
	{
		Node pointer = node;
		
		while(pointer.next != null)
		{
			if(pointer.getData() == pointer.next.getData())
			{
				pointer.next = pointer.next.next;
			}
			else
			{
				pointer = pointer.next;
			}
		}
	}
}

//We have assumed that the linked list is sorted but if its not, then we will use Map
//traverse and see if the next element is already present in map, if present remove else put inside map

class P6
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert(1);
		l.insert(2);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(5);
		l.insert(5);
		l.insert(5);
		l.insert(6);
		l.insert(6);
		l.insert(6);
		
		l.display();
		l.removeDuplicates();
		l.display();
	}
}
