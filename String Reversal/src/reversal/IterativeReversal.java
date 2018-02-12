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
	public String reverse(String s)
	{
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length / 2; i++)
		{
			char temp = (arr[arr.length - (i + 1)]);
			arr[arr.length - (i + 1)] = arr[i];
			arr[i] = temp;
		}

		return new String(arr);
	}
}
