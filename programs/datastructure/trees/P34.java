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
	public void insert(int data)
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
	public void display(Node node)
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
	
	public void rightview(Node node)
	{
		System.out.println("Right View of a tree.");
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(q.peek() == null && !q.isEmpty())
				System.out.print(temp.getData()+"\t");
			if(temp == null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
				}
			}
			else
			{
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
		}
		System.out.println();
	}
	
	public void leftview(Node node)
	{
		System.out.println("Left View of a tree.");
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(q.peek() == null && !q.isEmpty())
				System.out.print(temp.getData()+"\t");
			if(temp == null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
				}
			}
			else
			{
				if(temp.right != null)
					q.add(temp.right);
				if(temp.left != null)
					q.add(temp.left);
				
			}
		}
		System.out.println();
	}
}


class P34
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.insert(4);
		t.insert(2);
		t.insert(6);
		t.insert(1);
		t.insert(3);
		t.insert(5);
		t.insert(7);
		
		t.display(t.node);
		t.rightview(t.node);
		t.leftview(t.node);
		
		
	}
}
