class Node
{
	char data;
	Node next;
	
	Node(char data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public char getData()
	{
		return data;
	}
}

class Stack
{
	Node node;
	
	public void push(char data)
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

class P1
{
	public static void main(String[] args) 
	{
		P1 p = new P1();
		String exp = "[[{2*(3+1)+}-0]]";
		p.parsing(exp);
	}
	
	public void parsing(String exp)
	{
		Stack s = new Stack();
		boolean flag = true;
		
		for(int i=0; i < exp.length(); i++)
		{
			if(exp.charAt(i) == '{' || exp.charAt(i) == '[' || exp.charAt(i) == '(')
			{
				s.push(exp.charAt(i));
			}
			else if(exp.charAt(i) == '}')
			{
				if(s.top().getData() == '{')
					s.pop();
				else
					flag = false;
			}
			else if(exp.charAt(i) == ']')
			{
				if(s.top().getData() == '[')
					s.pop();
				else
					flag = false;
			}
			else if(exp.charAt(i) == ')')
			{
				if(s.top().getData() == '(')
					s.pop();
				else
					flag = false;
			}
		}
		
		if(s.top() != null)
			flag = false;
		
		if(flag)
			System.out.println("Correct Expression");
		else
			System.out.println("Incorrect Expression");
	}
}
















