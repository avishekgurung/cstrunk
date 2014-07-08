class P14{
	public static void main(String args[]){
		int arr[] = {2,3,2,3,2};
		System.out.println(findMajority(arr));
	}

	public static int findMajority(int arr[]){
		int count = 0;
		int element = -1;
		for(int i=0;i<arr.length;i++){
			if(count == 0){
				element = arr[i];
				count = 1;	
			}
			else if(element == arr[i]){
				count++;
			}
			else{
				count--;
			}
		}
		return element;
	}
}
