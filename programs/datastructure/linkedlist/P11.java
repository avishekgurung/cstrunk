class Node
{
	String data;
	Node next;
	
	Node(String data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public String getData()
	{
		return data;
	}
}

class LinkedList
{
	Node node;
	
	//insert
	public void insert(String data)
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
			pointer.next = new Node(data,null);
		}
	}
	
	//display
	public void display()
	{
		Node pointer = node;
		if(node == null)
		{
			System.out.println("List is Empty");
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
	
	//reverse
	public void reverse()
	{
		Node current_pointer = node; //current pointer
		Node prev_pointer = null;
		Node next_pointer = null;
		
		while(current_pointer != null)
		{
			next_pointer = current_pointer.next;
			current_pointer.next = prev_pointer;
			prev_pointer = current_pointer;
			current_pointer = next_pointer;
		}
		node = prev_pointer; // So on following the above operation we get datas as E --> D -- > C ... So we just pointer our node which is our head pointer to it
	}
	
	//reverse by using recursive
	
	public void callRecursiveFunction()
	{
		node =  recursiveReverse(node);
	}
}

public class P11
{
	public static void main(String[] args) {
		LinkedList ll =  new LinkedList();
		ll.insert("A");
		ll.insert("B");
		ll.insert("C");
		ll.insert("D");
		ll.insert("E");
		
		ll.display();
		ll.reverse();
		ll.display();
	}
}
