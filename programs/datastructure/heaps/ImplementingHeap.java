class Heap
{
	int count;
	int capacity;
	int array[];
	int heap_type;
	
	public Heap(int capacity, int heap_type)
	{
		this.capacity = capacity;
		this.heap_type = heap_type;
		array = new int[capacity];
		count = 0;
	}
	
	public int parent(int i)
	{
		int par =  (i-1)/2;
		if(par < 0)
			par = -1;
		return par;
	}
	
	public int leftChild(int i)
	{
		int left = (2*i)+1;
		if(left >= count)
			return -1;
		else
			return left;
	}
	
	public int rightChild(int i)
	{
		int right = (2*i)+2;
		if(right >= count)
			return -1;
		else
			return right; 
	}
	
	public int getMax()
	{
		return array[0];
	}
	
	public void percolateDown(int i)
	{
		int left, right, max, temp;
		left = leftChild(i);
		right = rightChild(i);
		if(left == -1 && right == -1)
		{
				return;
		}
		if(left != -1 && array[left] > array[i])
			max = left;
		else 
			max = i;
		
		if(right != -1 && array[right] > array[max])
			max = right;
		
		if(max != i)
		{
			temp = array[i];
			array[i] = array[max];
			array[max] = temp;
		}
		
		if(max == i)
			return;
		percolateDown(max);
	}
	
	public void insert(int data)
	{
		/*array[count] = data;
		count++;*/
		
		if(count ==  capacity)
			resizeHeap();
		//System.out.println("s");	
		count++;
		int i = count-1;
		//System.out.println("i "+i+" count "+count);
		while(i > 0 && data > array[(i-1)/2])
		{
			array[i] = array[(i-1)/2];
			i = (i-1)/2;
		}
		
		array[i] = data;
	}
	
	public void resizeHeap()
	{
		capacity = capacity * 2;
		int temp[] = new int[capacity];
		for(int i=0;i<=count;i++)
		{
			temp[i] = array[i];
		}
		array = temp;
	}
	
	public void display()
	{
		for(int i=0;i<count;i++)
			System.out.print(array[i]+"\t");
		System.out.println();
	}
	
	public void delete()
	{
		if(count == 0)
		{
			System.out.println("Heap is empty");
			return;
		}
		int temp = array[0];
		array[0] = array[count-1];
		count--;
		percolateDown(0);
		display();
	}
}

class ImplementingHeap
{
	public static void main(String[] args) 
	{
		Heap heap = new Heap(12, 1);
		heap.insert(17);
		heap.insert(13);
		heap.insert(6);
		heap.insert(1);
		heap.insert(4);
		heap.insert(2);
		heap.insert(15);
		
		int ar[] = heap.array;
		System.out.println();
		for(int i=0;i<ar.length;i++)
			System.out.print(ar[i]+"\t");
		System.out.println();
		/*heap.insert(31);
		heap.insert(11);
		heap.insert(21);
		heap.insert(5);
		heap.insert(10);
		heap.insert(12);
		heap.insert(18);
		heap.insert(3);
		heap.insert(2);
		heap.insert(8);
		heap.insert(7);
		heap.display();*/
		heap.display();
		//heap.delete();
	}
}













