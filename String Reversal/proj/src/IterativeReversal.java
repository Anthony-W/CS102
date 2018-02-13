/**
 * This class implements the reverse method using
 * a char array and an iterative loop
 *
 * @author Anthony Wessel
 * @date   2/12/2018
 */

package reversal;

public class IterativeReversal implements ReverseString
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
		// create and initialize array
		char[] arr = s.toCharArray();

		// iterate, swap front and back characters,
		// then second and second from last, etc
		for (int i = 0; i < arr.length / 2; i++)
		{
			char temp = (arr[arr.length - (i + 1)]);
			arr[arr.length - (i + 1)] = arr[i];
			arr[i] = temp;
		}

		return new String(arr);
	}
}
