class Heap{
	int arr[];
	int capacity;
	int count;

	Heap(){
		count = 0;
		capacity = 28;
		arr = new int[capacity];
	}

	public void insert(int data){
		int i = count;
		while(i > 0 && data > arr[(i-1)/2]){
			arr[i] = arr[(i-1)/2];
			i = (i-1)/2;
		}
		arr[i] = data;
		count++;
	}

	public void display(){
		for(int i=0;i<count;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public int getLeft(int i){
		int left = 2 * i + 1;
		if(left >= count)
			return -1;
		else return left;
	}

	public int getRight(int i){
		int right = 2 * i + 2;
		if(right >= count)
			return -1;
		else return right;
	}


	public void percolateDown(int i){
		int left = getLeft(i);
		int right = getRight(i);
		if(left == -1 && right == -1)
			return;
		int max = 0;
		if(left != -1 && arr[left] > arr[i])
			max = left;
		else max = i;

		if(right != -1 && arr[right] > arr[max])
			max = right;

		if(max != i){
			int temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
		}

		if(max == i)
			return;
		percolateDown(max);
	}

	public void heapSort(){
		int x = count;
		for(int i=0;i<x;i++){
			int temp = arr[0];
			arr[0] = arr[count-1];
			percolateDown(0);
			arr[count-1] = temp;
			count--;
		}
		count = x;
	}

	public int delete(){
		int temp = arr[0];
		arr[0] = arr[count-1];
		count--;
		percolateDown(0);
		return temp;
	}

	public boolean isEmpty(){
		if(count == 0)
			return true;
		else
			return false;
	}
}

class P7{
	public static void main(String args[]){
		utility();
	}	

	public static void utility(){
		
		int arr[] = {5,8,7,9,4,3,6,10,13,12,11,14,15,17};
		display(arr);
		Heap heap = new Heap();
		for(int i=0;i<arr.length;i++)
			heap.insert(arr[i]);
		heap.heapSort();
		display(arr);

		for(int i=0;i<arr.length;i++)
			arr[i] = arr[i] * arr[i];

		display(arr);

		for(int i=arr.length-1;i>0;i--){
			int left = 0;
			int right = i-1;
			while(left < right){
				int sum = arr[left] + arr[right];
				if(sum == arr[i]){
					System.out.println(Math.sqrt(arr[i])+" "+Math.sqrt(arr[left])+" "+Math.sqrt(arr[right]));
					left++;
				}
				else if(sum > arr[i]){
					right--;
				}
				else{
					left++;
				}
			}
		}

	}

	public static void display(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}

}
