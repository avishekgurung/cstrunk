import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node
{
	Node left;
	char data;
	Node right;
	
	public Node(Node left, char data, Node right)
	{
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	public char getData()
	{
		return data;
	}
}

class BinaryTree
{
	Node node;
	
	
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
	
	public Node createTree(char[] arr,int index)
	{
		if(arr == null)
			return null;
		
		char data = arr[index];
		Node node = new Node(null,data,null);
		
		if(data == 'L')
			return node;
		index++;
		node.left = createTree(arr, index);
		index++;
		node.right = createTree(arr, index);
		return node;
	}
}

class P20
{
	public static void main(String[] args) 
	{
		BinaryTree t = new BinaryTree();
		
		char[] arr = {'I','L','I','L','L'};
		int index = 0;
		Node node = t.createTree(arr, index);
		t.display(node);
	}
}
