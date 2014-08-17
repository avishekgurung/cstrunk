import java.util.HashMap;
import java.util.Map;

class Node
{
	Node next;
	int data;
	Node random;
	
	Node(int data, Node next, Node random)
	{
		this.data = data;
		this.next = next;
		this.random = random;
	}
	
	public int getData()
	{
		return data;
	}
}

class LinkedList
{
	Node node;
	
	//create sefly Node
	public void createNode()
	{
		Node one = new Node(1,null,null);
		Node two = new Node(2,null,null);
		Node three = new Node(3,null,null);
		Node four = new Node(4,null,null);
		Node five = new Node(5,null,null);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		
		one.random = three;
		two.random = one;
		three.random = five;
		four.random = three;
		five.random = two;
		
		node = one;
	}
	
	public void display(Node node)
	{
		Node temp = node;
		while(temp != null)
		{
			System.out.print(temp.getData()+" --> ");
			temp = temp.next;
		}
		System.out.println();
		temp = node;
		while(temp != null)
		{
			System.out.print(temp.random.getData()+"     ");
			temp = temp.next;
		}
		System.out.println("\n");
	}
	
	public void cloneNode() //without changing the structure but using hashmap
	{
		/*THIS METHOD WILL FAIL
		 * 
		 * Node x = null, xpointer = null;
		Node temp = node;
		boolean flag = true;
		
		while(temp != null)
		{
			x = new Node(temp.getData(),temp.next,temp.random);
			temp = temp.next;
			if(flag)
			{
				xpointer = x;
				flag = false;
			}
		}
		
		temp = node;
		temp.next.next = null;
		display(xpointer);*/
		
		Map<Node, Node> hashmap = new HashMap<Node, Node>();
		Node temp = node;
		
		while(temp != null)
		{
			Node x = new Node(temp.getData(),null,null);
			hashmap.put(temp, x);
			temp = temp.next;
		}
		
		temp = node;
		Node cloneHead = null;
		while(temp != null)
		{
			Node x = hashmap.get(temp);
			x.next = hashmap.get(temp.next);
			x.random = hashmap.get(temp.random);
			temp = temp.next;
			if(cloneHead == null)
			{
				cloneHead = x;
			}
		}
		display(node);
		display(cloneHead);
	}
	
	public void cloneNodeAnother()//changing the structure but without using hashmap and better complexity
	{
		Node temp = node;
		while(temp != null)
		{
			Node x = new Node(temp.getData(),temp.next,temp.random);
			Node y = temp.next;
			
			temp.next = x;
			temp = y;
		}
		temp = node;
		
		/*while(temp != null) //THis part is not required
		{
			if(temp.random != null)
			{
				temp.next.random = temp.random.next;
			}

			temp = temp.next.next;
		}*/
		
		Node originalNode = node;
		Node cloneNode = node.next;
		Node cloNodePointer = cloneNode;
		while(originalNode.next != null || cloneNode.next != null)
		{
			Node x = cloneNode.next;
			originalNode.next = x;
			
			if(x == null)
				break;
			
			Node y = x.next;
			cloneNode.next = y;
			
			originalNode = x;
			cloneNode = y;
		}
		originalNode.next = null;
		cloneNode.next = null;
		
		display(node);
		display(cloNodePointer);
		
		node.next.next.next = null;
				
		display(node);
		display(cloNodePointer);
	}
}

class P28
{
	public static void main(String[] args) 
	{
		LinkedList l = new LinkedList();
		l.createNode();
		l.display(l.node);
		
		l.cloneNode();
		//l.cloneNodeAnother();
	}
}

/*
 * 
 */
