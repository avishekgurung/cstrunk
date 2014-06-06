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
	
	//insert by iteration
	public void iteration_insert(int data)
	{
		if(node == null)
		{
			node = new Node(null,data,null);
		}
		else
		{
			Node temp = node;
			while(true)
			{
				if(data > temp.getData())
				{
					if(temp.right == null)
					{
						temp.right = new Node(null,data,null);
						return;
					}
					else
						temp = temp.right;
				}
				else
				{
					if(temp.left == null)
					{
						temp.left = new Node(null,data,null);
						return;
					}
					else
					{
						temp = temp.left;
					}
				}
			}
		}
	}
	
	//display , level order display
	public void display()
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty())
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
	
	public Node max_iteration(Node node)
	{
		Node temp = node;
		while(temp.right != null)
			temp = temp.right;
		return temp;
	}
	
	public Node max_recursion(Node node)
	{
		if(node.right == null)
			return node;
		
		node = max_recursion(node.right);
		return node;
	}
	
	public Node min_iteration(Node node)
	{
		Node temp = node;
		while(temp.left != null)
			temp = temp.left;
		return temp;
	}
	
	public Node min_recursion(Node node)
	{
		if(node.left == null)
			return node;
		
		node = min_recursion(node.left);
		return node;
	}
}


class P24
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.iteration_insert(8);
		t.iteration_insert(14);
		t.iteration_insert(6);
		t.iteration_insert(7);
		t.iteration_insert(12);
		
		t.display();
		
		//Lets make a copy of original node and pass in function
		Node a = t.node;
		Node b = t.node;
		Node c = t.node;
		Node d = t.node;
		
		System.out.println("Max by Recursion: "+t.max_recursion(a).getData());
		System.out.println("Max by Iteration: "+t.max_iteration(b).getData());
		System.out.println("Min by Recursion: "+t.min_recursion(c).getData());
		System.out.println("Min by Iteration: "+t.min_iteration(c).getData());
	}
}
