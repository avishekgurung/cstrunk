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
	
	//bfs check
	public boolean validity(Node node)
	{
		Node prev = null;
		Stack<Node> s = new Stack<Node>();
		boolean flag = true;
		
		while(true)
		{
			while(node != null)
			{
				s.push(node);
				node = node.left;
			}
			
			if(s.isEmpty())
				break;
			node = s.pop();
			
			if(prev != null)
			{
				if(prev.getData() == node.getData() || prev.getData() > node.getData())
				{
					flag = false;
					break;
				}
			}
			
			prev = node;
			node = node.right;
		}
		return flag;
	}
	
	//dfs check
	Node prev = null;
	public boolean dfs_validity(Node node)
	{
		if(node == null)
			return true;
		boolean flag = true;
		boolean left = dfs_validity(node.left);
		if(prev != null)
		{
			if(prev.getData() == node.getData() || prev.getData() > node.getData())
				flag  = false;
		}
		prev = node;
		boolean right = dfs_validity(node.right);
		return left && flag && right;
	}
}


class P36
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
		
		System.out.println("BST Check "+t.validity(t.node));
		System.out.println("BST Check "+t.validity(t.node));
	}
}

 
