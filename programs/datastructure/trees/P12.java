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
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			
				System.out.print(temp.getData()+" -->");
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
				
		}
		System.out.println("\n");
	}
	
	public void find_paths(Node node, int [] arr, int length)
	{
		if(node == null)
			return;
		
		arr[length] = node.getData();
		length++;
		
		if(node.left == null && node.right == null)
		{
			printArray(arr,length);
		}
		else
		{
			find_paths(node.left, arr, length);
			find_paths(node.right, arr, length);
		}
	}
	
	public void printArray(int[] arr,int length)
	{
		for(int i=0;i<length;i++)
		{
			System.out.print(arr[i]+" --> ");
		}
		System.out.println();
	}
}

class P12
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
		
		t.display();
		int [] arr = new int[100];
		t.find_paths(t.node, arr, 0);
	}
}



























