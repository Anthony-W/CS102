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

	/*
	 * reverses a string
	 * 
	 * @param s string to be reversed
	 * 
	 * @return the reversed string
	 */
	@Override
	public String reverse(String s)
	{
		// end condition
		if (s.length() == 0)
			return s;

		// get the last character
		char last = s.charAt(s.length() - 1);

		// get a new string without the last character
		s = s.substring(0, s.length() - 1);

		return last + reverse(s);
	}
}
