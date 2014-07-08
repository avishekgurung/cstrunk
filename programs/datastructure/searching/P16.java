class P16
{
	public static void main(String[] args) 
	{
		int arr[][] = {{1,3,4,5,6},{10,13,14,15,16},{25,26,27,28,29},{43,44,48,49,50},{63,65,66,68,72}};
		int n = arr.length; //rememeber array is of size nxn
		display2d(arr);
		int element = 28;

		int i = arr.length-1;
		int j = arr.length-1;

		while(arr[i][j] > element){
			i--;
			j--;
		}

		boolean found = false;
		int a = 0, b = 0;

		while(j < arr.length){
			if(arr[i][j] == element){
				found = true;
				a = i;
				b = j;
				break;
			}
			j++;
		}

		if(!found){
			i = i + 1;
			j = 0;

			while(j < arr.length){
				if(arr[i][j] == element){
					found = true;
					a = i;
					b = j;
				}
				j++;
			}
		}

		if(found){
			System.out.println("Element found at "+a+","+b+" position");
		}
		else{
			System.out.println("element not found");
		}
	}
}

/*
Search diagonally and get an element which is just smaller than the element to be searched.
Once u get that, just iterate along x axis and find the desired element.
*/