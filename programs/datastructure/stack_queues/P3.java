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

class P3
{
	public static void main(String[] args) 
	{
		P32 p = new P32();
		//String exp = "123*+4-";
		String exp = "32*42/+235*+2+*";
		p.postfixEvaluation(exp);
	}
	
	public void postfixEvaluation(String exp)
	{
		Stack s = new Stack();
		for(int i=0;i<exp.length();i++)
		{
			if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*' || exp.charAt(i) == '/')
			{
				int n = s.top().getData();
				s.pop();
				int m = s.top().getData();
				s.pop();
				int result = 0;
				if(exp.charAt(i) == '+')
				{
					result = m + n;
				}
				else if(exp.charAt(i) == '-')
				{
					result = m - n;
				}
				else if(exp.charAt(i) == '/')
				{
					result = m / n;
				}
				else if(exp.charAt(i) == '*')
				{
					result = m * n;
				}
				
				s.push(result);
			}
			else
			{
				s.push(Character.getNumericValue(exp.charAt(i)));
			}
		}
		
		System.out.println("Result: "+s.top().getData());
	}
}
















