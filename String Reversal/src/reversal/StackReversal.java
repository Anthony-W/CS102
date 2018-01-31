package reversal;

import java.util.Stack;

public class StackReversal implements ReverseString{

	public String reverse(String str) {
		
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
