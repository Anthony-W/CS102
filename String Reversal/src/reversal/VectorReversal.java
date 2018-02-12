/**
 * This class implements the reverse method using
 * a vector and iterator
 *
 * @author Anthony Wessel
 * @date   2/12/2018
 */

package reversal;

import java.util.Iterator;
import java.util.Vector;

public class VectorReversal implements ReverseString
{

	public String reverse(String str)
	{

		//initialize and populate vector
		Vector<Character> v = new Vector<Character>();

		for (int i = str.length() - 1; i >= 0; i--)
		{
			v.add(str.charAt(i));
		}

		//create result and iterator
		String result = "";
		Iterator<Character> it = v.iterator();
		
		//iterate and populate result string
		while (it.hasNext())
		{
			result += it.next();
		}

		return result;
	}

}
