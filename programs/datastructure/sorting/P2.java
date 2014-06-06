import java.util.HashMap;
import java.util.Map;


class P2
{
	public static void main(String[] args) 
	{
		int arr[]={5,2,1,4,3,2,3,50,6,2,7,9,3,4,1,2}; //Cant use bucket sort as we are not given any input range
		
		//With extra space, lets try by Hash
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0;i < arr.length; i++)
		{
			if(map.containsKey(arr[i]))
			{
				int value = map.get(arr[i]);
				value++;
				map.put(arr[i], value);
			}
			else
			{
				map.put(arr[i], 1);
			}
		}
		int value = 0, element = 0, maxValue = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(value < map.get(arr[i]))
			{
				element = arr[i];
				maxValue = map.get(arr[i]);
			}
			value = map.get(arr[i]);
		}
		
		System.out.println("Element "+element+" appears "+maxValue+" times"); //Time = O(n) Space = O(n)
		
		//Lets use heapSort as we want to preserve Space
		
		Heap heap = new Heap(arr);
		heap.heapSort();
		
		element = 0; int count = 1; maxValue = 0;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i] == arr[i+1])
			{
				count++;
			}
			else
			{
				if(count > maxValue)
				{
					element = arr[i];
					maxValue = count;
				}
				count = 1;
			}
		}
		System.out.println("Element "+element+" appears "+maxValue+" times"); //Time = O(nlogn) Space = O(1)
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
		while(i > 0 && data > arr[(i-1)/2])
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
		int right = 2 * i + 2;
		if(right >= count)
			return -1;
		else
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




















