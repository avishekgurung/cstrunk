class Node
{
	Node next;
	String value;
	String key;
	
	Node(String key, String value, Node next)
	{
		this.key = key;
		this.value = value;
		this.next = next;
	}
}

class HashTable
{
	Node[] arr;
	int capacity;
	int count;
	
	public int hashFunction(String key)
	{
		//System.out.println("Key "+key+" HashCode "+key.hashCode()+" Index "+key.hashCode() % capacity);
		return Math.abs(key.hashCode() % capacity);
	}
	
	public HashTable()
	{
		capacity = 8;
		count = 0;
		arr = new Node[capacity];
		for(int i = 0; i < capacity; i++)
		{
			arr[i] = null;
		}
	}
	
	public void insert(String key, String value)
	{
		int index = hashFunction(key);
		Node pointer = arr[index];
		if(search(key)) //we just replace the values
		{
			while(pointer != null)
			{
				if(pointer.key == key)
				{
					pointer.value = value;
					return;
				}
			}
		}
		else
		{
			
			//System.out.println("index "+index);
			
			boolean flag = true;
			
			if(pointer == null)
			{
				pointer = new Node(key, value, null);
				arr[index] = pointer;
			}
			else
			{
				while(pointer.next != null)
				{
					if(pointer.key == key)
					{
						pointer.value = value;
						flag = false;
						break;
					}
					pointer = pointer.next;
				}
				
				if(flag == true)
				{
					pointer.next = new Node(key, value, null);
				}
			}
			
			/*int occupiedCells = 0;
			for(int i=0;i<capacity;i++)
			{
				if(arr[i] != null)
					occupiedCells++;
			}*/
			
			if(count > .75 * capacity)
			{
				System.out.println("calling resize @key "+pointer.key);
				resizeArray();
			}
			count++;
			//System.out.println("occupied cells "+occupiedCells);
			//System.out.println("count "+count+" resize "+0.75 * capacity);
			
		}
	}
	
	public void resizeArray()
	{
		int newsize = (int)(0.75*capacity+capacity);
		//System.out.println("new size "+newsize);
		
		Node newarr[] = new Node[newsize];
		for(int i = 0; i < newarr.length; i++)
		{
			newarr[i] = null;
		}
		
		
		for(int i=0;i<capacity;i++)
		{
			Node head =arr[i];
			newarr[i] = head;
		}
		
		arr = newarr;
		capacity =newarr.length;
	}
	
	
	public void tableInfo()
	{
		System.out.println("\n\n\tTABLE INFO");
		System.out.println("No of Elements(count): "+count);
		System.out.println("Size of the table(capacity): "+capacity);
		System.out.println("Elements Info");
		
		for(int i=0;i<arr.length;i++)
		{
			Node pointer = arr[i];
			System.out.print("Index "+i+" ");
			while(pointer != null)
			{
				System.out.print(pointer.key+" --> ");
				pointer = pointer.next;
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean search(String key)
	{
		for(int i = 0 ; i < arr.length; i++)
		{
			Node pointer = arr[i];
			while(pointer != null)
			{
				if(pointer.key.equals(key))
				{
					return true;
				}
				pointer = pointer.next;
			}
		}
		return false;
	}
	
	public String getValue(String key)
	{
		if(key == "" || key == null)
		{
			System.out.println("Invalid Key");
			return "";
		}
		int index = hashFunction(key); 
		String returnValue = "";
		Node pointer = arr[index];
		while(pointer != null)
		{
			if(pointer.key == key)
			{
				returnValue = pointer.value;
				break;
			}
			//System.out.println(pointer.key+" "+pointer.value);
			pointer = pointer.next;	
		}
		if(pointer == null)
			System.out.println("Invalid key");
		return returnValue;
	}
	
	public void delete(String key)
	{
		if(!search(key))
		{
			System.out.println("element not found");
			return;
		}
		else
		{
			int index = hashFunction(key);
			Node pointer = arr[index];
			if(pointer.key == key)
			{
				arr[index] = null;
			}
			else
			{
				while(pointer.next != null)
				{
					if(pointer.next.key == key)
					{
						pointer.next = pointer.next.next;
						return;
					}
					pointer = pointer.next;
				}
			}
			count--;
		}
	}
}

class MainHashTable
{
	public static void main(String[] args) {
		System.out.println("Hash Table");
		HashTable table = new HashTable();
		table.insert("a", "aabb");
		table.insert("b", "bbcc");
		table.insert("c", "ccdd");
		table.insert("d", "ddd");
		table.insert("e", "eee");
		table.insert("f", "fff");
		table.insert("g", "ggg");
		table.insert("h", "hhh");
		table.insert("i", "iii");
		table.insert("j", "jjj");
		table.insert("k", "kkk");
		table.insert("l", "lll");
		table.insert("m", "mmm");
		table.insert("n", "");
		table.insert("o", "");
		table.insert("p", "");
		table.insert("q", "");
		table.insert("r", "");
		table.insert("s", "");
		table.insert("s", "jaguar");
		/*table.insert("t", "");
		table.insert("u", "");
		table.insert("v", "");
		table.insert("w", "");
		table.insert("x", "");
		table.insert("y", "");
		table.insert("z", "");
		table.insert("", "");*/
		//table.insert("", "");
		
		System.out.println("Value of k = "+table.getValue("j"));
		System.out.println("Value of s = "+table.getValue("s"));
		System.out.println("Search l = "+table.search("k"));
		//System.out.println("Delete e ");
		//table.delete("e");
		//table.insert("e", "");
		table.tableInfo();
		
		/*Integer a = 2;
		System.out.println(a.hashCode());*/
	}
}
