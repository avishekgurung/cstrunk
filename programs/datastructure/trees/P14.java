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
	
	public void mirror(Node node)
	{
		if(node == null)
			return;
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		mirror(node.left);
		mirror(node.right);
		
	}
	
	public void mirror_iteration(Node node)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			Node x = temp.left;
			temp.left = temp.right;
			temp.right = x;
			
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	
	//Another approach where an API will return the mirror node
	public Node createMirror(Node node)
	{
		if(node == null)
			return null;
		Node left = createMirror(node.left);
		Node right = createMirror(node.right);
		node.left = right;
		node.right = left;
		return node;
	}
}

class P14
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.insert(1);
		t.insert(2);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(6);
		t.insert(7);
		
		System.out.println("Original Tree");
		t.display();
		
		System.out.println("\nMirror by recursion");
		t.mirror(t.node);
		t.display();
		
		System.out.println("\nMirror by iteration");
		t.mirror_iteration(t.node);
		t.display();
	}
}


/*
 * Remember when we call t.mirror, a mirror of a tree is generated
 * when we call mirror_iteration, the mirror of tree is now converted to its mirror
 * hence the result of the function will be the original tree = mirror of mirror of time
 * 
 * So to check, comment one and run the other and vice versa
 */


















