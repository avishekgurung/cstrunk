import java.util.HashSet;
import java.util.Set;

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

class LinkedList
{
	Node node;
	
	public void insert(int data)
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

	public Node sort(Node n, Node m){
		if(n == null && m == null)
			return null;
		if(n == null)
			return m;
		if(m == null)
			return n;
		Node temp = null;
		if(n.getData() < m.getData()){
			temp = new Node(n.getData(),null);
			temp.next = sort(n.next,m);
		}
		else{
			temp = new Node(m.getData(),null);
			temp.next = sort(n,m.next);
		}
		return temp;
	}
}

class P26
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert(1);
		l.insert(4);
		l.insert(7);
		l.insert(10);
		l.insert(15);
		l.insert(16);
		l.insert(17);
		l.insert(18);
		
		Node node1 = l.node;
		l.display(node1);

		LinkedList m =  new LinkedList();
		
		m.insert(2);
		m.insert(3);
		m.insert(9);
		m.insert(10);
		m.insert(20);
		
		Node node2 = m.node;
		m.display(node2);

		Node node = m.sort(node1,node2);
		m.display(node);
	}
}
