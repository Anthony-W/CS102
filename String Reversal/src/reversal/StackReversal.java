/**
 * This class implements the reverse method using
 * a stack
 *
 * @author Anthony Wessel
 * @date   2/12/2018
 */

package reversal;

import java.util.Stack;

public class StackReversal implements ReverseString{

	public String reverse(String str) {
		
		//initialize and populate stack
		Stack<Character> s = new Stack<Character>();
		
		for (int i = 0; i < str.length(); i++)
		{
			s.push(str.charAt(i));
		}
		
		
		String result = "";
		int size = s.size();
		
		for (int i = 0; i < size; i++)
		{
			result += s.pop();
		}
		
		return result;
	}

}
