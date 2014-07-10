class Node{
	int key;
	String value;
	Node next;

	Node(int key, String value, Node next){
		this.key 	= key;
		this.value 	= value;
		this.next 	= next;
	}

	public int getKey(){
		return key;
	}

	public String getValue(){
		return value;
	}
}

class HashMap{
	int count;
	int capacity;
	Node arr[];

	HashMap(){
		count 		= 0;
		capacity 	= 8;
		arr 		= new Node[capacity];

		//setting all the elements of the node array as null;
		for(int i=0;i < arr.length;i++){
			arr[i] = null;
		}
	}

	//This function will take the key as an input and return the index of an array.
	public int hashFunction(int key){
		Integer wrapper = key;
		int index 		= Math.abs(wrapper.hashCode() % capacity);
		return index;
	}

	//Collision resolved by Seperate Chaining method
	public void put(int key, String value){
		int index = hashFunction(key);
		if(arr[index] == null){
			arr[index] = new Node(key,value,null);
		}
		else{
			//Check if the key is already present. If so then just replace the value.
			Node pointer = arr[index];
			while(pointer != null){
				if(pointer.getKey() == key){
					pointer.value = value;
					return;
				}
				pointer = pointer.next;
			}
			//If the key is not present, just insert the node at the beginning.
			Node node = new Node(key,value,arr[index]);
			arr[index]= node;
		}
		count++;
		if(count >= (int)(capacity * .75)){
			resize();
		}
	}

	//Checks if the give key is present in the Hash Map
	public boolean containsKey(int key){
		int index = hashFunction(key);
		if(arr[index] != null){
			Node pointer = arr[index];
			while(pointer != null){
				if(pointer.getKey() == key){
					return true;
				}
				pointer = pointer.next;
			}
		}
		return false;
	}

	public String get(int key){
		int index = hashFunction(key);
		if(containsKey(key)){
			Node pointer = arr[index];
			while(pointer != null){
				if(pointer.getKey() == key){
					return pointer.getValue();
				}
				pointer = pointer.next;
			}
		}
		return "";
	}

	public boolean isEmpty(){
		if(count == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public void remove(int key){
		int index = hashFunction(key);
		if(containsKey(key)){
			Node pointer = arr[index];
			//if the node to be deleted is the first node
			if(pointer.getKey() == key){
				pointer = pointer.next;
				arr[index] = pointer;
				count--;
				return;
			}

			while(pointer.next != null){
				if(pointer.next.getKey() == key){
					pointer.next = pointer.next.next;
					count--;
					return;
				}
				pointer = pointer.next;
			}
		}
	}

	//very important part
	public void resize(){
		capacity = capacity + (int)(capacity * .5);
		Node newArr[] = new Node[capacity];

		//this prevents clustering and distributes data efficiently
		Node temp[] = newArr;
		newArr = arr;
		arr = temp;
		count = 0;
		for(int i=0;i<newArr.length;i++){
			Node pointer = newArr[i];
			while(pointer != null){
				int key = pointer.getKey();
				String value = pointer.getValue();
				put(key,value);
				pointer = pointer.next;
			}
		}

	}

	public void display(){
		System.out.println("\n----------------------  Hash Map Information  --------------------");
		System.out.println("Count: "+count);
		System.out.println("Capacity: "+capacity+"\n");
		for(int i=0;i<arr.length;i++){
			Node pointer = arr[i];
			System.out.print(i+": ");
			while(pointer != null){
				System.out.print(pointer.getKey()+" -> "+pointer.getValue()+"\t");
				pointer = pointer.next;
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------------------------\n");
	}
}

class HashImplementation{
	public static void main(String args[]){
		HashMap map = new HashMap();

		map.put(3,"avishek");
		map.put(8,"nitisha");
		map.put(5,"sandhya");
		map.put(18,"bidhya");
		map.put(8,"niti");
		map.put(19,"avi");
		map.put(4,"salman");
		map.put(11,"sam");
		map.put(7,"biswa");
		map.put(16,"dan");
		map.put(12,"miller");
		map.put(13,"smith");
		//map.put(,"");

		map.display();

		map.remove(11);
		map.remove(3);
		map.remove(4);
		map.remove(13);

		map.display();

		System.out.println("Search 8 "+map.containsKey(8));
		System.out.println("Get value of 8 "+map.get(8));
		System.out.println("Is empty? "+map.isEmpty());


	}
}