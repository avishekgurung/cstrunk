import java.util.Map;
import java.util.HashMap;

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
			pointer.next =  new Node(data, null);
		}	
	}
	
	public void display()
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
	
	public void checkDuplicates()
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		Node pointer = node;
		while(pointer != null){
			if(map.containsKey(pointer.getData())){
				System.out.println("Has Duplicates");
				return;
			}
			map.put(pointer.getData(),0);
			pointer = pointer.next;
		}
		System.out.println("Has NO Duplicates");
	}
}

class P23
{
	public static void main(String[] args) 
	{
		LinkedList l =  new LinkedList();
		
		l.insert("A");
		l.insert("B");
		l.insert("C");
		l.insert("D");
		l.insert("E");
		l.insert("M");
		l.insert("F");
		l.insert("V");
		l.insert("N");
		l.insert("K");
		l.insert("A");
		l.insert("Z");
		
		
		
		l.display();
		l.checkDuplicates();
	}
}

/*Simply put the elements in the Map and check
*/
