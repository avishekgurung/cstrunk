import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node
{
	Node left;
	int data;
	Node right;
	
	Node(Node left, int data, Node right)
	{
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	public int getData()
	{
		return data;
	}
}

class Tree
{
	Node node;
	int step = 1;
	
	//insertion
	public void insert(int data)
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
	
	public boolean identical(Node node1, Node node2)
	{
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null || node2 == null)
			return false;
		
		return (node1.getData() == node2.getData() && identical(node1.left,node2.left) && identical(node1.right,node2.right));
	}
	
	public boolean mirror(Node node1, Node node2)
	{
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null || node2 == null)
			return false;
		
		return (node1.getData() == node2.getData() && mirror(node1.left,node2.right) && mirror(node1.right,node2.left));
	}
	
	
}

class P15
{
	public static void main(String[] args) 
	{
		Tree t1 = new Tree();
		Tree t2 = new Tree();
		
		t1.insert(1);
		t1.insert(2);
		t1.insert(3);
		t1.insert(4);
		t1.insert(5);
		t1.insert(6);
		t1.insert(7);
		
		t2.insert(1);
		t2.insert(3);
		t2.insert(2);
		t2.insert(7);
		t2.insert(6);
		t2.insert(5);
		t2.insert(4);
		
		System.out.println("Identical: "+t1.identical(t1.node, t2.node));
		System.out.println("Mirror: "+t1.mirror(t1.node, t2.node));
		
	}
}





















