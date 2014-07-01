class Heap
{
	int count;
	int capacity;
	int arr[];
	
	Heap()
	{
		count = 0;
		capacity = 5;
		arr = new int[capacity];
	}
	
	public void insert(int data)
	{
		int i = count;
		while(i > 0 && data < arr[(i-1)/2])
		{
			arr[i] = arr[(i-1)/2];
			i = (i-1)/2;
		}
		arr[i] = data;
		count++;
		if(count == capacity)
			resize();
	}
	
	public void resize()
	{
		capacity = capacity + 5;
		int newArr[] = new int[capacity];
		
		for(int i=0;i<count;i++)
			newArr[i] = arr[i];
		
		arr = newArr;
	}
	
	public void display()
	{
		for(int i=0;i<count;i++)
			System.out.print(arr[i]+"  ");
		System.out.println();
	}
	
	public int leftChild(int i)
	{
		int left = 2 * i + 1;
		if(left >= count)
			left = -1;
		return left;
	}
	
	public int rightChild(int i)
	{
		int right = 2 * i + 2;
		if(right >= count)
			right = -1;
		return right;
	}
	
	public void percolateDown(int i)
	{
		int left = leftChild(i);
		int right = rightChild(i);
		int min = 0;
		
		if(left == -1 && right == -1)
			return;
		
		if(left != -1 && arr[left] < arr[i])
			min = left;
		else
			min = i;
		
		if(right != -1 && arr[right] < arr[min])
			min = right;
		
		if(min != i)
		{
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
		if(min == i)
			return;
		
		percolateDown(min);
	}
	
	public void delete()
	{
		arr[0] = arr[count-1];
		percolateDown(0);
		count--;
	}
	
	public void sort()
	{
		int x = count;
		
		for(int i=0;i<x;i++)
		{
			int temp = arr[0];
			arr[0] = arr[count-1];
			percolateDown(0);
			arr[count-1] = temp;
			count--;
		}
		count = x;
	}
	
	public void deleteElement(int element)
	{
		int index = getIndex(element);
		arr[index] = arr[count-1];
		percolateDown(index);
		count--;
	}
	
	public int getIndex(int element)
	{
		for(int i=0;i<count;i++)
		{
			if(arr[i] == element)
				return i;
		}
		return -1;
	}
}

class MinHeap
{
	public static void main(String[] args) 
	{
		Heap heap =new Heap();
		heap.insert(7);
		heap.insert(10);
		heap.insert(4);
		heap.insert(2);
		heap.insert(9);
		heap.insert(8);
		heap.insert(11);
		
		
		heap.display();
		heap.sort();
		heap.display();
		//heap.deleteElement(4);
		//heap.display();
	}
}
