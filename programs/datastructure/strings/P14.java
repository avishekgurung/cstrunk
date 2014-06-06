class P14
{
	public static void main(String[] args) 
	{
		String str = "1011010111";
		int l = str.length();
		
		if(l%2 == 1)
		{
			String temp = "0";
			str = temp + str;
		}

		char[] binary = str.toCharArray();
		
		String base4 = "";
		
		for(int i=0;i<l;i+=2)
		{
			if(binary[i] == '0' && binary[i+1] == '0')
				base4 = base4+"0";
			if(binary[i] == '0' && binary[i+1] == '1')
				base4 = base4+"1";
			if(binary[i] == '1' && binary[i+1] == '0')
				base4 = base4+"2";
			if(binary[i] == '1' && binary[i+1] == '1')
				base4 = base4+"3";
		}
		
		System.out.println("Binary: "+str);
		System.out.println("Base4: "+base4);
	}
}

/*
 * Please go through http://www.math-magic.com/base_manipulations/base_3_9.htm
 * to get a proper grip on base system and also inter base conversion.
 * 
 * Base 4	Base 2
 * 0		00
 * 1		01
 * 2		10
 * 3		11
 */