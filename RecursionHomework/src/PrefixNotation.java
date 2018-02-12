import java.util.Scanner;

public class PrefixNotation
{
	/*
	 * public interface for prefixCalculation
	 * 
	 * @param equation a String representation of the equation to be calculated
	 */
	public static int prefixCalculation(String equation)
	{
		Scanner input = new Scanner(equation);
		return prefixCalculation(input);
	}

	private static int prefixCalculation(Scanner input)
	{

		char nextOp;

		if (input.hasNextInt())
			return Integer.parseInt(input.next());

		nextOp = input.next().charAt(0);
		int operand1 = prefixCalculation(input);
		int operand2 = prefixCalculation(input);

		switch (nextOp)
		{
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		case '%':
			return operand1 % operand2;

		}

		return -1;
	}
}
