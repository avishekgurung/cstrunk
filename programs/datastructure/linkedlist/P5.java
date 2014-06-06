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
	public void delete(String data)
	{
		Node pointer = node;
		
		while(pointer.next != null)
		{
			if(pointer.next.getData() == data)
			{
				pointer.next = pointer.next.next;
			}
			else
			{
				pointer = pointer.next;
			}
		}
		
		//The above logic will remove all the nodes that matches but not the first node. So to remove the first node, we use the below logic	
		
		if(node.getData() == data)
		{
			node = node.next;
		}
	}
}

class P5
{
	public static void main(String[] args) {
		LinkedList l =  new LinkedList();
		l.insert("A");
		l.insert("A");
		l.insert("C");
		l.insert("A");
		l.insert("F");
		l.insert("A");
		l.insert("F");
		l.insert("D");
		l.insert("A");
		l.insert("A");
		l.insert("Z");
		
		l.display();
		
		l.delete("A");
		
		l.display();
	}
}
