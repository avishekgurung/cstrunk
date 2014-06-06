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
		if(node == null)
			return;
		System.out.print(node.getData()+"\t");
		display(node.left);
		display(node.right);
	}	
	
	public void cousins(Node node, int element)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		int level = 0;
		Node parent = null;
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(temp == null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
					level++;
				}
			}
			else
			{   //finding the parent
				if(temp.left != null)
				{
					if(temp.left.getData() == element)
					{
						parent  = temp;
					}
				}
				
				if(temp.right != null)
				{
					if(temp.right.getData() == element)
					{
						parent = temp;
					}
				}
				
				if(temp.getData() == element)
					break;
				
				if(temp.left != null)
					q.add(temp.left);
				
				if(temp.right != null)
					q.add(temp.right);
			}
		}
			
			q.clear();
			q.add(node);
			q.add(null);
			int x = level;
			level = 0;
			System.out.println("Parent "+parent.getData());
			while(!q.isEmpty())
			{
				Node temp = q.remove();
				if(temp == null)
				{
					if(!q.isEmpty())
					{
						q.add(null);
						level++;
					}
				}
				else
				{
					if(level == x)
					{
						if(parent.left != temp && parent.right != temp)
							System.out.print(temp.getData()+"\t");
					}
					if(temp.left != null)
						q.add(temp.left);
					if(temp.right != null)
						q.add(temp.right);
				}
			}
			System.out.println();
		}
}


class P39
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
		System.out.println();
		
		t.cousins(t.node, 1);

	}
}
/*
 * We follow a simple algo.
 * Do a BFS traversal and find the level where the element is present and also its parent.
 * Do a same traversal next time, and when the above level is reached, print all the elements of that level except the sibling of the given node.
 */
 
