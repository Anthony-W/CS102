/**
 * This class implements the reverse method using
 * a tree map
 *
 * @author Anthony Wessel
 * @date   2/12/2018
 */

package reversal;

import java.util.TreeMap;

public class TreeMapReversal implements ReverseString
{

	@Override
	public String reverse(String str)
	{
		//initialize and populate treeMap
		TreeMap<Integer, Character> map = new TreeMap<Integer, Character>();

		for (int i = 0; i < str.length(); i++)
		{
			map.put(str.length() - 1 - i, str.charAt(i));
		}

		//create result, iterate and fill result
		String result = "";
		for (int i = 0; i < map.size(); i++) {
			result += map.get(i);
		}
		
		return result;
	}

}
