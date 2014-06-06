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
	
	//finding maximum element by recursion
	public int findMax_recursion(Node node)
	{
		int max;
		if(node == null)
			return 0;
		int node_data = node.getData();
		int left_data = findMax_recursion(node.left);
		int right_data = findMax_recursion(node.right);
		
		if(left_data > right_data)
			max = left_data;
		else
			max = right_data;
		
		if(node_data > max)
			max = node_data;
		return max;
	}
	
	//finding maximum element by iteration
	public int findMax_iteration(Node node)
	{
		int max = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(q.peek() != null)
		{
			Node temp = q.remove();
			if(temp.getData() > max)
				max = temp.getData();
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
		return max;
	}
	
}

class P1
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
		System.out.println("Maximum Element by iteration "+t.findMax_recursion(t.node));
		System.out.println("Maximum Element by recursion "+t.findMax_iteration(t.node));
	}
}

/*
 * Algo
 * 
 * By Recursion
 * 		Here we find the maximum element from the left subtree, maximum element from the right subtree and compare with the node
 * 		This method is pretty similar to the pre order traversal method. The program can be traced to understand them more clearly
 * 
 * By Iteration
 * 		This method is very easy as it is very much similar to level order traversal.
 */


















