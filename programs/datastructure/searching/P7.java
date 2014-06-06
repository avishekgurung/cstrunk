import java.util.HashMap;
import java.util.Map;

class P7
{
	public static void main(String[] args) 
	{
		int arr[] = {5,8,7,9,4,3,6,10,13,12,11,14,15,17};
		Heap heap = new Heap(arr);
		heap.heapSort();
		
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++)
			arr[i] = arr[i] * arr[i];
		
		for(int i=0;i<arr.length;i++)
			map.put(arr[i], arr[i]);
		
		for(int i=arr.length-1;i>0;i--)
		{
			int x = map.get(arr[i]);
			
			int y = map.get(arr[i-1]);
			
			int z = x - y;
			Integer k = z;
			if(map.containsKey(k))
				System.out.println(Math.sqrt(x)+"\t"+Math.sqrt(y)+"\t"+Math.sqrt(z));
			
		}
			
	}
	
}

/*
 * Time Complexity
 * HeapSort + Squaring + Putting elements in Map + Final Operation
 *  nlogn		n			n						n				= O(nlogn)
 *  
 *  Space complexity = O(n) for Hash
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