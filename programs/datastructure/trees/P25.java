import java.util.Queue;
import java.util.LinkedList;
class Node{
	int data;
	Node left;
	Node right;

	Node(Node left, int data, Node right){
		this.left = left;
		this.data = data;
		this.right = right;
	}

	public int getData(){
		return data;
	}
}

class Tree{
	Node node;

	public void insert_iteration(int data){
		if(node == null){
			node = new Node(null,data,null);
		}
		else{
			Node pointer = node;
			while(true){
				if(data < pointer.getData()){
					if(pointer.left == null){
						pointer.left = new Node(null,data,null);
						return;
					}
					else{
						pointer = pointer.left;
					}
				}
				else{
					if(pointer.right == null){
						pointer.right = new Node(null,data,null);
						return;
					}
					else{
						pointer = pointer.right;
					}
				}
			}
		}
	}

	public Node insert_recursion(Node node, int data){
		if(node == null){
			node = new Node(null,data,null);
			return node;
		}

		if(data < node.getData()){
			node.left = insert_recursion(node.left, data);
		}
		else{
			node.right = insert_recursion(node.right, data);
		}
		return node;
	}

	public void display(Node node)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(temp == null){
				if(!q.isEmpty()){
					q.add(null);
				}
				System.out.println();
			}
			else{

				System.out.print(temp.getData()+" ");
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
		}
	}

	public void utility(Node node, int element){
		if(node == null)
			return;
		if(element > node.getData())
			utility(node.right,element);
		else if(element < node.getData())
			utility(node.left,element);
		else{
			if(node.left != null && node.right != null){
				int x = node.right.getData();
				node.data = x;
				utility(node.right,x);
			}
			else if(node.left != null || node.right != null){
					if(node.left != null){
						int x = node.left.getData();
						node.data = x;
						utility(node.left,x);
					}
					else{
						int x = node.right.getData();
						node.data = x;
						utility(node.right,x);
					}
				}
			else{ //leaves
				node.data = -1; //meaning making it to null
			}
		}
	}
}

class P25{
	public static void main(String args[]){
		Tree tree = new Tree();
		/*tree.insert_iteration(4);
		tree.insert_iteration(2);
		tree.insert_iteration(3);
		tree.insert_iteration(1);
		tree.insert_iteration(6);
		tree.insert_iteration(5);
		tree.insert_iteration(7);

		Node node = tree.node;
		tree.display(node);*/

		Node head = tree.insert_recursion(null,4);
		tree.insert_recursion(head,6);
		tree.insert_recursion(head,2);
		//tree.insert_recursion(head,3);
		tree.insert_recursion(head,7);
		tree.insert_recursion(head,5);
		tree.insert_recursion(head,1);
		tree.insert_recursion(head,0);

		tree.display(head);

		//System.out.println(tree.utility(head));
		tree.utility(head,2);
		tree.display(head);
	}
}
