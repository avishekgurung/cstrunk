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

class LinkedList
{
	Node node;
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
	
	public void evaluate(String infix)
	{
		for(int i=0;i<infix.length();i++)
		{
			if(node == null)
			{
				node = new Node(infix.charAt(i),null);
			}
			else
			{
				Node temp = node;
				while(temp.next != null)
				{
					temp = temp.next;
				}
				temp.next = new Node(infix.charAt(i),null);
			}
		}
		display();
		
		//rule for *
		Node temp = node;
		while(temp.next != null)
		{
				if(temp.next.getData()=='*')
				{
					int m = Character.getNumericValue(temp.getData());
					int n = Character.getNumericValue(temp.next.next.getData());
					int result = m * n;
					temp.data = Character.forDigit(result, 10);
					temp.next = temp.next.next.next;
				}
				else
				{
					temp = temp.next;
				}
		}
		display();
		
		//rule for /
		temp = node;
		while(temp.next != null)
		{
				if(temp.next.getData()=='/')
				{
					int m = Character.getNumericValue(temp.getData());
					int n = Character.getNumericValue(temp.next.next.getData());
					int result = m / n;
					temp.data = Character.forDigit(result, 10);
					temp.next = temp.next.next.next;
				}
				else
				{
					temp = temp.next;
				}
		}
		display();
		
		//rule for +
		temp = node;
		while(temp.next != null)
		{
				if(temp.next.getData()=='+')
				{
					int m = Character.getNumericValue(temp.getData());
					int n = Character.getNumericValue(temp.next.next.getData());
					int result = m + n;
					temp.data = Character.forDigit(result, 10);
					temp.next = temp.next.next.next;
				}
				else
				{
					temp = temp.next;
				}
		}
		display();
		
		//rule for -
		temp = node;
		while(temp.next != null)
		{
				if(temp.next.getData()=='-')
				{
					int m = Character.getNumericValue(temp.getData());
					int n = Character.getNumericValue(temp.next.next.getData());
					int result = m - n;
					temp.data = Character.forDigit(result, 10);
					temp.next = temp.next.next.next;
				}
				else
				{
					temp = temp.next;
				}
		}
		System.out.print("Final Result ");display();
	}
}

class P4
{
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.evaluate("5+1*3-4/2+2*1*1");
	}
}

/*
So if the infix expression contains brackets, then the above program will not be valid.
So in such cases, the approach would be 
1. Convert infix to postfix
2. Evaluate postfix
*/
