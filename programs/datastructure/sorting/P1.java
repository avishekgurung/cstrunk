class P1
{
	public static void main(String[] args) 
	{
		//given array
		int arr[] = {5,1,4,2,6,9,0,3,7,2,11,19,14};
		
		//We will solve this problem in two ways calculating the time and space complexity
		
		boolean flag = false;
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i] == arr[j])
					flag = true;
			}
		}
		
		if(flag)
			System.out.println("Duplicate Present");
		else
			System.out.println("Duplicate Not present");
		//Space complexity = O(1)
		//Time complexity = O(n2)
		
		flag = false;
		
		//lets do heapsort
		Heap h = new Heap(arr);
		h.heapSort();
		for(int i=0;i<arr.length-1;i++)
			if(arr[i] == arr[i+1])
				flag = true;
		
		if(flag)
			System.out.println("Duplicate Present");
		else
			System.out.println("Duplicate Not present");
		
		//we are not using any extra space. so space complexity =  O(1) and 
		//time complexity = n * logn  . We use while loop for n no of times and logn is used for deletion Hence O(nlogn) 
	}
}

class Heap
{
	int count;
	int capacity;
	int array[];

	public Heap(int [] array)
	{
		count = 0;
		this.array = array;
		for(int i=0;i<array.length;i++)
		{
			insert(array[i]);
		}
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

	public void insert(int data)
	{
		int i = count;
		while( i > 0 && data > array[(i-1)/2] )
		{
			array[i] = array[(i-1)/2];
			i = (i-1)/2;
		}
		array[i] = data;
		count++;
	}

	public void heapSort()
	{
		for (int i=0;i<array.length;i++)
		{
			int temp = array[0];
			array[0] = array[count-1];
			percolateDown(0);
			array[count-1] = temp;
			count--;
		}
	}

	public void percolateDown(int i)
	{
		int left = leftChild(i);
		int right = rightChild(i);
		if(left == -1 && right == -1)
			return;
		int max;

		if(left != -1 && array[left] > array[i])
			max = left;
		else
			max = i;

		if(right != -1 && array[right] > array[max])
			max = right;

		if(max != i)
		{
			int temp = array[max];
			array[max] = array[i];
			array[i] = temp;
		}

		if(max == i)
			return;
		percolateDown(max);
	}
}


