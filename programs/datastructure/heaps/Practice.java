import java.util.concurrent.Delayed;

class Heap
{
	int count;
	int capacity;
	int arr[];
	
	public Heap()
	{
		count = 0;
		capacity = 8;
		arr = new int[capacity];
	}
	
	public void insert(int data)
	{
		int i = count;
		while(i > 0 && data > arr[(i-1)/2])
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
		int newSize = capacity + (int)(capacity * 0.75);
		int newArr[] = new int[newSize];
		
		for(int i=0;i<count;i++)
			newArr[i] = arr[i];
		
		arr = newArr;
		capacity = newSize;
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
		int max;
		
		if(left == -1 && right == -1)
			return;
		
		if(left != -1 && arr[left] > arr[i])
			max = left;
		else 
			max = i;
		
		if(right != -1 && arr[right] > arr[max])
			max = right;
		
		if(max != i)
		{
			int temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
		}
		
		if(max == i)
			return;
		
		percolateDown(max);
	}
	
	public int delete()
	{
		int val = arr[0];
		arr[0] = arr[count-1];
		percolateDown(0);
		count--;
		return val;
	}
	
	public void display()
	{
		System.out.println();
		System.out.println("Count: "+count);
		System.out.println("Capacity: "+capacity);
		System.out.println();
		for(int i=0;i<count;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
	
	public void heapsort()
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
	
	public void deleteAny(int element)
	{
		int index = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] == element)
			{
				index = i;
				break;
			}
		}
		
		arr[index] = arr[count-1];
		percolateDown(index);
		count--;
	}
	
	public void test(int x)
	{
		int temp = arr[0];
		arr[0] = x;
		arr[count-1] = temp;
		percolateDown(0);
		count++;
	}
}

class Practice
{
	public static void main(String[] args) 
	{
		Heap heap = new Heap();
		
		heap.insert(20);
		heap.insert(14);
		heap.insert(32);
		heap.insert(19);
		heap.insert(24);
		heap.insert(25);
		heap.insert(12);
		heap.insert(28);
		heap.insert(30);
		
		heap.display();
		System.out.println();
		
		//heap.deleteAny(19);
		
		heap.test(27);
		
		heap.display();
		System.out.println();
		
		/*while(heap.count > 0)
			System.out.println(heap.delete());*/
		
		heap.heapsort();
		heap.display();
	}
}