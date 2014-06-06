import java.util.HashSet;
import java.util.Set;

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
	
	public void alternateDelete(int m, int n)
	{
		Node pointer = node;
		int count = 1;
		Node x = null, y = null;
		boolean flag = false;
		while(pointer.next != null)
		{
			if(count == m)
			{
				x = pointer;
			}
			if(count == m+n+1)
			{
				y = pointer;
				flag = true;
			}
			
			if(flag)
			{
				x.next = y;
				flag = false;
				count = 1;
			}
			
			count++;
			pointer = pointer.next;
			
			if(pointer.next == null)
			{
				if(count > m && count < m+n+1)
				{
					x.next = null;
				}
			}
		}
	}
}

class P26
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
		l.insert(9);
		l.insert(10);
		l.insert(11);
		l.insert(12);
		l.insert(13);
		l.insert(14);
		
		l.display();
		l.alternateDelete(3, 4);
		l.display();
	}
}
