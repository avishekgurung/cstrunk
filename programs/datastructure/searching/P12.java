class P12
{
	public static void main(String[] args) 
	{
		int arr[] = {1,3,3,3,3,4,5,6};
		//int arr[] = {3,3,3,3,3,3,4,5,6,6,7};
		int element = 3;
		
		System.out.println("First Index of "+element+" is "+getFirstOccurrence(arr, element));
		System.out.println("Last Index of "+element+" is "+getLastOccurrence(arr, element));
	}
	
	public static int getFirstOccurrence(int arr[], int element)
	{
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right)
		{
			int mid = (left + right)/2;
			if(mid == left && arr[mid] == element || arr[mid] == element && arr[mid-1] < element)
				return mid;
			else if(element > arr[mid])
				left = mid + 1;
			else
				right = mid -1;
		}
		return -1;
	}
	
	public static int getLastOccurrence(int arr[], int element)
	{
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right)
		{
			int mid = (left + right)/2;
			if(mid == right && arr[mid] == element || arr[mid] == element && arr[mid+1] > element)
				return mid;
			else if(element >= arr[mid])
				left = mid + 1;
			else
				right = mid -1;
		}
		return -1;
	}

	public static int firstOccurence(int arr[], int element){
		int left = 0;
		int right = arr.length - 1;

		while(left <= right){
			int mid = (left+right)/2;
			if(element > arr[mid]){
				left = mid + 1;
			}
			else if(element < arr[mid]){
				right = mid -1;
			}
			else{
				if((mid - 1) < left || arr[mid-1] != element){
					return mid;
				}
				right = mid - 1;
			}
		}
		return -1;
	}	

	public static int lastOccurence(int arr[], int element){
		int left = 0;
		int right = arr.length-1;

		while(left <= right){
			int mid = (left+right)/2;
			if(element > arr[mid]){
				left = mid + 1;
			}
			else if(element < arr[mid]){
				right = mid -1;
			}
			else{
				if((mid + 1) > right || arr[mid+1] != element){
					return mid;
				}
				left = mid + 1;
			}
		}
		return -1;
	}

	//simpler
	public static void occurrence(int arr[],int element){
		int left = 0;
		int right = arr.length-1;
		int firstIndex = 0;
		int lastIndex = 0;

		while(left < right){
			int mid = (left + right)/2;
			if(element > arr[mid])
				left = mid;
			else if(element < arr[mid])
				right = mid;
			else{
				if(arr[mid-1] != element){
					firstIndex = mid;
					break;
				}
				else{
					right = mid;
				}
			}
		}

		left = 0;
		right = arr.length-1;

		while(left < right){
			int mid = (left + right)/2;
			if(element > arr[mid])
				left = mid;
			else if(element < arr[mid])
				right = mid;
			else{
				if(arr[mid+1] != element){
					lastIndex = mid;
					break;
				}
				else{
					left = mid;
				}
			}
		}

		System.out.println("First Index "+firstIndex);
		System.out.println("Last Index "+lastIndex);
	}
}











