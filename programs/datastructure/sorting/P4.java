class P4
{
	public static void main(String[] args) 
	{
		int a[] = {2,5,3,8,9,2};
		int b[] = {4,9,6,2,3,1};
		int k = 3;
		boolean result = false;
		
		Heap heap = new Heap(a);
		heap.heapSort(); //O(nlogn)
		
		for(int i=0;i<b.length;i++)
		{
			int remainder = k - b[i];
			if(remainder >= 0)
			{
				result = binarySearch(a, remainder);
				if(result)
				{
					result = true;
					break;
				}
			}
		}
		
		if(result)
			System.out.println("The sum exits");
		else
			System.out.println("The sum does NOT exits");
	}

	//simpler method
	public static void utility(int a[], int b[], int k){
		int left = 0;
		int right = b.length-1;

		while(left < a.length && right >= 0){
			int sum = a[left] + b[right];
			if(sum == k){
				System.out.println(a[left]+"\t"+b[right]);
				left++;
			}
			else if(sum > k){
				right--;
			}
			else{
				left++;
			}
		}
	}
	
	public static boolean binarySearch(int arr[], int element)
	{
		int left = 0, right = arr.length-1;
		
		
		while(left <= right)
		{
			int mid = (left + right) / 2;
			if(arr[mid] == element)
			{
				return true;
			}
			else if(element > arr[mid])
			{
				left = mid + 1;
			}
			else
			{
				right = mid - 1;
			}
		}
		return false;
	}
}

/*
 * First we sort one of the array using heapsort. Time = O(nlogn) Space = O(1)
 * Then we scan second element and do binary search in first. Scanning (time) = n, BInary Search(time) = logn, Space = O(1) in both
 * Total Time = nlogn + n*logn = O(nlogn)
 * Total Space = O(1)
 */

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


