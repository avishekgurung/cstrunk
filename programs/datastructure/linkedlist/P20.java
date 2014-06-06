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
	
	public void alter()
	{
		Node pointer = node;
		Node odd = node;
		Node even = node.next;
		Node p_odd = odd;
		Node p_even = even;
		boolean first = true;
		
		while(pointer != null)
		{
			if(first)
			{
				p_odd = pointer; 
			}
			else
			{
				p_odd.next = pointer; 
				p_odd = pointer;
			}
			
			pointer = pointer.next;
			if(pointer == null)
			{
				p_even.next = null;
				p_odd.next = null;
				break;
			}
			
			if(first)
			{
				p_even = pointer; 
			}
			else
			{
				p_even.next = pointer;
				p_even = pointer;
			}
			
			pointer = pointer.next;
			if(pointer == null)
			{
				p_odd.next = null; 
				p_even.next = null;
			}
			first  = false;
		}
		
		//display(odd);
		//display(even);
		//reverse even
		Node prev = null, next = null;
		
		while(even != null)
		{
			next = even.next;
			even.next = prev;
			prev = even;
			even = next;
		}
		even = prev;
		p_odd.next = even;
		display(odd);
	}
}

class P20
{
	public static void main(String[] args) 
	{
		//LinkedList l1 =  new LinkedList();
		LinkedList l2 = new LinkedList();
		
		l2.insert(1);
		l2.insert(2);
		l2.insert(3);
		l2.insert(4);
		l2.insert(5);
		l2.insert(6);
		l2.insert(7);
		l2.insert(8);
		l2.insert(9);
		//l2.insert(10);
		
		
		/*l1.insert(100);
		l1.insert(200);
		l1.insert(300);

		l1.combine(l1.node, l2.node);*/
		l2.display(l2.node);
		l2.alter();

		
		
		
	}
}

/*
 * Create two seperate nodes, one should hold even and other should hold odd nodes
 * reverse even nodes and append to odd nodes
 * 
 */
