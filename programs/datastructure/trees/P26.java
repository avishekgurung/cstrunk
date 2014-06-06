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
	
	public int shortestPath(Node node, int a, int b)
	{
		//Lets first find the LCA between a and b
		Node lca = LCA(node,a,b);
		int shortestPath = 0;
		Node temp = lca;
		while(true)
		{
			if(temp.getData() > a)
				temp = temp.left;
			else if(temp.getData() < a)
				temp = temp.right;
			else
				break;
			shortestPath++;
		}
		
		temp = lca;
		
		while(true)
		{
			if(temp.getData() > b)
				temp = temp.left;
			else if(temp.getData() < b)
				temp = temp.right;
			else
				break;
			shortestPath++;
		}
		
		return shortestPath;
	}
	
	public Node LCA(Node node, int a , int b)
	{
		if(node.getData() > a && node.getData() > b)
			node = LCA(node.left,a,b);
		else if(node.getData() < a && node.getData() < b)
			node = LCA(node.right,a,b);
		return node;
	}
}


class P26
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
		
		int sp = t.shortestPath(t.node, 11, 18);
		System.out.println("Shortest Path "+sp);
	}
}
