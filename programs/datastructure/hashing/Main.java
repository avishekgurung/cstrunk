class Node
{
	int key;
	String value;
	Node next;
	
	public Node(int key, String value, Node next)
	{
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	public int getKey()
	{
		return key;
	}
	
	public String getValue()
	{
		return value;
	}
}

class HashTable
{
	Node[] array;
	int capacity;
	int count;
	float loadFactor = 0.75f;
	
	public HashTable()
	{
		capacity = 8;
		count = 0;
		array = new Node[capacity];
		
		for(int i=0;i<capacity;i++) //setting all the table values to null before inserting any node in it
		{
			array[i] = null;
		}
	}
	
	public int hashFunction(int key)
	{
		Integer x = key; //need to do the wrapping as hashCode method is not available for primitive data types
		int index = Math.abs(x.hashCode() % capacity); //We use hashCode method for our hash Function.Math.abs is used to return only +ve no, 
														//as sometimes hashCode can return -ve values too
		return index;
	}
	
	public void put(int key, String value)
	{
		int index = hashFunction(key);
		Node pointer = array[index];
		
		if(search(key)) 
		{
			//if the key already exists, then we will simply replace its value as duplicate keys cannot be allowed. 
			//And some flexibility Should be there to change values too. Hence we do search
			while(pointer != null)
			{
				if(pointer.getKey() == key)
				{
					pointer.value = value;
					return;
				}
				pointer = pointer.next;
			}
		}
		else
		{
			//Insertion will always be done in the beginning of the linked list as they will make our complexity to O(1)
			if(pointer == null)
			{
				array[index] = new Node(key, value, null);
			}
			else
			{
				pointer = new Node(key, value, array[index]);
				array[index] = pointer;
			}
		}
		
		count++;
		if(count > loadFactor * capacity) //increasing the array dynamically 
		{
			resize();
		}
	}
	
	public void resize()
	{
		//System.out.println("Called Resize");
		int newSize = (int) (loadFactor * capacity) + capacity; //the new table will be 75% longer than the old one
		Node[] newArray = new Node[newSize];
		
		for(int i=0;i<newSize;i++) //like before, we ll keep all the new array values to null before adding any node to them
		{
			newArray[i] = null;
		}
		
		for(int i=0;i<capacity;i++) //simply copying the nodes values from old to new array
		{
			newArray[i] = array[i];
		}
		
		capacity = newSize; //resizing the capacity
		array = newArray;
	}
	
	public boolean search(int key) //verr simple linked list traversal and search. But since most of the array location will have only one node hence O(1)
	{
		int index = hashFunction(key);
		Node pointer = array[index];
		while(pointer != null) 
		{
			if(pointer.getKey() == key)
			{
				return true;
			}
			pointer = pointer.next;
		}
		return false;
	}
	
	public String remove(int key)
	{
		//Element can be deleted only if it is present so lets search first
		if(!search(key))
		{
			return null;
		}
		else
		{ //We are sure that element is present
			int index = hashFunction(key);
			Node pointer = array[index];
			String value="";
			if(pointer.getKey() == key) //if the element to be deleted is first
			{
				value = pointer.getValue();
				array[index] = pointer.next;
				count--;
			}
			else //deleting other elements
			{
				while(pointer.next != null)
				{
					if(pointer.next.getKey() == key)
					{
						value = pointer.next.getValue();
						pointer.next = pointer.next.next;
						break;
					}
					pointer = pointer.next;
				}
				count--;
			}
			return value;
		}
	}
	
	public String get(int key)
	{
		int index = hashFunction(key);
		Node pointer = array[index];
		if(pointer != null)
		{
			while(pointer != null)
			{
				if(pointer.getKey() == key)
				{
					return pointer.getValue();
				}
				pointer = pointer.next;
			}
		}
		return null;
	}
	
	public boolean isEmpty()
	{
		if(count == 0)
			return true;
		else
			return false;
	}
	
	public void tableInfo()
	{
		System.out.println("\n\n************* TABLE INFO ************");
		System.out.println("Count(No of elements)   = "+count);
		System.out.println("Capacity(Size of table) = "+capacity);
		System.out.println("\nindex\t Key:Value");
		for(int i=0;i<capacity;i++)
		{
			Node pointer = array[i];
			System.out.print(i+"\t");
			while(pointer != null)
			{
				System.out.print(" "+pointer.getKey()+":"+pointer.getValue()+" --> ");
				pointer = pointer.next;
			}
			System.out.println();
		}
	}
}

class Main
{
	public static void main(String[] args) 
	{
		HashTable table = new HashTable();
		table.put(1, "avishek");
		table.put(2, "nitisha");
		table.put(3, "ranjan");
		table.put(4, "sovit");
		table.put(7, "sumit");
		table.put(6, "rohan");
		table.put(0, "Dinesh");
		table.put(8, "Munal");
		table.put(1, "Subhash");
		table.put(24, "Ritwik");
		table.put(14, "Biplov");
		
		//table.put	(, "");
		int search = 6;
		int remove = 1;
		int get = 1;
		
		System.out.println();
		System.out.println("Search "+search+"\t Result: "+table.search(search));
		System.out.println("Remove "+remove+"\t Result: "+table.remove(remove));
		System.out.println("Get of "+get+"\t Result: "+table.get(get));
		System.out.println("Empty \t\t Result: "+table.isEmpty());
		table.tableInfo();
	}
}