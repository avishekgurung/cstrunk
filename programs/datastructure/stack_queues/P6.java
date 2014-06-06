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
	
	public void remove(Stack s)
	{
		if(s.top() == null)
			return;
		int temp = s.top().getData();
		s.pop();
		remove(s);
		s.insert(s,temp);
	}
	
	public void insert(Stack s, int data)
	{
		if(s.top() == null)
		{
			s.push(data);
			return;
		}
		
		int dd = s.top().getData();
		s.pop();
		insert(s, data);
		s.push(dd);
	}
}

class P6
{
	public static void main(String[] args) 
	{
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		s.display();
		s.remove(s);
		
		s.display();
	}
	
}
















