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
	Node min;
	
	public void push(int data)
	{
		
		if(min == null)
		{
			min = new  Node(data,null);
		}
		else
		{
			if(data <= min.getData())
			{
				Node y = new Node(data,min);
				min = y;
			}
		}
		
		Node x = new Node(data,node);
		node = x;
	}
	
	public void pop()
	{
		if(node.getData() == min.getData())
		{
			min = min.next;
		}
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
	
	public int getMinimum()
	{
		return min.getData();
	}
}

class P5
{
	public static void main(String[] args) 
	{
		Stack s = new Stack();
		s.push(6);
		s.push(8);
		s.push(4);
		s.push(3);
		s.push(6);
		s.push(0);
		s.push(1);
		
		s.pop();
		s.pop();
		
		s.display();
		System.out.println("Minimum "+s.getMinimum());
	}
}
















