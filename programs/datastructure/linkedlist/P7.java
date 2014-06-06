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
	Node x; //which will point tp one particular node 
	
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
		int i =1;
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
	
	public void create()
	{
		Node pointer = node;
		int i = 1;
		while(pointer != null)
		{
			//This is just to assingn some node to x, we choose the third node of this Linked List
			if(i == 2)
			{
				x = pointer;
			}
			i++;
			pointer = pointer.next;
		}
		
		delete(x);
	}
	
	//main item We will assume that we are just given x and nothing else, so from this we need to delete the pointer to which x is pointing
	public void delete(Node x)
	{
		System.out.println("Element to be deleted "+x.getData());
		if(x.next == null) //i.e. if x is the last element
		{
			System.out.println("Not possible to delete");
		}
		else
		{
			x.data = x.next.getData();
			x.next =  x.next.next;
		}
		
	}
}

class P7
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		
		l.display();
		l.create();
		l.display();
		
	}
}

/*
Copy the next element's data into the current node 
and delete the next node

*/
