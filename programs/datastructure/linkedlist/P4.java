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
		else if(node.next == null || node.getData() > data)
		{
			if(node.getData() > data)
			{
				Node x =  new Node(data,node);
				node = x;
			}
			else
			{
				node.next =  new Node(data,null);
			}
		}
		else
		{
			while(pointer.next != null)
			{
				if(pointer.next.getData() > data)
				{
					pointer.next =  new Node(data,pointer.next);
					break;
				}
				else
				{
					pointer = pointer.next;
				}
			}
			
			if(pointer.next == null)
			{
				pointer.next = new Node(data,null);
			}
			
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
}

class P4
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert(4);
		l.insert(3);
		l.insert(5);
		l.insert(1);
		l.insert(3);
		
		l.display();
	}
}

/* Algorithm 
1. if the LL is empty create new node
2. if the LL has only one element then do manual operation to add node in the correct place
3. if the inserted node is smaller than the first element, then add manually like above
4. Search for a node whoes value is greater than the inserted data, Just before this node we need to insert new node
5. if the inserted data is largest than all the node values present, append that node in the last

*/
