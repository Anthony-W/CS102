package reversal;

import java.util.TreeMap;

public class TreeMapReversal implements ReverseString
{

	@Override
	public String reverse(String str)
	{
		TreeMap<Integer, Character> map = new TreeMap();

		for (int i = 0; i < str.length(); i++)
		{
			map.put(str.length() - 1 - i, str.charAt(i));
		}

		String result = "";
		for (int i = 0; i < map.size(); i++) {
			result += map.get(i);
		}
		
		return result;
	}

}
