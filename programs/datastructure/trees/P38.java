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
	
	public Node modify(Node node)
	{
		Node prev = null;
		Stack<Node> s = new Stack<Node>();
		Queue<Node> q = new LinkedList<Node>();
		Node temp = node;
		Node x = node;
		while(true)
		{
			while(node != null)
			{
				q.add(node);
				s.push(node);
				node = node.left;
			}
			
			if(s.isEmpty())
				break;
			node = s.pop();
			node = node.right;
		}
		
		while(!q.isEmpty())
		{
			temp = q.remove();
			temp.right = q.peek();
		}
		
		return x	;
	}
	
	public void show(Node node)
	{
		while(node != null)
		{
			System.out.print(node.getData()+"\t");
			node = node.right;
		}
	}
}


class P38
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
		
		Node node = t.modify(t.node);
		t.show(node);
		System.out.println();
	}
}
/*
 * So the requirement is fulfilled in the above case.
 * Do pre order traversal, put the nodes in queue, remove one by one and make its right pointer poin to the top of the queue. 
 * 
 */
 
