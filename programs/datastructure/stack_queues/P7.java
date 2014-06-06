import java.util.Stack;
class P7
{	
	public static void main(String[] args) 
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(6);
		s.push(12);
		s.push(5);
		s.push(3);
		s.push(9);
		s.push(7);
		
		Stack<Integer> r = new Stack<Integer>();
		
		while(!s.isEmpty())
		{
			int x = (Integer)s.pop();
			while(!r.isEmpty() && (Integer)r.peek() < x)
			{
				int y = (Integer)r.pop();
				s.push(y);
			}
			r.push(x);
		}
		
		while(!r.isEmpty())
			System.out.println(r.pop());
	}
}
