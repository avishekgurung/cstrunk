class Node
{
	int data;
	Node next;
	
	Node(int data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public int getData()
	{
		return data;
	}
}

class LinkedList
{
	Node node;
	
	public void insert(int data)
	{
		Node pointer = node;
		if(node == null)
		{
			node =  new Node(data,null);
		}
		else
		{
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next =  new Node(data, null);
		}
	}
	
	public void display(Node node)
	{
		Node pointer = node;
		
		if(node == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			while(pointer != null)
			{
				System.out.print(pointer.getData()+" --> ");
				pointer = pointer.next;
			}
		}
		System.out.println();
	}
	
	/*
	 * Reason for using static variables
	 * If the same function was to be written in C then they write it as
	 * public Node	 add(Node *node1, Node *node2, int *carry, Node ** result)
	 * That means they are passing carry and result by reference and not by value.
	 * But since in Java we do not have call by reference and call by value , so we are obliged to use static
	 * 
	 * http://algorithmsandme.blogspot.in/2013/10/linked-list-add-two-numbers-represented.html
	 */
	static Node result = null;
	static int carry = 0;
	public Node	add(Node node1, Node node2)
	{
		if(node1 == null || node2 == null)
			return null;
		
		add(node1.next, node2.next);
		int sum = node1.getData()+node2.getData()+carry;
		carry = sum / 10;
		sum = sum % 10;
		Node temp = new Node(sum,result);
		result = temp;
		return result;
	}
	
	public void begin(Node node1, Node node2)
	{
		Node p1 = node1, p2 = node2;
		int l1 = 0, l2 = 0, diff = 0;
		while(p1 != null)
		{
			l1++;
			p1 = p1.next;
		}
		
		while(p2 != null)
		{
			l2++;
			p2 = p2.next;
		}
		
		if(l1 >= l2)
		{
			diff = l1 - l2;
		}
		else
		{
			diff = l2 - l1;
			Node temp = node1;
			node1 = node2;
			node2 = temp;
		}
		
		p1 = node1;
		p2 = node2;
		for(int i=0;i<diff;i++)
		{
			p1 = p1.next;
		}

		result = add(p1, p2);
		p1 = node1;
		add_remaining(p1, diff);
		if(carry != 0)
		{
			Node x = new Node(carry,result);
			result = x;
		}
		display(result);
	}
	
	public void add_remaining(Node p1, int diff)
	{
		if(p1 == null || diff == 0)
			return;
		
		add_remaining(p1.next, diff-1);
		int sum = p1.getData()+carry;
		carry = sum/10;
		sum = sum%10;
		Node temp = new Node(sum,result);
		result = temp;
	}
}

class P27
{
	public static void main(String[] args) 
	{
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		l1.insert(6);
		l1.insert(6);
		l1.insert(9);
		
		
		l2.insert(9);
		l2.insert(9);
		l2.insert(4);
		l2.insert(3);
		l2.insert(4);
		
		Node node1 = l1.node;
		Node node2 = l2.node;
		
		l1.display(node1);
		l2.display(node2);
		
		l1.begin(node1, node2);
	}
}

/*
 * Algo Explanation:
 * We divide our problem basically into three stages.
 * 
 * 1. We check if the two linked lists are of the same size of not.
 * 		a. If they are of the same size then not an issue.
 * 		b. But if they are of different size then we traverse the distance ( = difference) in the longer list.
 * 		c. We swap the nodes too so that we can shorten our code.
 * 
 * 2. Now we call add method, that will add two linked list which are virtually of the same length.
 * 	 	The sum will result in another linked list whose head is the result Node.
 * 
 * 3. Now is the third part. Where we add the remaining elements from the longer list to the result node.
 * 		After the above operation of we still have carry then we simply make this carry as new node and point it to the result.
 * 		Thus making the head.
 * 
 * For better understanding try the above example with two linked with contents
 * 				6 6 9
 *   	  +	9 9 4 3 4
 *Ans =   1 0 0 1 0 3 
 */
