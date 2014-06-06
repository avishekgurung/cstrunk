import java.util.ArrayList;
import java.util.List;

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
	
	public void remove()
	{
		Node pointer = node;
		List <Integer> list = new ArrayList<Integer>();
		Integer present = pointer.getData();
		list.add(present);
		
		
		while(pointer.next != null)
		{
			present = pointer.next.getData();
			
			if(list.contains(present))
			{
				pointer.next = pointer.next.next;
			}
			else
			{
				list.add(present);
				pointer = pointer.next;
			}
		}
		
	}
	
	public void altDelete(int M, int N)
	{
		Node temp = node1,first = null, second = null;
		boolean flag = false;
		while(temp != null)
		{
			for(int i=1;i<M;i++)
			{
				if(temp == null)
				{
					flag = true;
					break;
				}
				temp = temp.next;
			}
			
			if(flag)
				break;
			first = temp;
			
			for(int i=1;i<=N+1;i++)
			{
				if(temp == null)
				{
					flag = true;
					break;
				}
				temp = temp.next;
			}
			
			if(flag)
			{
				first.next = null;
				break;
			}
			
			second = temp;
			first.next = second;
		}
		display(node1);
	}
}

class P25
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert(4);
		l.insert(3);
		l.insert(2);
		l.insert(2);
		l.insert(1);
		l.insert(6);
		l.insert(3);
		l.insert(4);
		
		
		l.display();
		l.remove();
		l.display();
	}
}

/*
 * Algo
 * 1. Put the first element into the Array List (AL)
 * 2. Now check the next element in every iteration
 * 		If the next element is already present int AL, then delete it
 * 		else Add the element in the AL
 */
