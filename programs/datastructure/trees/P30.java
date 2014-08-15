class Node{
	int data;
	Node next;
	Node prev;

	Node(Node prev, int data, Node next){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public int getData(){
		return data;
	}
}


class LinkedList{
	Node node;

	public void insert(int data){
		if(node == null){
			node = new Node(null,data,null);
		}
		else{
			Node pointer = node;
			while(pointer.next != null){
				pointer = pointer.next;
			}
			pointer.next = new Node(pointer,data,null);
		}
	}

	public void display(){
		Node p1 = node;
		Node p2 = null;

		while(p1 != null){
			System.out.print(p1.getData()+" -> ");
			if(p1.next == null){
				p2 = p1;
			}
			p1 = p1.next;
		}

		System.out.println();
		while(p2 != null){
			System.out.print(p2.getData()+" -> ");
			p2 = p2.prev;
		}
		System.out.println();
	}

	public Node getMid(Node node){
		if(node == null || node.next == null)
			return node;
		Node p1 = node;
		Node p2 = node.next;

		while(p2 != null){
			p1 = p1.next;
			p2 = p2.next;
			if(p2 == null)
				break;
			p2 = p2.next;
		}
		return p1;
	}

	public Node DLLtoBST(Node node){
		if(node == null || node.next == null)
			return node;
		Node mid = getMid(node);
		Node prevNode = node;
		Node nextNode = mid.next;

		while(prevNode.next != mid)
			prevNode = prevNode.next;

		//break all links
		prevNode.next = null;
		mid.prev = null;
		mid.next = null;
		nextNode.prev = null;

		mid.prev = DLLtoBST(node);
		mid.next = DLLtoBST(nextNode);
		return mid;
	}

	public void preorder(Node node){
		if(node == null)
			return;

		System.out.print(node.getData()+" -> ");
		preorder(node.prev);
		preorder(node.next);
	}
}

class P30{
	public static void main(String args[]){
		LinkedList ls = new LinkedList();
		ls.insert(1);
		ls.insert(2);
		ls.insert(3);
		ls.insert(4);
		ls.insert(5);
		ls.insert(6);
		ls.insert(7);
		Node node = ls.DLLtoBST(ls.node);
		ls.preorder(node);
		System.out.println();
	}
}
