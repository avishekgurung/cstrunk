/*
Program to reverse LL for a given value, Not alternate reverse
*/
class Node
{
	int data;
	Node next;
	
	public Node(int data, Node next)
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
		if(node == null)
		{
			node = new Node(data,null);
		}
		else
		{
			Node pointer = node;
			while(pointer.next != null)
				pointer = pointer.next;
			
			pointer.next = new Node(data,null);
		}
	}
	
	public void display(Node node)
	{
		Node pointer = node;
		while(pointer != null)
		{
			System.out.print(pointer.getData()+" --> ");
			pointer = pointer.next;
		}
		System.out.println();
	}
	
	public void reverse(Node x, Node y)
	{
		Node pointer = x;
		Node next = null;
		Node prev = null;
		if(prev == null);
		
		while(pointer != y)
		{
			next = pointer.next;
			pointer.next = prev;
			prev = pointer;
			pointer = next;
		}
		pointer.next = prev;
	}
	
	public void reverseBlock(int k)
	{
		Node pointer = node;
		int count = 1;
		Node start = null;
		Node end = null;
		Node prevStart = null;
		
		boolean first = true;
		
		Node head = null;
		
		while(pointer != null)
		{
			if(count == 1)
			{
				start = pointer;
			}
			
			count++;
			pointer = pointer.next;
			
			if(count == k)
			{
				if(first)
				{
					head = pointer;
				}
				end = pointer; 
				pointer = pointer.next;
				reverse(start, end);
				if(first)
				{
					start.next = pointer;
					first = false;
				}
				else
				{
					prevStart.next = end;
					start.next = pointer;
				}
				prevStart = start;
				
				count = 1;
			}
		}
		
		display(head);
	}
}

class P32
{
	public static void main(String[] args) 
	{
		LinkedList obj = new LinkedList();
		
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		obj.insert(6);
		obj.insert(7);
		obj.insert(8);
		obj.insert(9);
		obj.insert(10);
		obj.insert(11);
		obj.insert(12);
		
		
		obj.display(obj.node);
		obj.reverseBlock(5);
	}
}
