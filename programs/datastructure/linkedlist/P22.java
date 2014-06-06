class Node
{
	int data;
	Node next;
	Node prev;
	
	Node(Node prev,int data, Node next)
	{
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public int getData()
	{
		return data;
	}
}

class DoublyLinkedList
{
	Node node;
	Node pointer =  node;
	
	//insertion at last
	public void insert(int data)
	{
		Node pointer = node;
		if(node == null)
		{
			node = new Node(null,data,null);
		}
		else
		{
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			
			pointer.next =  new Node(pointer,data,null);
		}
	}
	
	//normal display
	public void display()
	{
		Node pointer  = node;
		while(pointer != null)
		{
			System.out.print(pointer.getData()+" --> ");
			pointer = pointer.next;
		}
		System.out.println();
	}
	
	public void sequence()
	{
		Node pointer = node;
		boolean flag  = false;
		
		while(pointer.next != null)
		{
			pointer = pointer.next;
		}
		
		Node last = pointer;
		Node end = last;
		pointer = node;
		
		while(pointer.next != end) //if we make pointer.next != null it will result in infinite loop as the node 3 will keep on appending on the end
		{
			if(pointer.getData() == 1 && flag)
			{
				Node x = pointer.prev;
				Node y = pointer.next;
				Node z = pointer;
				
				//removing node with 1
				x.next = y;
				y.prev = x;
				
				//this step should not be added at the end because an infinite loop will result
				pointer = pointer.next;
				
				//putting the deleted node to the beginning
				z.prev = null;
				z.next = node;
				node.prev = z;
				node = z;
			}
			else if(pointer.getData() == 3)
			{
				Node x = pointer.prev;
				Node y = pointer.next;
				Node z = pointer;
				
				x.next = y;
				y.prev = x;
				
				pointer = pointer.next;
				
				last.next = z;
				z.prev = last;
				z.next = null;
				last = z;
			}
			else
			{
				pointer = pointer.next;
			}
			flag = true;
		}
		
		//Now if the end node is 1 then the above logic will not work as we are iterating before end, hence one more additional step
		if(end.getData() == 1)
		{
			Node x = end.prev;
			Node y = end.next;
			Node z = end;
			
			//removing node with 1
			x.next = y;
			y.prev = x;
			
			
			//putting the deleted node to the beginning
			z.prev = null;
			z.next = node;
			node.prev = z;
			node = z;
		}
		
	}
}

class P22
{
	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.insert(1);
		dl.insert(3);
		dl.insert(2);
		dl.insert(1);
		dl.insert(2);
		dl.insert(2);
		dl.insert(1);
		dl.insert(3);
		dl.insert(1);
		dl.insert(3);
		dl.insert(1);
		dl.insert(3);
		dl.insert(2);
		dl.insert(1);

		dl.display();
		dl.sequence();
		dl.display();
		//dl.display();

	}
}


/*
 * The only thing needed here is take a good precaution step
 * Algo
 * 1. Move all the 1s before the head node
 * 2. Move all the 3s after the last node
 * 3. For 2s do nothing
 * 
 * Things to keep in mind
 * 1. If the first node encountered is 1 then we do nothing and we simply traverse
 * 2. Assigning and removing elements should be taken outmost care as this may result in infinite loop
 */
