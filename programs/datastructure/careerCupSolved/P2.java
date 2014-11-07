import java.util.Stack;

class DoubleLinkedList{
	Stack<Integer> s;
	Stack<Integer> t;
	int count;
	DoubleLinkedList(){
		s = new Stack<Integer>();
		t = new Stack<Integer>();
		count = 0;
	}

	public void insertInBeginning(int data){
		while(!s.isEmpty()){
			t.push(s.pop());
		}
		s.push(data);
		count++;
	}

	public void insertAtEnd(int data){
		while(!t.isEmpty()){
			s.push(t.pop());
		}
		t.push(data);
		count++;
	}

	public void moveForward(){
		while(!t.isEmpty()){
			int temp = t.pop();
			System.out.println(temp);
			s.push(temp);
		}
	}

	public void moveBackward(){
		while(!s.isEmpty()){
			int temp = s.pop();
			System.out.println(temp);
			t.push(temp);
		}
	}

	public void delete(int data){
		while(!s.isEmpty()){
			t.push(s.pop());
		}
		while(!t.isEmpty()){
			if(t.peek() == data){
				t.pop();
				return;
			}
			else{
				s.push(t.pop());
			}
		}
	}

	public void deleteFirst(){
		while(!s.isEmpty()){
			int temp = s.pop();
			if(s.peek() == null){
				return;
			}
			t.push(temp);
		}
	}

	public void deleteLast(){
		while(!t.isEmpty()){
			int temp = t.pop();
			if(t.peek() == null){
				return;
			}
			s.push(temp);
		}
	}
}

class P2{
	public static void main(String args[]){
		DoubleLinkedList list = new DoubleLinkedList();
		list.insertInBeginning(4);
		list.insertInBeginning(3);
		list.insertInBeginning(2);
		list.insertInBeginning(1);

		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);

		list.moveBackward();
		list.moveForward();

		list.delete(5);

		list.moveBackward();
		list.moveForward();

	}
}

/*Logic
Imagine all items are organized into two stacks, draw them facing each other where face is where you put and peek:

1,2,3,4-><-5,6,7,8 
now you can move 4 to 5: 
1,2,3-><-4,5,6,7,8 
and 3 to 4: 
1,2-><-3,4,5,6,7,8 
and you can go backwards

So we can imagine two stacks, storing data as follows

S 		T
4		5
3		6
2		7
1*/