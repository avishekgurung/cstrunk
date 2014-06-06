import java.util.LinkedList;
import java.util.Queue;

class Node
{
	int data;
	Node left;
	Node right;
	Node nextSibling;
	
	Node(Node left,int data, Node right, Node nextSibling)
	{
		this.left = left;
		this.data = data;
		this.right = right;
		this.nextSibling = nextSibling;
	}
	
	public int getData()
	{
		return data;
	}
}

class Tree
{
	Node node;
	
	//insert
	public void insert(int data)
	{
		if(node == null)
		{
			node = new Node(null,data,null,null);
		}
		else
		{
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			
			while(!q.isEmpty())
			{
				Node temp = q.remove();
				if(temp.left == null)
				{
					temp.left = new Node(null,data,null,null);
					return;
				}
				else
				{
					q.add(temp.left);
				}
				
				if(temp.right == null)
				{
					temp.right = new Node(null,data,null,null);
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
			System.out.print(temp.getData()+" --> ");
			
			if(temp.left != null)
				q.add(temp.left);
			
			if(temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}
	
	public void addNextSiblings()
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(temp == null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
				}
			}
			else
			{
				temp.nextSibling = q.peek();
				if(temp.left != null)
				{
					q.add(temp.left);
				}
				if(temp.right != null)
				{
					q.add(temp.right);
				}
			}
		}
	}
	
	public void display_withSiblings()
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			System.out.print(temp.getData()+" --> ");
			if(temp.nextSibling != null)
			{
				System.out.println(temp.nextSibling.getData()+" ");
			}
			else
			{
				System.out.println();
			}
			if(temp.left != null)
				q.add(temp.left);
			
			if(temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}
}

class P21
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
		
		t.display();
		
		t.addNextSiblings();
		
		t.display_withSiblings();
	}
}




















