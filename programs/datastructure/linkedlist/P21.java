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
	
	public void sort()
	{
		Node pointer = node;
		Node one = null;
		Node two = null;
		Node three = null;
		Node p_one = null;
		Node p_two = null;
		Node p_three = null;
		
		while(pointer != null)
		{
			if(pointer.getData() == 1)
			{
				if(one == null)
				{
					one = pointer;
					p_one = one;
				}
				else
				{
					p_one.next = pointer;
					p_one = pointer;
				}
				
			}
			
			if(pointer.getData() == 2)
			{
				if(two == null)
				{
					two = pointer;
					p_two = two;
				}
				else
				{
					p_two.next = pointer;
					p_two = pointer;
				}
				
			}
			
			if(pointer.getData() == 3)
			{
				if(three == null)
				{
					three = pointer;
					p_three = three;
				}
				else
				{
					p_three.next = pointer;
					p_three = pointer;
				}
				
			}
			
			
			pointer = pointer.next;
			if(pointer == null)
			{
				p_one.next = two;
				p_two.next = three;
				p_three.next = null;
			}
			
		}
		
		display(one);
		
	}
}

class P21
{
	public static void main(String[] args) 
	{
		//LinkedList l1 =  new LinkedList();
		LinkedList l2 = new LinkedList();
		
		l2.insert(1);
		l2.insert(2);
		l2.insert(1);
		l2.insert(1);
		l2.insert(3);
		l2.insert(2);
		l2.insert(3);
		l2.insert(3);
		l2.insert(1);
		
		l2.display(l2.node);
		
		l2.sort();
		
	}
}

/*
 * Create three nodes for 1 2 and 3.
 * Simply append them
 * 
 * 
 * The below logic cannot be used for LL, it can be used only for DLL
 * when 1 is encountered, it is pushed to the beginning of the list
 * when 3 is encountered, it is pushed to the end of the list
 * when 3 is encountered, do nothing.
 * 
 * SO we get a sorted list
 * 
 */
