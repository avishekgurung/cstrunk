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
			
			pointer.next = new Node(data,null);
		}
	}
	
	public void display()
	{
		Node pointer  = node;
		if(node == null)
		{
			System.out.println("empty list");
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
	
	//main item
	public void palindrome()
	{
		//Lets reverse first
		Node pointer = node;
		Node next_pointer = null;
		Node previous_pointer = null;
		
		String s1 = "", s2 = "";
		
		while(pointer != null)
		{
			s1 = s1+pointer.getData();
			s2 = pointer.getData()+s2;
			pointer = pointer.next;
		}
		if(s1.equals(s2))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	}

	//else put all data in a Stack and iterate again and compare
	
}
class P14
{
	public static void main(String[] args) {
		LinkedList l =  new LinkedList();
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("B");
		l.insert("A");
		//l.insert("F");
		/*l.insert("A");
		l.insert("A");
		l.insert("A");
		l.insert("A");
		l.insert("A");
		l.insert("A");*/
		
		l.display();
		l.palindrome();
	}
}
