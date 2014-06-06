class Heap
{
	int count;
	int capacity;
	int[] array;
	
	public Heap()
	{
		count = 0;
		capacity = 18;
		array = new int[capacity];
	}
	
	public int leftChild(int i)
	{
		int x = 2*i + 1;
		if(x >= count)
			return -1;
		else
			return x;
	}
	
	public int righChild(int i)
	{
		int x = 2*i + 2;
		if(x >= count)
			return -1;
		else
			return x;
	}
	
	public void insert(int data)
	{
		int i = count;
		
		while(i >0 && data > array[(i-1)/2])
		{
			array[i] = array[(i-1)/2];
			i = (i-1)/2;
		}
		
		array[i] = data;
		count++;
		
		/*
		 * This is a max heap, so we always need to put the largest element at the top. 
		 * So we start from the last element of the array and start going to its parent by keeping a condition that "data" must be greater than its parent (i-1/2)
		 * Trace the program for better understanding
		 */
	}
	
	public int delete()
	{
		int val = array[0]; 
		array[0] = array[count-1]; //make the first element as the last
		count--;
		
		percolateDown(0); //now start percolating this last element, down the heap to find an appropiate position to insert it
		return val;
	}
	
	public void percolateDown(int i)
	{
		int left = leftChild(i);
		int right = righChild(i);
		int max;
		
		if(left == -1 && right == -1)
			return;
		
		if(left != -1 && array[left] > array[i]) //out of root,left and right, find the max and replace element in i with maximum element
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
	
	public void display()
	{
		for(int i=0;i<count;i++)
			System.out.print(array[i]+"\t");
		System.out.println();
	}
	
	public boolean isEmpty()
	{
		if(count ==0)
			return true;
		else
			return false;
	}
	
	//heapsort is a process that will give us a sorted array. Sometimes when we have restrictions on the space or any sorting related problems we can use
	// heapsort. The time complexity is O(nlogn) and space complexity = O(1) as we are not using any space, just swapping the space array elements
	public int[] heapsort()
	{
		int backup = count;
		for(int i=0;i<backup;i++)
		{
			int temp = array[0];
			array[0] = array[count-1];
			percolateDown(0);
			array[count-1] = temp;
			count--;
		}
		count = backup;
		return array;
	}
	
	/*Once we do heapsort, we see that the array element's position gets changed permanently. So if we add any new element to the heap after heapsort
	 * the heap property will not be satisfied. Hence to retain the heap property and also to return sorted array, we do heapsort1, which will create 
	 * an extra array which is a duplicate of original array and do the heapsort on that array. So our original array is not changed. So when this new
	 * array calls percolateDown function, it should use the new array, hence we need some change in percolate function two. So using of new array leads
	 * to O(n) space complexity.
	 */
	
	
	public int[] heapsort1()
	{
		int backup = count;
		int temp_array[] = new int[count];
		for(int i=0;i<count;i++)
			temp_array[i] = array[i];
		
		for(int i=0;i<backup;i++)
		{
			int temp = temp_array[0]; 
			temp_array[0] = temp_array[count-1];
			percolateDown1(0,temp_array);
			temp_array[count-1] = temp;
			count--;
		}
		count = backup;
		return temp_array;
	}
	
	
	public void percolateDown1(int i,int[] temp_array)
	{
		int left = leftChild(i);
		int right = righChild(i);
		int max;
		
		if(left == -1 && right == -1)
			return;
		
		if(left != -1 && temp_array[left] > temp_array[i])
			max = left;
		else 
			max = i;
		
		if(right != -1 && temp_array[right] > temp_array[max])
			max = right;
		
		if(max != i)
		{
			int temp = temp_array[max];
			temp_array[max] = temp_array[i];
			temp_array[i] = temp;
		}
		
		if(max == i)
			return;
		percolateDown1(max,temp_array);		
	}
}

class MaxHeap
{
	public static void main(String[] args) 
	{
		Heap h = new Heap();
		h.insert(23);
		h.insert(20);
		h.insert(25);
		h.insert(18);
		h.insert(29);
		h.insert(31);
		h.insert(26);
		h.insert(14);
		h.insert(17);
		
		h.display();
	
		/*while(!h.isEmpty())
			System.out.println("Deleting "+h.delete());*/
		
		int temp[] = h.heapsort();
		for(int i=0;i<temp.length;i++)
			System.out.print(temp[i]+"\t");
		System.out.println();
		

	}
}