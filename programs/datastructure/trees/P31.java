import java.util.Queue;
import java.util.LinkedList;
class Node
{
	Node left;
	Node right;
	int data;
	
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
	
//display , level order display
	public void display(Node node)
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
					System.out.print(temp.getData()+" --> ");
					if(temp.left != null)
						q.add(temp.left);
					if(temp.right != null)
						q.add(temp.right);
				}
		}
		System.out.println();
	}
	
	//Array to BST Conversion
	Node ArrayToBST(int[] arr, int leftIndex, int rightIndex)
	{
		if(leftIndex > rightIndex)
			return null;
		
		Node temp = null;
		if(leftIndex == rightIndex)
		{
			temp = new Node(null, arr[leftIndex], null);
		}
		
		if(leftIndex < rightIndex)
		{
			int mid = leftIndex + (rightIndex - leftIndex)/2;
			temp = new Node(null, arr[mid], null);
			temp.left = ArrayToBST(arr, leftIndex, mid-1);
			temp.right = ArrayToBST(arr, mid+1, rightIndex);
		}
		return temp;
	}
}

class P31
{
	Node node;
	
	public static void main(String[] args) 
	{
		int arr[] = {7,9,11,13,15,17};
		int leftIndex = 0;
		int rightIndex = arr.length-1;
		Tree t = new Tree();
		Node head = t.ArrayToBST(arr, leftIndex, rightIndex);
		t.display(head);
	}
}
