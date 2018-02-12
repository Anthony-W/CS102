/**
 * Write a succinct, meaningful description of the class here.
 * You should avoid wordiness and redundancy. If necessary,
 * additional paragraphs should be preceded by <p>,
 * the html tag for a new paragraph.
 *
 * <p>Bugs: (a list of bugs and / or other problems)
 *
 * @author <your name>
 * @date   <date of completion>
 */

package reversal;

public class IterativeReversal implements ReverseString
{
	public String reverse(String s)
	{
		char[] ary = s.toCharArray();

		for (int i = 0; i < ary.length / 2; i++)
		{
			char temp = (ary[ary.length - (i + 1)]);
			ary[ary.length - (i + 1)] = ary[i];
			ary[i] = temp;
		}

		return new String(ary);
	}
}
