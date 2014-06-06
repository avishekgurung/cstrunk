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
		this.data = data;
		this.right = right;
	}
	
	public int getData()
	{
		return data;
	}
}

class Tree
{
	Node node;
	Node a;
	Node b;
	
	//insert
	public void insert(int data)
	{
		if(node == null)
		{
			node = new Node(null,data,null);
		}
		else
		{
			Queue<Node> q =new LinkedList<Node>();
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
	
	public void display()
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(temp.getData() == 8)
				a = temp;
			
			if(temp.getData() == 11)
				b = temp;
			System.out.print(temp.getData()+" --> ");
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}
	
	public Node LCA(Node node, Node a, Node b)
	{
		if(node == null)
			return null;
		
		if(node == a || node == b)
			return node;
		
		Node left = LCA(node.left, a, b);
		Node right = LCA(node.right, a, b);
		
		if(left != null && right != null)
			return node;
		
		if(left != null)
			return left;
		else
			return right;
			
	}
}

class P18
{
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insert(1);
		t.insert(2);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(6);
		t.insert(7);
		t.insert(8);
		t.insert(9);
		t.insert(10);
		t.insert(11);
		t.insert(12);
		t.insert(13);
		t.insert(14);
		t.insert(15);
		t.insert(16);
		
		
		t.display();
		
		Node x = t.LCA(t.node, t.a, t.b);
		System.out.println("Lowest Common Ancestor is "+x.getData());
	}
}






















