class P8
{
	public static void main(String[] args) 
	{
		int a[]=new int[8];
		a[0] = 1; a[1] = 1; a[2] = 10;
		
		int b[] = {1,2,4,6,7};
	
		int m = 3, n = 5;
		m = m-1;
		n = n-1;
		
		for(int i = a.length-1;i>=0;i--)
		{
			if(n < 0)
				break;
			if(a[m] > b[n])
			{
				a[i] = a[m];
				m--;
			}
			else
			{
				a[i] = b[n];
				n--;
			}
		}
		
		
		
		System.out.println();
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}