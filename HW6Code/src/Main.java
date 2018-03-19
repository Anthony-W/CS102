import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		System.out.println(toBinary(0));
		System.out.println(toBinary(1));
		System.out.println(toBinary(2));
		System.out.println(toBinary(4));
		System.out.println(toBinary(7));
		System.out.println(toBinary(10));
		System.out.println(toBinary(20));
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

}
