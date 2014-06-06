import java.util.LinkedList;
import java.util.Queue;

/*
 * The funda here is to go compare the root node with the data to be inserted.
 * If the data is greater then we move to right else we move to left.
 * We repeat the above process until and unless we meet a root node, where we need to insert the data at left or right but its left 
 * or right node is null. So this will be the correct place to insert. 
 */
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
	
	//insert by recursion
	public Node recursion_insert(Node node,int data)
	{
		if(node == null)
		{
			node = new Node(null,data,null);
			return node;
		}
		
			if(data > node.getData())
				node.right = recursion_insert(node.right, data);
			else
				node.left = recursion_insert(node.left, data);
		return node;
	}
	
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
}


class P23
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		System.out.println("Iteration ");
		t.iteration_insert(8);
		t.iteration_insert(14);
		t.iteration_insert(6);
		t.iteration_insert(7);
		t.iteration_insert(12);
		t.display();
		t.node = null;
		
		
		System.out.println("\nRecursion");
		t.node=t.recursion_insert(t.node,8);
		t.node=t.recursion_insert(t.node,14);
		t.node=t.recursion_insert(t.node,6);
		t.node=t.recursion_insert(t.node,7);
		t.node = t.recursion_insert(t.node,12);
		
		t.display();
	}
}
