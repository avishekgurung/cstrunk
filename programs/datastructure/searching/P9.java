class P9
{
	public static void main(String[] args) 
	{
		//int arr[] = {1,3,5,6,7,9};
		int arr[] = {9,6,3,5,1,7};
		int k = 20;
		
		Heap heap = new Heap(arr);
		heap.heapSort();
		
		for(int i=0;i<arr.length-1;i++)
		{
			int left = i+1;
			int right = arr.length-1;
			
			while(left < right)
			{
				int sum = arr[i] + arr[left] + arr[right];
				if(sum == k)
				{
					System.out.println(arr[i]+"\t"+arr[left]+"\t"+arr[right]);
					return;
				}
				if(sum > k)
					right--;
				else
					left++;
			}
		}
	}
}

/*
 * Time Complexity = nlogn for HeapSort and n2 for two loops , therefor TC =  O(n2)
 * Space Complexity = O(1)
 */

class Heap
{
	int count;
	int capacity;
	int arr[];
	
	Heap(int [] arr)
	{
		count = 0;
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