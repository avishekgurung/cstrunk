import java.util.Stack;
class Node
{
	String data;
	Node next;
	
	Node(String data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public String getData()
	{
		return data;
	}
}

class LinkedList
{
	Node node;
	
	public void insert(String data)
	{
		Node pointer = node;
		if(node == null)
		{
			node =  new Node(data,null);
		}
		else
		{
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next =  new Node(data, null);
		}
	}
	
	public void display(Node node)
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

	//only two pointers
	public void reverse_iteration(Node node){
		Node prev = null;
		while(node != null){
			Node next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		display(prev);
	}

	//here too only two pointers
	public Node reverse_recursion(Node node, Node prev){
		if(node == null){
			return prev;
		}
		Node next = node.next;
		node.next = prev;
		return reverse_recursion(next,node);
	}

	//use stack to reverse if they do not want us to use minimum pointers
	public void reverseUsingMinumumPointers(Node node){

		Stack<Node> stack = new Stack<Node>();
		Node pointer = node;
		while(pointer != null){
			stack.push(pointer);
			pointer = pointer.next;
		}

		pointer = stack.pop();
		Node lastNode = pointer;

		while(!stack.isEmpty()){
			pointer.next = stack.pop();
			pointer = pointer.next;
		}
		pointer.next = null;
		display(lastNode);

		//So if they do not want us to display then we do not need lastPointer
		//Hence we need only one pointer
	}
}

class P12
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		l.insert("F");
		l.insert("G");
		l.insert("H");
		l.insert("I");
		l.insert("J");
		l.insert("K");
		
		Node node = l.node;
		l.display(node);

		//By recursion
		//l.display(l.reverse_recursion(node,null));

		//By iteration
		//l.reverse_iteration(node);

		//Minimum pointer
		l.reverseUsingMinumumPointers(node);
	}
}
