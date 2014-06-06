import java.util.HashMap;
import java.util.Map;

class Node
{
	String data;
	Node next;
	
	Node(String data, Node next)
	{
		this.next = next;
		this.data = data;
	}
	
	public String getData()
	{
		return data;
	}
}

class LinkedList
{
	Node node;
	
	//insert
	public void insert(String data)
	{
		if(node == null)
		{
			node = new Node(data,null);
		}
		else
		{
			Node pointer = node;
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next = new Node(data,null);
		}
	}
	
	//display
	public void display()
	{
		if(node == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			Node pointer = node;
			while(pointer != null)
			{
				System.out.print(pointer.getData()+" --> ");
				pointer = pointer.next;
			}
			System.out.println();
		}
	}
	
	//create loop
	public void createLoop()
	{
		Node pointer = node;
		int i=1;
		Node x=null,y=null;
		while(pointer.next != null)
		{
			if(i == 4)
			{
				x = pointer;
			}
			pointer = pointer.next;
			i++;
		}
		pointer.next = x;
	}
	
	public void detectLoop(Node node)
	{
		Node pointer = node;
		Map<Node, Node> map = new HashMap<Node, Node>();
		Node start = null;
		
		while(pointer != null)
		{
			if(map.containsKey(pointer))
			{
				start = pointer;
				break;
			}
			map.put(pointer, pointer);
			pointer = pointer.next;
		}
		
		if(pointer == null)
			System.out.println("Loop not present");
		else
		{
			pointer = start;
			int length=0;
			do
			{
				pointer = pointer.next;
				length++;
			}
			while(pointer != start);
			System.out.println("Loop is present");
			System.out.println("Loop starts at "+start.getData());
			System.out.println("Length of the loop is "+length);
		}
	}
}

class P4
{
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		l.insert("F");
		l.insert("G");
		l.insert("H");
		l.insert("I");
		
		
		l.createLoop();
		l.detectLoop(l.node);
		//l.display();	
	}
}
