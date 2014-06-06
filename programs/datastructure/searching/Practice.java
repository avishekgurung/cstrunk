import java.util.HashMap;
import java.util.Map;

class Practice
{
	public static void main(String[] args) 
	{
		int arr[] = {2,1,0,2,1,2,0,1};
		Map<Integer, Integer> map =  new HashMap<Integer,Integer>();
		//Heap heap = new Heap(arr);
		//heap.heapSort();
		/*int left = 0;
		int right = arr.length-1;
		int mid = (left+right)/2;
		
		while(mid <= right)
		{
			int x = arr[mid];
			
			switch (x) 
			{
			case 0:
				swap(arr, left, mid);
				left++;
				break;

			case 1:
				mid++;
				break;
			
			case 2:
				swap(arr, mid, right);
				right--;
				break;
			}
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"   ");*/
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
		
		int left = 0;
		int right = arr.length-1;
		int mid = left;
		
		while(mid <= right)
		{
			
			switch (arr[mid]) 
			{
			case 0:
				swap(arr, left, mid);
				left++;
				break;
				
			case 1:
				mid++;
				break;

			case 2:
				swap(arr, mid, right);
				right--;
				break;
			}
		}
		
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
		
	}
	
	public static void swap(int arr[],int x, int y)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	public static int lastOccurrence(int arr[], int element)
	{
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right)
		{
			int mid = (left + right)/2;
			if(right == mid && arr[mid] == element || arr[mid] == element && arr[mid+1] > element)
				return mid;
			if(element < arr[mid])
				right = mid-1;
			else
				left = mid + 1;
		}
		return -1;
	}
	
	public static int firstOccurrence(int arr[], int element)
	{
		int left = 0;
		int right = arr.length-1;
		while(left <= right)
		{
			int mid = (left + right)/2;
			if(mid == left && arr[mid] == element || arr[mid] == element && arr[mid-1] < element)
				return mid;
			if(element > arr[mid])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
	
	public static int search(int arr[], int pivot, int element)
	{
		int left = 0, right = arr.length-1;
		
		if(element >= arr[left] && element <= arr[pivot])
			right = pivot;
		else
			left = pivot+1;
		
		//System.out.println(left+" x "+right);
		while(left <= right)
		{
			int mid = (left+right)/2;
			if(arr[mid] == element)
				return mid;
			if(element > arr[mid])
				left = mid+1;
			else
				right = mid-1;
		}
		return -1;
	}
	
	public static int getPivot(int arr[])
	{
		int left = 0;
		int right = arr.length-1;
		//int mid = (left+right-1)/2
		if(arr[left] < arr[right])
			return right;
		while(left <= right)
		{
			int mid = (left+right)/2;
			if(arr[mid]>arr[mid+1])
				return mid;
			if(arr[left] < arr[mid])
				left = mid;
			else
				right = mid;
		}
		return -1;
		
	}
	
	public static void bucketSort(int arr[], int maxVal)
	{
		int []bucket = new int[maxVal+1];
		
		for(int i=0;i<bucket.length;i++)
			bucket[i] = 0;
		
		for(int i=0;i<arr.length;i++)
			bucket[arr[i]] = bucket[arr[i]] + 1;
		
		int x = 0;
		for(int i=0;i<bucket.length;i++)
		{
			for(int j=0;j<bucket[i];j++)
			{
				arr[x] = i;
				x++;
			}
		}
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