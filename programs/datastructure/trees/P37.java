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
		display(node.left);
		System.out.print(node.getData()+"\t");
		display(node.right);
	}
	
	public Node replace(Node node)
	{
		Stack<Node> s = new Stack<Node>();
		int sum = 0;
		Node temp = node;
		while(true)
		{
			while(node != null)
			{
				s.push(node);
				node = node.right;
			}
			if(s.isEmpty())
				break;
			node = s.pop();
			int x = node.getData();
			node.data = sum;
			sum = sum + x;
			node = node.left;
		}
		return temp;
	}
	
	//recursive way
	int sum = 0;
	public void utility(Node node){
		if(node == null)
			return;
		utility(node.right);
		sum = sum + node.getData();
		node.data = sum;
		utility(node.left);
	}
}


class P37
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
		Node node = t.replace(t.node);
		t.display(node);
		System.out.println();
	}
}
/*
 * Requirement: 
 * What is to be done here is
 * Say we have the above tree, 1 has to be replaced by sum from 2 to 7 i.e 2+3+4+5+6+7 = 27
 * 2 has to be replaced by sum from 3 to 7 = 25
 * .
 * .
 * .
 * similarly 6 has to be replace by the sum of elements higher than it, i.e 7
 * and finally 7 has to be replace by 0 since no elements are higher than 7.
 * 
 * ALGO: Very beautiful approach
 * 1. Do a reverse of inorder traversal which gives us 7,6,5,4,3,2,1
 * 2. Simply replace, each node by sum where sum = sum + node.getData;
 */
 
