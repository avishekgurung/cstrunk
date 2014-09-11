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
	
	public static int smallestElement = 0;
	public static int count = 0;
	public void smallest(Node node, int k)
	{
		if(node == null)
			return;
		smallest(node.left, k);
		count++;
		if(count == k)
			smallestElement = node.getData();
		smallest(node.right, k);
	}
	
	/*
		There are couple of ways to find the kth smallest in O(n) time complexity
		But since this is a BST, so its complexity has to be reduced to O(logn)
		as given below.
	*/
	
	public Node kthSmallest(Node node, int k)
	{
		while(true)
		{
			int num = total(node.left)+1;
			if(k == num)
			{
				System.out.println("Kth Smallest element is "+node.getData());
				break;
			}
			else if(k > num)
			{
				k = k - num;
				node = node.right;
			}
			else
			{
				node = node.left;
			}
		}
		return null;
	}
	
	public int total(Node node)
	{
		if(node == null)
			return 0;
		int left = total(node.left);
		int right = total(node.right);
		return left + 1 + right;
	}
	
	//By Recursion
	public int kthSmallest(Node node, int k){
		if(node == null){
			return -1;
		}
		int sum = total(node.left)+1;
		if(sum == k){
			return node.getData();
		}
		else if(k > sum){
			k = k - sum;
			return kthSmallest(node.right,k);
		}
		else{
			return kthSmallest(node.left,k);
		}
	}
}


class P32
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.iteration_insert(6);
		t.iteration_insert(4);
		t.iteration_insert(3);
		t.iteration_insert(5);
		t.iteration_insert(8);
		t.iteration_insert(7);
		t.iteration_insert(9);
		
		t.display();
		/*t.smallest(t.node, 3);
		System.out.println("Smallest "+t.smallestElement);*/
		t.kthSmallest(t.node, 3);
		//System.out.println(x);
	}
}
