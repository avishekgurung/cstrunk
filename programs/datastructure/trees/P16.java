import java.util.LinkedList;
import java.util.Queue;

class Node
{
	Node left;
	int data;
	Node right;
	
	public Node(Node left, int data, Node right)
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
	
	int preIndex = 0;
	public Node createTreeFromProrderAndPostorderExpression(int[] preorder, int[] inorder, int start, int end)
	{
		if(start > end)
			return null;
		
		int data = preorder[preIndex];
		preIndex++;
		Node node = new Node(null,data,null);
		
		if(end == start)
			return node;
		
		int inIndex = findIndex(inorder, data);
		
		node.left = createTreeFromProrderAndPostorderExpression(preorder, inorder, start, inIndex-1);
		node.right = createTreeFromProrderAndPostorderExpression(preorder, inorder, inIndex+1, end);
		return node;
		
	}
	
	public int findIndex(int[] arr, int element)
	{
		int index = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] == element)
			{
				index = i;
				break;
			}
		}
		return index;
	}
}

class P16
{
	public static void main(String[] args) 
	{
		BinaryTree t = new BinaryTree();
	
		int[] preorder = {4,2,1,3,6,5,7};
		int[] inorder = {1,2,3,4,5,6,7};
		int start = 0;
		int end = preorder.length-1;
		Node x = t.createTreeFromProrderAndPostorderExpression(preorder, inorder, start, end);
		
		t.display(x);
		
	}
}
