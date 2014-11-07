import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class P3{
	public static void main(String args[]) throws IOException{
		int m = 0;
		int n = 0;

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(bf.readLine());
		n = Integer.parseInt(bf.readLine());

		for(int i=m;i<=n;i++){
			if(steppingNumber(i)){
				System.out.println(i);
			}
		}
	}

	public static boolean steppingNumber(int num){
		String str = num+"";
		char arr[] = str.toCharArray();

		for(int i=arr.length-1;i > 0;i--){
			int x = Character.getNumericValue(arr[i]);
			int y = Character.getNumericValue(arr[i-1]);
			if(Math.abs(x-y) != 1){
				return false;
			}
		}

		if(Math.abs(arr[arr.length-1] - arr[0]) != 1){
			return false;
		}
		return true;
	}
}
