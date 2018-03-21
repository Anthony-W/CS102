import java.util.Stack;

public class Main {

	public static void main(String[] args)
	{
		testIsBalanced();
	}
	
	private static void testToBinary()
	{
		System.out.println(toBinary(0));
		System.out.println(toBinary(1));
		System.out.println(toBinary(2));
		System.out.println(toBinary(4));
		System.out.println(toBinary(7));
		System.out.println(toBinary(10));
		System.out.println(toBinary(20));
	}
	
	private static void testIsBalanced()
	{
		System.out.println(isBalanced(""));
		System.out.println(isBalanced("()"));
		System.out.println(isBalanced("()()"));
		System.out.println(isBalanced("(())"));
		System.out.println(isBalanced(")("));
		System.out.println(isBalanced("(()"));
	}
	
	public static String toBinary(int input)
	{
		//create stack and string variable
		Stack<Integer> tracker = new Stack<Integer>();
		String result = "";
		
		//convert
		while(input > 0)
		{
			tracker.push(input % 2);
			input /= 2;
		}
		
		//case for empty stack
		if (tracker.isEmpty()) result = "0";
		
		//populate result in correct order
		while (!tracker.isEmpty())
		{
			result += tracker.pop();
		}
		
		return result;
	}
	
	public static boolean isBalanced(String str)
	{
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if (c == '(') s.push(c);
			else if (c == ')')
			{
				if (s.isEmpty()) return false;
				else s.pop();
			}
		}
		if (s.isEmpty()) return true;
		return false;
	}

}
