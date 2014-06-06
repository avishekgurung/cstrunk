class P8
{
	public static void main(String[] args) 
	{
		int arr[] = {1,60,-10,70,-80,85};
		Heap heap = new Heap(arr);
		heap.heapSort();
		
		int left = 0, right = arr.length-1;
		int minSum = arr[arr.length-1];
		int ele1 = 0, ele2 = 0;
		while(left < right)
		{
			int sum = arr[left]+arr[right];
			
			if(Math.abs(sum) < minSum)
			{
				ele1 = arr[left];
				ele2 = arr[right];
				minSum = sum;
			}
			
			if(sum > 0)
				right--;
			else
				left++;
		}
		System.out.println(ele1+" "+ele2+" with min sum "+minSum);
	}
}

/*
 * Time Complexity = O(nlogn)
 * Space Complexity = O(1)
 * */

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