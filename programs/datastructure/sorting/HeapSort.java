class HeapSort
{
	public static void main(String[] args) 
	{
		int arr[] = {10,4,8,0,1,7,5,3,6,2,4};
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println("\n");
		
		Heap h = new Heap(arr);
		h.heapSort();
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
}

class Heap
{
	int count;
	int capacity;
	int arr[];
	
	Heap(int [] arr)
	{
		count = 0;
		/*capacity = 20;
		arr = new int[capacity];*/
		this.arr = arr;
		for(int i=0;i<arr.length;i++)
			insert(arr[i]);
	}
	
	public void insert(int data)
	{
		int i = count;
		while(i > 0 && data > arr[(i-1)/2])
		{
			arr[i] = arr[(i-1)/2];
			i = (i - 1)/2; 
		}
		arr[i] = data;
		count++;
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
	
	public int delete()
	{
		int returVal = arr[0];
		arr[0] = arr[count-1];
		percolateDown(0);
		count--;
		return returVal;
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
	
	public void heapSort()
	{
		for(int i=0;i<arr.length;i++)
		{
			int temp = arr[0];
			arr[0] = arr[count-1];
			percolateDown(0);
			arr[count-1] = temp;
			count--;
		}
	}
}

/*
 * Time Complexity = O(nlogn)
 * Space Complexity = O(1)
 */