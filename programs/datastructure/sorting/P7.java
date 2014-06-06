class P7
{
	public static void main(String[] args) 
	{
		int a[] = {19,20};
		int b[] = {25,26,27,28};
		int c[] = {11,12,13,14,15,16};
		int d[] = {1,2,3,4,5};
		int e[] = {6,8,9,10,11,12};
		int K = 5;
		//here K = 5
		
		int temp[] = mergeSort(a, b, 0);
		temp = mergeSort(c, temp, 0);
		temp = mergeSort(d, temp, 0);
		temp = mergeSort(e, temp, 0);
		
		
		System.out.println();
		for(int i=0;i<temp.length;i++)
			System.out.print(temp[i]+" ");
		System.out.println();
		
	}
	
	public static int[] mergeSort(int a[], int b[], int temp_pos)
	{
		int i = 0;
		int j = 0;
		
		int temp[] = new int[a.length+b.length];
		
		while(i < a.length && j < b.length)
		{
			if(a[i] < b[j])
			{
				temp[temp_pos] = a[i];
				temp_pos++;
				i++;
			}
			else
			{
				temp[temp_pos] = b[j];
				temp_pos++;
				j++;
			}
		}
		
		while(i < a.length)
		{
			temp[temp_pos] = a[i];
			temp_pos++;
			i++;
		}
		
		while(j < b.length)
		{
			temp[temp_pos] = b[j];
			temp_pos++;
			j++;
		}
		return temp;
	}
}

/**
 * Dont think that it is appropiate solution, things are hard coded yet solution is reached
 */