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

class Queue
{
	Node node;
	
	public void enqueue(int data)
	{
		if(node == null)
			node = new Node(data,null);
		else
		{
			Node pointer = node;
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next = new Node(data, null);
		}
	}
	
	public void dequeue()
	{
		node = node.next;
	}
	
	public Node front()
	{
		return node;
	}
	
	public void display()
	{
		Node pointer = node;
		while(pointer != null)
		{
			System.out.println(pointer.getData());
			pointer = pointer.next;
		}
	}
}

class P9
{
	public static void main(String[] args) 
	{
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		q.display();
		
		P9 p = new P9();
		p.reverse(q);
		System.out.println("\nReversed\n");
		q.display();
	}
	
	public void reverse(Queue q)
	{
		if(q.front() == null)
			return;
		int temp = q.front().getData();
		q.dequeue();
		reverse(q);
		q.enqueue(temp);
	}
}
