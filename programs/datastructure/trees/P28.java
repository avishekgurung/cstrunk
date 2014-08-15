import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node
{
	int data;
	Node left;
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
	
	  public void insert(int data)
      {
          if(node == null)
                  node = new Node(null,data,null);
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
	
	
	//utility Function By Iteration if extra space can be used  
	public boolean checkBST(Node node)
	{
		boolean flag = true;
		
		Stack<Node> s = new Stack<Node>();
		int prev = -1;
		while(true)
		{
			while(node != null)
			{
				s.push(node);
				node = node.left;
			}
			
			if(s.isEmpty())
				break;
			
			node = s.pop();
			if(prev >= node.getData())
			{
				flag = false;
				break;
			}
			
			prev = node.getData();
			node = node.right;
		}
		return flag;
	}
	

	static Node prev = null;
	public boolean checkBST_recur(Node node)
	{
		if(node == null)
			return true;
		boolean left = checkBST_recur(node.left);
		if(prev != null)
		{
			if(prev.getData() >= node.getData())
				return false;
		}
		prev = node;
		boolean right = checkBST_recur(node.right);
		return left && right;
	}
	
	//Just for displaying purpose
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
				}
				System.out.println();
			}
			else
			{
				System.out.print(temp.getData()+"  ");
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
		}
	}
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.getData()+" ");
		inorder(node.right);
	}
}

class P28
{
	public static void main(String[] args) 
	{
		Tree tree = new Tree();
		tree.insert(4);
		tree.insert(2);
		tree.insert(6);
		tree.insert(2);
		tree.insert(3);
		tree.insert(5);
		tree.insert(7);
		
		Node node = tree.node;
	
		tree.display(node);
		System.out.println();
		tree.inorder(node);
		System.out.println("\n");

		System.out.println("BST CHeck: "+tree.checkBST(node));
		System.out.println("BST Check Recursion: "+tree.checkBST_recur(node));
	}
}
























