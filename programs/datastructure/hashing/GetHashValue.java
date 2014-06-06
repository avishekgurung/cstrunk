class GetHashValue
{
	public static void main(String args[])
	{
		System.out.println("Hash Value: "+args[0].hashCode());
		//int a = Integer.parseInt(args[0].hashCode());
		int b = Integer.parseInt(args[1]);
		System.out.println("Division : "+(args[0].hashCode() % b));
	}
}
