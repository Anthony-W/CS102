/**
 * This class implements the reverse method as
 * a recursive method
 *
 * @author Anthony Wessel
 * @date   2/12/2018
 */

package reversal;

public class RecursiveReversal implements ReverseString
{
	public String reverse(String s)
	{
		if (s.length() == 0)
			return s;

		char last = s.charAt(s.length() - 1);
		s = s.substring(0, s.length() - 1);

		return last + reverse(s);
	}
}
