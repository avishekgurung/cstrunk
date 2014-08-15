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
	
	public Node delete(Node node,int data)
	{
		if(node == null)
		{
			System.out.println("Element Node found");
			System.exit(0);
		}
		else if(data > node.getData())
		{
			node.right = delete(node.right, data);
		}
		else if(data < node.getData())
		{
			node.left = delete(node.left, data);
		}
		else
		{
			
			if(node.left != null && node.right != null)
			{
				/*Node temp = max_recursion(node.left);
				node.data = temp.getData();
				node.left = delete(node.left, temp.getData());*/
				node.data = node.right.getData();
				delete(node.right,node.right.getData());
			}
			else if(node.left != null || node.right != null)
			{
				if(node.left != null)
				{
					node.data = node.left.getData();
					node.left = null;
				}
				else if(node.right != null)
				{
					node.data = node.right.getData();
					node.right = null;
				}
			}
			else
			{
				node = null;
			}
		}
		return node;
		
	}
	
	public Node max_recursion(Node node)
	{
		if(node.right == null)
			return node;
		
		node = max_recursion(node.right);
		return node;
	}
}

class P25
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.iteration_insert(4);
		t.iteration_insert(3);
		t.iteration_insert(6);
		t.iteration_insert(1);
		t.iteration_insert(2);
		t.iteration_insert(5);
		//t.iteration_insert(7);
		
		t.display();
		
		t.delete(t.node,4);
		
		t.display();
	}
}
