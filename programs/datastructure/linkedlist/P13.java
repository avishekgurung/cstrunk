import java.util.HashSet;
import java.util.Set;

class Node
{
	int data;
	Node next;
	Node prev;
	
	Node(Node prev,int data, Node next)
	{
		this.prev = prev;
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
			node =  new Node(null,data,null);
		}
		else
		{
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next =  new Node(pointer,data, null);
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
	
	public void reverse()
	{
		Node pointer = node;
		Node next = null;
		while(true)
		{
			next = pointer.next;
			pointer.next = pointer.prev;
			pointer.prev = next;
			if(next == null)
			{
				node = pointer;
				break;
			}
			pointer = next;
		}
		
	}
	
	public void recursion(Node pointer)
	{
		Node next = pointer.next;
		pointer.next = pointer.prev;
		pointer.prev = next;
		if(next == null)
		{
			node = pointer;
			return;
		}
		recursion(next);
	}
}

class P13
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert(2);
		l.insert(5);
		l.insert(9);
		l.insert(11);
		l.insert(20);
		l.insert(26);

		l.display();
		//l.reverse();
		l.recursion(l.node);
		
		System.out.println(l.node.prev.getData());
		l.display();
		
	}
}
