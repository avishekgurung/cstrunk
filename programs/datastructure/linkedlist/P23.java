import java.util.HashSet;

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
	HashSet set;
	int count = 0;
	
	public void insert(String data)
	{
		Node pointer = node;
		if(node == null)
		{
			node =  new Node(data,null);
			set = new HashSet<String>();
		}
		else
		{
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next =  new Node(data, null);
		}
		
		set.add(data);
		count++;
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
	
	public void checkDuplicates()
	{
		if(set.size() < count)
		{
			System.out.println("Duplicate Elements present");
		}
		else
		{
			System.out.println("All elements are Unique");
		}
	}
}

class P23
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		l.insert("M");
		l.insert("F");
		l.insert("V");
		l.insert("N");
		l.insert("K");
		l.insert("A");
		l.insert("Z");
		
		
		
		l.display();
		l.checkDuplicates();
	}
}

/*
 * Traverse through the ciruclar list or linked list.
 * In each traversal, put the value of the node in HashSet (Remember HashSet does not take any duplicate data)
 * In each traversal, increment the count so that we can get total no of nodes present in the LL
 * Finally, when traversal is compelte, compare the no of node present in LL with that of num of elements present in HashSet
 * If they are equal then no duplicates else duplicates (No of elements in HashSet will always be equal or less than the no elements of LL)
*/
