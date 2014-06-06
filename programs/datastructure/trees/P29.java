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
	
	static Node prev = null;
	static Node head = null;
	
	public void BSTToCDLL(Node node)
	{
		if(node == null)
			return;
		BSTToCDLL(node.left);
		node.left = prev;
		if(prev == null)
			head = node;
		else
			prev.right = node;
		//System.out.println(node.getData()+"\t"+prev);
		prev = node;
		BSTToCDLL(node.right);
	}
	
	public void TreeToList(Node node)
	{
		BSTToCDLL(node);
		head.left = prev;
		prev.right = head;
	}
	
	
	public void traverseDLL()
	{
		Node temp = head;
		do
		{
			System.out.print(temp.getData()+" --> ");
			temp = temp.right;
		}
		while(temp != head);
		System.out.println();
	}
	
	public void traverseBackDLL()
	{
		Node temp = prev;
		do
		{
			System.out.print(temp.getData()+" --> ");
			temp = temp.left;
		}
		while(temp != prev);
		System.out.println();
	}
}


class P29
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.iteration_insert(4);
		t.iteration_insert(2);
		t.iteration_insert(5);
		t.iteration_insert(1);
		t.iteration_insert(3);
		t.iteration_insert(7);
		t.iteration_insert(6);
		
		t.display(t.node);
		t.TreeToList(t.node);
		t.traverseDLL();
		t.traverseBackDLL();
	}
}
