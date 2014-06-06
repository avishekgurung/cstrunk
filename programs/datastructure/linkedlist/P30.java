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
		
	public void alternateReverse(int n)
	{
		Node pointer = node;
		Node x = null, y = null;
		int count = 1;
		boolean flag = false;
		
		while(pointer != null)
		{
			if(count == n)
				x = pointer;
			
			if(count == 2*n+1)
			{
				y = pointer;
				count = 1;
				flag = true;
			}
			
			
			if(flag)
			{
				Node inner_p = x.next;
				Node next = null;
				Node prev = y;
				
				while(inner_p != y)
				{
					next = inner_p.next;
					inner_p.next = prev;
					prev = inner_p;
					inner_p= next;
				}
				x.next = prev;
				flag = false;
			}

			count++;
			pointer = pointer.next;
			if(pointer == null && count > n && count < 2*n+1)
			{
				Node inner_p = x.next;
				Node next = null;
				Node prev = null;
				
				while(inner_p != null)
				{
					next = inner_p.next;
					inner_p.next = prev;
					prev = inner_p;
					inner_p= next;
				}
				x.next = prev;
			}
			
			//edge condition, when n = 3, but the remaining elements to be removed are less than 3, eg 1,2,3,4,5
		}
	}
}

class P30
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
		/*l.insert(12);
		l.insert(13);
		*/

		l.display();
		
		l.alternateReverse(3);
		
		l.display();
		
	}
}

/*
 * Algo
 * The above programs might look complicated. But when followed the algorithm can be pretty simple
 * The process is similar to 
 * Program: Given two integers M and N, retain M and delete next N, continue this process
 * 
 * Suppose we have a linked list as
 * 1	2	3	4	5	6	7	8	9	10	11	12	13
 * 
 * and the given number is n = 3
 * 
 * Now we well traverse the LL and store node 3 at x, and store node 7 at y.
 * The values within these numbers are to be reversed, i.e 3	4	5
 * Once we get node 7, we reverse them using normal reverse rule.
 * After that, we reset the count and the flag, so that we can follow the same process to get numbers between 9 and 13
 * 
 * 
 */
