import java.util.Currency;
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
	boolean checkTree = true;
	public static int previous = 0;
	
	//bfs insert
	public void bfs_insert(int data)
	{
		if(node == null)
			node = new Node(null,data,null);
		else
		{
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			while(!q.isEmpty())
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
	
	
	//checking validity of BST by inorder and max,min function
	public void inorder_max_min(Node node)
	{
		if(node == null)
			return;
		
		inorder_max_min(node.left);
		if(node.left != null && node.right != null)
		{
			Node left = max(node.left);
			Node right = min(node.right);
			//System.out.println(node.getData()+" "+left.getData()+" "+right.getData());
			if(left.getData() > node.getData() || right.getData() < node.getData())
				checkTree = false;
		}
		
		inorder_max_min(node.right);
		
	}
	
	//checking valid BST by inorder traversal
	public void inorder(Node node)
	{	
		if(node == null)
			return;
		
		inorder(node.left);
		//System.out.println(node.getData()+"\t"+Tree.previous);
		if(Tree.previous > node.getData())
			checkTree = false;
		Tree.previous = node.getData();
		inorder(node.right);
	}
	
	
	
	public Node max (Node node)
	{
		if(node.right == null)
			return node;
		
		node = max(node.right);
		return node;
	}
	
	public Node min(Node node)
	{
		if(node.left == null)
			return node;
		node = min(node.left);
		return node;
	}
	Node prev = null;
	public boolean checkIt(Node node)
	{
		if(node == null)
			return true;
		boolean myflag = true;
		boolean left  = checkIt(node.left);
		if(prev != null )
		{
			if(node.getData() < prev.getData())
				myflag = false;
		}
		prev = node;
		boolean right = checkIt(node.right);
		return left && right && myflag;
	}
}


class P28
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		
		t.bfs_insert(8);
		t.bfs_insert(7);
		t.bfs_insert(10);
		t.bfs_insert(3);
		t.bfs_insert(7);
		t.bfs_insert(9);
		t.bfs_insert(11);
		System.out.println();
		t.display();
		
		/*Node x = t.node;
		t.inorder_max_min(x);
		
		
		//t.inorder(x);
		if(t.checkTree)
			System.out.println("Valid BST\n");
		else
			System.out.println("Invalid BST\n");*/
		System.out.println("Check it "+t.checkIt(t.node));
	}
}
