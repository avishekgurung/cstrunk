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
		this.data = data;
		this.right = right;
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
			node = new Node(null,data,null);
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
					temp.left = new Node(null,data,null);
					return;
				}
				else
				{
					q.add(temp.left);
				}
				
				if(temp.right == null)
				{
					temp.right = new Node(null,data,null);
					return;
				}
				else
				{
					q.add(temp.right);
				}
			}
		}
	}
	
	//display
	public void display()
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
					System.out.println();
				}
			}
			else
			{
				System.out.print(temp.getData()+" -->");
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
		}
		System.out.println();
	}
	
	public void levelWithMaxSum(Node node)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		int level = 1, sum = 0;
		int maxVal = 0, maxLevel = 0;
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(temp == null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
				}
					
				if(sum > maxVal)
				{
					maxVal = sum;
					maxLevel = level;
				}
				level++;
				sum = 0;
			}
			else
			{
				sum = sum + temp.getData();
				if(temp.left != null)
					q.add(temp.left);
				
				if(temp.right != null)
					q.add(temp.right);
			}
		}
		
		System.out.println("The maximum sum of nodes is at level "+maxLevel+" and the max sum is "+maxVal);
	}
}

class P10
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.insert(1);
		t.insert(20);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(6);
		t.insert(7);
		
		t.display();
		t.levelWithMaxSum(t.node);
	}
}



























