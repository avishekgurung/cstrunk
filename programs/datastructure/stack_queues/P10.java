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

class Stack
{
	Queue q1 = new Queue();
	Queue q2 = new Queue();
	int count = 0;
	
	public void push(int data)
	{
		if(q1.front() != null)
			q1.enqueue(data);
		else
			q2.enqueue(data);
		count++;
	}
	
	public void pop()
	{
		if(q1.front() != null)
		{
			for(int i=1; i < count; i++)
			{
				int temp = q1.front().getData();
				q2.enqueue(temp);
				q1.dequeue();
			}
			
			q1.dequeue();
		}
		else
		{
			for(int i=1; i < count; i++)
			{
				int temp = q2.front().getData();
				q1.enqueue(temp);
				q2.dequeue();
			}
			
			q2.dequeue();
		}
	}
	
	public void display()
	{
		System.out.println("Display will be generated based on queue, hence opposite");
		if(q1.front() != null)
			q1.display();
		else
			q2.display();
	}
	
	
}

class P10
{
	public static void main(String[] args) 
	{
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		s.pop();
		s.display();
		
	}
	
	
}
