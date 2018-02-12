import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrefixNotationTest
{

	String[] equations;
	int[] answers;

	@Before
	public void setUp()
	{
		equations = new String[16];
		answers = new int[16];

		//set up list of equations
		equations[0] = "+ 1 4";
		equations[1] = "- 2 3";
		equations[2] = "* 3 2";
		equations[3] = "/ 4 1";
		equations[4] = "% 1 2";
		equations[5] = "+ + 1 2 3";
		equations[6] = "* - 2 3 4";
		equations[7] = "- * 3 1 5";
		equations[8] = "% / 6 2 4";
		equations[9] = "+ % 1 2 3";
		equations[10] = "+  1 * 2 3";
		equations[11] = "*  1 / 9 3";
		equations[12] = "*  1 - 2 / 6 3";
		equations[13] = "-  1 + 2 - 3 2";
		equations[14] = "/  1 + 2 / 3 - 1 2";
		equations[15] = "- * / 15 - 7 + 1 1 3 + 2 + 1 1 ";

		//answers for each equation
		answers[0] = 5;
		answers[1] = -1;
		answers[2] = 6;
		answers[3] = 4;
		answers[4] = 1;
		answers[5] = 6;
		answers[6] = -4;
		answers[7] = -2;
		answers[8] = 3;
		answers[9] = 4;
		answers[10] = 7;
		answers[11] = 3;
		answers[12] = 0;
		answers[13] = -2;
		answers[14] = -1;
		answers[15] = 5;
	}

	@Test
	public void test()
	{
		for (int i = 0; i < equations.length; i++)
		{
			int answer = PrefixNotation.prefixCalculation(equations[i]);
			if (answer != answers[i])
			{
				System.out.println("Calculation " + i + " failed");
			}
			assertEquals(answer, answers[i]);
		}
	}

}
