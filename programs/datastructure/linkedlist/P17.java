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
		if(node == null)
		{
			node = new Node(data, null);
		}
		else
		{
			Node pointer = node;
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next = new Node(data,null);
		}
	}

	public void display(Node node)
	{
		Node pointer = node;
		
		while(pointer != null)
		{
			System.out.print(pointer.getData()+" --> ");
			pointer = pointer.next;
		}
		System.out.println();
	}
	
	public void merger(Node m, Node n)
	{
		Node m_pointer = m;
		Node n_pointer = n;
		for(int i=1;i<=6;i++)
			m_pointer = m_pointer.next;
		
		while(n_pointer.next != null)
			n_pointer = n_pointer.next;
		
		n_pointer.next = m_pointer;
	}
	
	public Node intersectingNode(Node m, Node n)
	{
		int x = 0, y = 0;
		Node mp = m, np = n;
		
		while(mp != null)
		{
			x++;
			mp = mp.next;
		}
		
		while(np != null)
		{
			y++;
			np = np.next;
		}
		
		if(y > x)
		{
			Node temp = m;
			m = n;
			n =  temp;
			int t = x;
			x = y;
			y = x;
		}
		
		mp = m;
		np = n;
		int diff = x - y;
		for(int i=0;i<diff;i++)
			mp = mp.next;
		
		while(mp != np)
		{
			mp = mp.next;
			np = np.next;
		}
		
		return mp;
	}

	/*
		No of solutions.
		1. Brute Force: For every code, compare with the nodes of another linked list
		2. Use Map: Store first ll's element in map, iterate the second one and find it
		3. Use Stacks: Insert nodes in each stacks. Start popping elements from stacks, whenever the popped
		elements are different, the element popped before is the intersection
	*/
}

class P17
{
	public static void main(String[] args) 
	{
		LinkedList list1 = new LinkedList();
		list1.insert(1);
		list1.insert(2);
		list1.insert(3);
		list1.insert(4);
		list1.insert(5);
		list1.insert(6);
		list1.insert(7);
		list1.insert(8);
		list1.insert(9);
		list1.insert(10);
		Node m = list1.node;
		list1.display(m);
		
		LinkedList list2 = new LinkedList();
		list2.insert(100);
		list2.insert(200);
		list2.insert(300);
		Node n = list2.node;
		list2.display(n);
		
		list1.merger(m, n);
		
		list1.display(m);
		list1.display(n);
		
		System.out.println("The intersecting node is "+list1.intersectingNode(m, n).getData());
	}
}

/*
There are few more ways to solve this problem
1. Brute Force approach where we would compare each node of one list with all the nodes of another list taking O(mn) time
2. By using stack. We create two stacks, one for each list. Take one node at a time and compare. This takes space complexity O(m) or O(n) whichever is bigger
3. By using Hash. We put all the elements of one list in Hash. We then traverse next list and check if the element is present. THis again has time complexity = O(n) and space complexity = O(n)

The above process has time complexity = O(n) and space complexity = O(1), constant.
*/
