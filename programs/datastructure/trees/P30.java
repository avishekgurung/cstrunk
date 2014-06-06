import java.util.LinkedList;
import java.util.Queue;

class Node
{
	Node next;
	Node prev;
	int data;
	
	Node(Node prev, int data, Node next)
	{
		this.prev = prev;
		this.data = data;
		this.next = next;
	}
	
	public int getData()
	{
		return data;
	}
}

class DoublyLinkedList
{
	Node node;
	
	//insert into DLL
	public void insert(int data)
	{
		if(node == null)
		{
			node = new Node(null,data,null);
		}
		else
		{
			Node temp = node;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new Node(temp,data,null);
		}
	}
	
	//display DLL
	public void display()
	{
		Node temp = node;
		Node track = null;
		while(temp != null)
		{
			System.out.print(temp.getData()+" --> ");
			if(temp.next == null)
				track = temp;
			temp = temp.next;
		}
		
		System.out.println();
		
		
		while(track != null)
		{
			System.out.print(track.getData()+" <-- ");
			track = track.prev;
		}
		System.out.println();
	}
	
	public Node findMiddle(Node node)
	{
		Node p1 = node;
		Node p2 = node.next;
		if(node.next == null)
			return node;
		
		if(p2.next == null) //if there are only two elements
			return p2;
		
		while(p2 != null)
		{
			p1 = p1.next;
			p2 = p2.next;
			if(p2 == null)
				break;
			p2 = p2.next;
		}
		
		return p1;
	}
	
	//Converting DOubly Linked List to BST
	public Node DLLtoBST(Node node)
	{
    	Node middle, nextNode, prevNode, temp;
		if(node == null || node.next == null)
			return node;
		
		middle = findMiddle(node); 
		prevNode = node;
		while(prevNode.next != middle)
			prevNode = prevNode.next;
		prevNode.next = null;
		nextNode = middle.next;
		
		middle.next = null;
		middle.prev = null;
		
		middle.prev = DLLtoBST(node);
		middle.next = DLLtoBST(nextNode);
		return middle;
	}
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		inorder(node.prev);
		System.out.println(node.getData());
		inorder(node.next);
	}
	
/*	public Node DLLtoBST(Node head)
	{
		Node temp,p,q;
		if(head == null || head.next == null)
			return head;
		
		temp = findMiddle(head);
		p = head;
		while(p.next != temp)
		{
			p = p.next;
		}
		
		p.next = null;
		q = temp.next;
		temp.next = null;
		temp.prev = DLLtoBST(head);
		temp.next = DLLtoBST(q);
		return temp;
	}*/
	
	public void display_tree(Node node)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			System.out.print(temp.getData()+" --> ");
			if(temp.prev != null)
				q.add(temp.prev);
			if(temp.next != null)
				q.add(temp.next);
		}
		System.out.println();
	}
}

class P30
{
	public static void main(String[] args) 
	{
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.insert(1);
		dl.insert(2);
		dl.insert(3);
		dl.insert(4);
		dl.insert(5);
		
		dl.display();
		
		Node bst = dl.DLLtoBST(dl.node);
		//dl.display_tree(bst);
		dl.inorder(bst);
	}
}
