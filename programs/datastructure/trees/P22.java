import java.util.LinkedList;
import java.util.Queue;
class Node
{
	Node firstChild;
	int data;
	Node nextSibling;
	
	Node(Node firstChild,int data, Node nextSibling)
	{
		this.firstChild = firstChild;
		this.data = data;
		this.nextSibling = nextSibling;
	}
	
	public int getData()
	{
		return data;
	}
}

class GenericTree
{
	Node node;
	public void createGenericTree() //The tree is generated as in page 135 of Narasimha Karumanchi book
    {
            Node one = new Node(null,1,null);
            Node two= new Node(null,2,null);
            Node three = new Node(null,3,null);
            Node four = new Node(null,4,null);
            Node five = new Node(null,5,null);
            Node six = new Node(null,6,null);
            Node seven = new Node(null,7,null);
            Node eight = new Node(null,8,null);
            Node nine = new Node(null,9,null);
            Node ten = new Node(null,10,null);
            Node oneone = new Node(null,11,null);
            Node onetwo = new Node(null,12,null);
            Node onethree = new Node(null,13,null);
            Node onefour = new Node(null,14,null);
            Node onefive = new Node(null,15,null);
            //Node onesix = new Node(null,16,null);

            one.firstChild = two;
            two.nextSibling = three;
            three.nextSibling = four;
            four.nextSibling = five;
            five.nextSibling = six;
            four.firstChild = seven;
            seven.nextSibling = eight;
            eight.nextSibling = nine;
            nine.nextSibling = ten;
            seven.firstChild = onethree;
            onethree.nextSibling = onefour;
            nine.firstChild = onefive;
            six.firstChild = oneone;
            oneone.nextSibling = onetwo;

            node = one;
    }
	
	/*public void display()
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(temp == null)
			{
				if(!q.isEmpty())
					q.add(null);
				System.out.println();
			}
			else
			{
				System.out.print(temp.getData()+" --> ");
				
				if(temp.firstChild != null)
					q.add(temp.firstChild);
				while(temp.nextSibling != null)
					q.add(temp.nextSibling);
			}
		}
	}*/
	
	public int sum(Node node)
	{
		if(node == null)
			return 0;
		int left = sum(node.firstChild);
		int right = sum(node.nextSibling);
		int data = node.getData();
		return left + data + right;
	}
	
	public int countSiblings(Node node)
	{
		int count = 0;
		while(node.nextSibling != null)
		{
			count++;
			node = node.nextSibling;
		}
		return count;
	}
	
	public int countChildren(Node node)
	{
		int count = 0;
		if(node.firstChild != null)
		{
			count++;
			node = node.firstChild;
			while(node.nextSibling != null)
			{
				count++;
				node = node.nextSibling;
			}
		}
		return count;
	}
}

class P22
{
	public static void main(String[] args) {
		GenericTree t = new GenericTree();
		t.createGenericTree();
		Node node = t.node;
		Node two = node.firstChild;
		System.out.println("Sum "+t.sum(node));
		System.out.println("Siblings "+t.countSiblings(two));
		System.out.println("Children "+t.countChildren(node));
	}
}














