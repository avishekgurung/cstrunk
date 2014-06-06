import java.util.LinkedList;
import java.util.Queue;


class Node
{
	Node left;
	String data;
	Node right;
	
	Node(Node left, String data, Node right)
	{
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	public String getData()
	{
		return data;
	}
}

class Tree
{
	Node node;
	
	//insert
	public void insert(String data)
	{
		if(node == null)
		{
			node = new Node(null,data,null);
		}
		else
		{
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			
			while(q.peek() != null)
			{
				Node temp = q.remove();
				if(temp.left == null)
				{
					temp.left = new Node(null,data,null);
					return;
				}
				else
				{
					q.add(temp.left);
				}
				
				if(temp.right == null)
				{
					temp.right = new Node(null,data,null);
					return;
				}
				else
				{
					q.add(temp.right);
				}
			}
		}
	}
	
	//display
	public void display()
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(q.peek() != null)
		{
			Node temp = q.remove();
			System.out.print(temp.getData()+" --> ");
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}
	
	//search by recursion
	public void search_recursion(Node node,String element)
	{
		if(node == null)
			return;
		
		if(node.getData().equals(element))
			System.out.println("Element is present");
		search_recursion(node.left, element);
		search_recursion(node.right, element);
	}
	
	//search by iteration
	public void search_iteration(Node node, String element)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(q.peek() != null)
		{
			Node temp = q.remove();
			if(temp.getData().equals(element))
			{
				System.out.println("Element is present");
				return;
			}
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
		System.out.println("Element is NOT present");
	}
	
	public boolean search(Node node,String element)
	{
		if(node == null)
			return false;
		
		boolean left = search(node.left,element);
		boolean right = search(node.right,element);
		
		if(node.getData().equals(element) || left || right)
			return true;
		else
			return false;
			
	}
}

class P2
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.insert("A");
		t.insert("B");
		t.insert("C");
		t.insert("D");
		t.insert("E");
		t.insert("F");
		
		t.display();
		t.search_recursion(t.node, "E");
		t.search_iteration(t.node, "F");
		if(t.search(t.node, "K"))
			System.out.println("Found");
		else
			System.out.println("Not Found");
	}
}













