import java.util.LinkedList;
import java.util.Queue;

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
	Node search;
	
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
					if(data == 7)
						search = temp.left;
					return;
				}
				else
				{
					q.add(temp.left);
				}
				
				if(temp.right == null)
				{
					temp.right = new Node(null,data,null);
					if(data == 7)
						search = temp.right;
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
	
	public boolean print_ancestors(Node node,Node search)
	{
		if(node == null)
			return false;
		if(node.left == search || node.right == search || print_ancestors(node.left, search) || print_ancestors(node.right, search))
		{
			System.out.print(node.getData()+" --> ");
			return true;
		}
		return false;
	}
	
	//Using my own logic
	public boolean my_ancestor(Node node, Node search)
	{
		if(node == null)
			return false;
		if(node.left == search || node.right == search)
		{
			System.out.print(node.getData()+" ");
			return true;
		}
		
		boolean flag1 = my_ancestor(node.left, search);
		boolean flag2 = my_ancestor(node.right, search);
		if(flag1 || flag2)
		{
			System.out.print(node.getData()+" ");
			return true;
		}
		else
			return false;
	}
}

class P17
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.insert(3);
		t.insert(2);
		t.insert(1);
		t.insert(3);
		t.insert(6);
		t.insert(7);
		
		t.display();
		t.print_ancestors(t.node, t.search);
		System.out.println();
		
		t.my_ancestor(t.node, t.search);
		System.out.println();
	}
}



















