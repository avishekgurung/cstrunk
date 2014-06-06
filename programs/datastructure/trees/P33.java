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
	public void range(Node node,int k1, int k2)
	{
		if(node == null)
			return;
		range(node.left, k1, k2);
		if(node.getData() >= k1 && node.getData() <= k2)
			System.out.print(node.getData()+" ");
		range(node.right, k1, k2);
	}
}


class P33
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
		t.range(t.node, 5, 10);
		System.out.println();
	}
}
