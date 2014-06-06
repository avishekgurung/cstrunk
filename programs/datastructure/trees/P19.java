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
	Node search;
	
	//insertion
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
			while(q.peek() != null)
			{
				Node temp = q.remove();
				if(temp.left == null)
				{
					temp.left = new Node(null,data,null);
					if(data == 7)
						search = temp.left;
					return;
				}
				else
				{
					q.add(temp.left);
				}
				
				if(temp.right == null)
				{
					temp.right = new Node(null,data,null);
					if(data == 7)
						search = temp.right;
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
		while(q.peek() != null)
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
	
	public void zig_zag(Node node)
	{
		Stack<Node> currentLevel =  new Stack<Node>();
		Stack<Node> nextLevel =  new Stack<Node>();
		int leftToRight = 1;
		currentLevel.push(node);
		
		while(!currentLevel.isEmpty())
		{
			Node temp = currentLevel.pop();
			System.out.print(temp.getData()+" --> ");
			if(leftToRight == 1)
			{
				if(temp.left != null)
					nextLevel.push(temp.left);
				if(temp.right != null)
					nextLevel.push(temp.right);
			}
			else
			{
				if(temp.right != null)
					nextLevel.push(temp.right);
				if(temp.left != null)
					nextLevel.push(temp.left);
			}
			
			if(currentLevel.isEmpty())
			{
				leftToRight = 1 - leftToRight;
				Stack<Node> s = nextLevel;
				nextLevel = currentLevel;
				currentLevel = s;
				System.out.println();
			}
		}
		System.out.println();
	}
}

class P19
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.insert(1);
		t.insert(2);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(6);
		t.insert(7);
		t.insert(8);
		t.insert(9);
		t.insert(10);
		t.insert(11);
		
		t.display();
		t.zig_zag(t.node);
		
	}
}



















