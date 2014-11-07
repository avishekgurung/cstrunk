import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

class Node{
	int index;
	Node prev;
	Node next;

	Node(Node prev, int index, Node next){
		this.prev = prev;
		this.index = index;
		this.next = next;
	}

	public int getIndex(){
		return index;
	}
}

class Queue{
	Node node;

	public void add(int index){
		if(node == null){
			node = new Node(null,index,null);
		}
		else{
			Node temp = new Node(null,index,node);
			node.prev = temp;
			node = temp;
		}
	}

	public void removeHead(){
		Node pointer = node;
		while(pointer.next != null){
			pointer = pointer.next;
		}
		Node temp = pointer.prev;
		temp.next = null;
	}

	public void remove(int index){

		if(node.getIndex() == index){
			return;
		}

		Node pointer = node;
		while(pointer != null){
			if(pointer.getIndex() == index){
				break;
			}
			pointer = pointer.next;
		}

		if(pointer.getIndex() == index){
			removeHead();
			return;
		}


		Node x = pointer.prev;
		Node y = pointer.next;

		x.next = y;
		y.prev = x;
	}
}

class Cache{
	int cacheSize;
	Map<Integer,String> map;
	Queue queue;
	int count;

	Cache(){
		cacheSize = 5;
		map = new HashMap<Integer,String>();
		queue = new Queue();
		count = 0;
	}

	public void use(String data){
		int index = getPageNumber(data);
		if(map.containsKey(index)){
			queue.remove(index);
			queue.add(index);
		}
		else{
			if(count < cacheSize){
				map.put(index,data);
				queue.add(index);
				count++;
			}
			else{
				queue.removeHead();
				map.remove(index);
				queue.add(index);
				map.put(index,data);
			}
		}

	}

	public int getPageNumber(String data){
		return Math.abs(data.hashCode());
	}

	public void cacheContents(){
		System.out.println("\n----------------------------CACHE-------------------------");
		Node pointer = queue.node;
		while(pointer != null){
			int index = pointer.getIndex();
			System.out.println(map.get(index));
			pointer = pointer.next;
		}
		System.out.println("-------------------------------------------------------------\n");
	}
}

class P7{
	public static void main(String args[]) throws IOException {
		Cache cache = new Cache();
		cache.use("Avishek Gurung");
		cache.use("Samanta Reddy");
		cache.use("Dino Moreo");

		cache.cacheContents();

		cache.use("sandhya Gurung");
		cache.cacheContents();
		cache.use("Bidhya Gurung");
		cache.cacheContents();

		cache.use("Avishek Gurung");
		cache.use("Bhim Prasad Gurung");
		cache.cacheContents();
		//cache.use("");
	}
}

/*

Implementations:

We use Queue and Map to implement Cache.

How cache works:
1. If the cache is not full then whenever a data is added, the cache should be able to hold it.
2. If the new data is added and the cache is full then the oldest (the one of all that is not used) is to be removed.
3. If the data used contains in the cache, then it will the latest one used.

We use Map to just store the information.
The value will be the information to be stored and key will be the identification of this value.
Assuming all the information is different from one another, we use hashCode as the key.

Now queue plays an important part.
Queue stores all identification number, like the pageNumber or the index given by hashCode.

Logic:

Whenever, we use a data that is aleady present in the queue, we remove that data from the position where it is
and add it to the last as it is the latest used data.

Whenever we use a new data and the cache is not full, then we add that data at the end and add it a map too.

** Whenver we use a new data and the cache is full, the we remove the oldest used data (which is present)
in the head of the queue. Remove it from map too and then insert this new data.

We use double linked list to implement queue, as it becomes easy to delete nodes in the middle.

*/
