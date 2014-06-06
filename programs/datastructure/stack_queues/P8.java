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

class Stack
{
	Node node;
	
	public void push(int data)
	{
		Node x = new Node(data,node);
		node = x;
	}
	
	public void pop()
	{
		node = node.next;
	}
	
	public Node top()
	{
		return node;
	}
	
	public void display()
	{
		Node pointer = node;
		System.out.println();
		while(pointer != null)
		{
			System.out.println(pointer.getData());
			pointer = pointer.next;
		}
		System.out.println();
	}
}

class Queue
{
	Stack s1 = new Stack();
	Stack s2 = new Stack();
	
	public void enqueue(int data)
	{
		s1.push(data);
	}
	
	public void dequeue()
	{
		if(s2.top() == null)
		{
			while(s1.top() != null)
			{
				int temp = s1.top().getData();
				s1.pop();
				s2.push(temp);
			}
			s2.pop();
		}
		else
		{
			s2.pop();
		}
	}
	
	public void display()
	{
		s2.display();
		s1.display();
	}
}


class P8
{
	public static void main(String[] args) 
	{
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.dequeue();
		q.dequeue();
		q.display();	
	}
	
}
















