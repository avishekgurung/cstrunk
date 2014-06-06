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
	Node a;
	Node b;
	
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
	
	public Node LCA(Node node, int a, int b)
	{
		if(node.getData() > a && node.getData() > b)
			node = LCA(node.left,a,b);
		else if(node.getData() < a && node.getData() < b)
			node = LCA(node.right,a,b);
		return node;
	}
}


class P27
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.iteration_insert(8);
		t.iteration_insert(14);
		t.iteration_insert(6);
		t.iteration_insert(7);
		t.iteration_insert(9);
		t.iteration_insert(16);
		t.iteration_insert(15);
		t.iteration_insert(18);
		t.iteration_insert(11);
		
		t.display();
		
		Node lca = t.LCA(t.node, 6, 18);
		System.out.println("LCA is "+lca.getData());
				
	}
}
