class Heap
{
	int count;
	int capacity;
	int[] array;
	
	public Heap()
	{
		count = 0;
		capacity = 20;
		array = new int[capacity];
	}
	
	public int leftChild(int i)
	{
		int left = 2*i + 1;
		if(left >= count)
			return -1;
		else
			return left;
	}
	
	public int rightChild(int i)
	{
		int right = 2 * 1 + 2;
		if(right >= count)
			return -1;
		else
			return right;
	}
	
	public void insert(int data)
	{
		/*int i = count;
		
		while(i > 0 && data < array[(i-1)/2])
		{
			array[i] = array[(i-1)/2];
			i = (i-1)/2;
		}
		
		array[i] = data;*/
		array[count] = data;
		percolateDown(count);
		count++;
	}
	
	public void display()
	{
		for(int i=0;i<count;i++)
			System.out.print(array[i]+"\t");
		System.out.println();
	}
	
	public void percolateDown(int i)
	{
		int left = leftChild(i);
		int right = rightChild(i);
		
		if(left == -1 && right == -1)
			return;
		
		int min;
		if(array[left] < array[i])
			min = left;
		else
			min = i;
		
		if(array[right] < array[min])
			min = right;
		
		if(min != i)
		{
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
		
		if(min == i)
			return;
		
		percolateDown(min);
	}
}

class MinHeap
{
	public static void main(String[] args) 
	{
		Heap h = new Heap();
		h.insert(20);
		h.insert(30);
		h.insert(15);
		h.insert(10);
		h.insert(18);
		h.display();
	}
}