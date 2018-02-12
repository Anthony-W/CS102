package reversal;

import java.util.Iterator;
import java.util.Vector;

public class VectorReversal implements ReverseString
{

	public String reverse(String str)
	{

		Vector<Character> v = new Vector<Character>();

		for (int i = str.length() - 1; i >= 0; i--)
		{
			v.add(str.charAt(i));
		}

		String result = "";
		Iterator<Character> it = v.iterator();
		while (it.hasNext())
		{
			result += it.next();
		}

		return result;
	}

}
