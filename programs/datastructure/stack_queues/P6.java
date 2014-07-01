import java.util.Stack;

class P6
{
	static Stack<Integer> s;
	public static void main(String[] args) 
	{
		s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		remove(s);
		
		while(!s.isEmpty())
			System.out.println(s.pop());
	}
	
	public static void remove(Stack s)
	{
		if(s.isEmpty())
			return;
		Integer x = (Integer)s.pop();
		remove(s);
		insert(s,x);
	}
	
	public static void insert(Stack s, Integer x)
	{
		if(s.isEmpty())
		{
			s.push(x);
			return;
		}
		
		Integer y = (Integer)s.pop();
		insert(s, x);
		s.push(y);
	}
}
