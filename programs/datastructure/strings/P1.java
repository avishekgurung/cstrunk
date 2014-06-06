import java.util.HashMap;
import java.util.Map;

class P1
{
	public static void main(String[] args) 
	{
		String paragraph = "I have a good car a good life my friends are good to me my mom gives me a good amount of money my games are good my homework is always good and what ever. mom mom mom";
		
		utility(paragraph);
		scrollup();
	}
	
	public static void utility(String paragraph)
	{
		String arr[] = paragraph.split(" ");
		Map<String, Integer> map = new HashMap<String,Integer>();
		String word = "";
		int max = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				int val = map.get(arr[i]);
				if(val > max)
				{
					max = val;
					word = arr[i];
				}
				val++;
				map.put(arr[i], val);
			}
			else
			{
				map.put(arr[i], 1);
			}
		}
		System.out.println(word+" appears "+max+" no of times");
	}
	
	public static void scrollup() //on scroll up say, a visible paragraph is show below
	{
		String visibleParagraph = "to me my mom gives me a good amount of money my games are good my homework is always good and what ever. mom mom mom";
		utility(visibleParagraph);
	}
}

