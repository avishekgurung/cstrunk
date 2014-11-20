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
	
	public void oddOrEven()
	{
		Node pointer = node;
		boolean flag = true;
		while (pointer.next != null)
		{
			pointer = pointer.next;
			if(pointer.next == null)
			{
				flag = false;
				break;
			}
			pointer = pointer.next;
		}
		
		if(flag)
		{
			System.out.println("Odd");
		}
		else
		{
			System.out.println("Even");
		}
	}
	
	public boolean isOdd(Node node){
		Node pointer = node;
		boolean flag = false;
		while(pointer != null){
			pointer = pointer.next;
			flag = !flag;
			
		}
		return flag;
	}
	
	//Brute Force method would be to count the total no of nodes and divide them by 2.
	//Over all, there are three methods
}

class P2
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		
		l.display();
		l.oddOrEven();
		
	}
}

