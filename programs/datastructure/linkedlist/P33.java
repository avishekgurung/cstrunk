class Node
{
	String data;
	Node next;
	
	public Node(String data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public String getData()
	{
		return data;
	}
}

class CircularLinkedList
{
	Node node;
	
	public void insert(String data)
	{
		if(node == null)
		{
			node  = new Node(data,null);
			node.next = node;
		}
		else
		{
			Node pointer =  node;
			while(pointer.next != node)
			{
				pointer = pointer.next;
			}
			pointer.next = new Node(data,node);
		}
	}
	
	public void display()
	{
		Node pointer = node; 
		do 
		{
			System.out.print(pointer.getData()+" --> ");
			pointer = pointer.next;
		}
		while(pointer != node);
	}
	
	public void chooseLeader(int n)
	{
		int length = 0;
		Node pointer = node;
		do
		{
			length++;
			pointer = pointer.next;
		}
		while(pointer != node);
		
		pointer = node;
		System.out.println("\n");
		while(length != 1)
		{
			for(int i=1;i<n-2;i++)
			{
				pointer = pointer.next;
			}
			System.out.println(pointer.next.getData()+" Eliminated.");
			pointer.next = pointer.next.next;
			pointer = pointer.next;
			length--;
		}
		System.out.println("\nThe choosen leader is "+pointer.getData()+"\n");
	}
}

class P33
{
	public static void main(String args[])
	{
		CircularLinkedList clist = new CircularLinkedList();
		clist.insert("Aman");
		clist.insert("Bidhya");
		clist.insert("Cipher");
		clist.insert("Dhanuj");
		clist.insert("Emmanuel");
		clist.insert("Avishek");
		clist.insert("Nitisha");
		clist.insert("Sandhya");
		
		clist.display();
		clist.chooseLeader(10);
	}
}
