class P4{
	public static void main(String args[]){
		int arr[] = {3,4,7,1,2,9,8};

		if(arr.length < 4)
			return;

		sort(arr);
		
		int left = 0;
		int right = arr.length-1;

		while(left < right){
			int sum = arr[left] + arr[right];
			int x = left;
			int y = right-1;

			while(x < y){
				if(sum == arr[x]+arr[y]){
					System.out.println(arr[left]+" "+arr[right]+" "+arr[x]+" "+arr[y]);
					x++;
				}
				else if(sum > arr[x]+arr[y]){
					x++;
				}
				else{
					y--;
				}
			}
			right--;
		}
	}

	public static void sort(int arr[]){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1; j<arr.length;j++){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}

/*1. Sort the Array 
2. Take two pointers left (start of the array) and right (end of the array) 
3. Find the sum of the left and right value in the array 
4. Look up iteratively the sum within the subarray , if sum is found print it 
4.a if sum is greater value then increment left side ( i ) or else reduce the (j) value*/