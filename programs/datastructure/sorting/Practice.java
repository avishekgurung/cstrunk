class Practice
{
	public static void main(String[] args) 
	{
		/*int arr[] = {3,2,6,8,4,1,6,3,9,7,5};
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"   ");
		System.out.println();*/
		
		int a[] = new int [10];
		a[0] = 2; a[1] = 4; a[2] = 5; a[3] = 8;
		int b[] = {1,3,4,6,7,9};
		
		int i = a.length-1;
		int ai = 3;
		int bi = 5;
		
		while(i>=0 && bi > 0 && ai > 0)
		{
			if(a[ai] > b[bi])
			{
				a[i] = a[ai];
				ai--;
			}
			else
			{
				a[i] = b[bi];
				bi--;
			}
			i--;
		}
		
		while(ai >=0)
		{
			a[i] = a[ai];
			ai--;
			i--;
		}
		
		while(bi >=0)
		{
			a[i] = b[bi];
			bi--;
			i--;
		}
		
		System.out.println();
		for(i=0;i<a.length;i++)
			System.out.print(a[i]+"   ");
		System.out.println();
		
	}
	
	public static void bucketSort(int arr[], int maxVal)
	{
		int bucket[] = new int[maxVal+1];
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
	
	public static void mergeSort(int arr[], int temp[], int left, int right)
	{
		if(left >= right)
			return;
		int mid = (left+right)/2;
		mergeSort(arr, temp, left, mid);
		mergeSort(arr, temp, mid+1, right);
		merge(arr, temp, left, mid+1, right);
	}
	
	public static void merge(int arr[], int temp[], int left, int mid, int right)
	{
		int leftend  = mid-1;
		int temp_pos = left;
		int size = right - left + 1;
		
		while(left <= leftend && mid <= right)
		{
			if(arr[left] < arr[mid])
			{
				temp[temp_pos] = arr[left];
				temp_pos++;
				left++;
			}
			else
			{
				temp[temp_pos] = arr[mid];
				temp_pos++;
				mid++;
			}
		}
		
		while(left <= leftend)
		{
			temp[temp_pos] = arr[left];
			temp_pos++;
			left++;
		}
		
		while(mid <= right)
		{
			temp[temp_pos] = arr[mid];
			temp_pos++;
			mid++;
		}
		
		for(int i=0;i<size;i++)
		{
			arr[right] = temp[right];
			right--;
		}
	}
	
	public static void insertionSort(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			int key = arr[i];
			int j = i;
			
			while(j > 0 && key < arr[j-1])
			{
				arr[j] = arr[j-1];
				j = j - 1;
			}
			
			arr[j] = key;
		}
	}
	
	public static void selectionSort(int arr[])
	{
		for(int i=0;i<arr.length-1;i++)
		{
			int min = i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j] < arr[min])
				{
					min = j ;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	
	public static void bubbleSort(int arr[])
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++ )
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
}

class Heap
{
	int count;
	int arr[];
	
	Heap(int arr[])
	{
		this.arr = arr;
		count = 0;
		for(int i=0;i<arr.length;i++)
			insert(arr[i]);
	}
	
	public void insert(int data)
	{
		int i = count;
		
		while(i >0 && data > arr[(i-1)/2])
		{
			arr[i] = arr[(i-1)/2];
			i = (i-1)/2;
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
		int right = 2 * i  + 2;
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
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
		}
		
		if(max == i)
			return;
		
		percolateDown(max);
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
	}
}





















