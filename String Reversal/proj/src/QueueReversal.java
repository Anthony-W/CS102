/**
 * This class implements the reverse method using
 * a queue/ArrayList
 *
 * @author Anthony Wessel
 * @date   2/12/2018
 */

package reversal;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReversal implements ReverseString
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
		// don't try to reverse an empty string
		if (s.length() == 0)
			return s;

		// create and initialize queue
		Queue<Character> queue = new LinkedList<Character>();

		// populate queue
		for (int i = s.length() - 1; i >= 0; i--)
		{
			queue.add(s.charAt(i));
		}

		// create and populate result
		String result = "";
		for (int i = 0; i < s.length(); i++)
		{
			result += queue.remove();
		}

		return result;
	}
}
