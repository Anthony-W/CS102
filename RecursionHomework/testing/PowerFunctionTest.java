import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PowerFunctionTest
{
	Random rng;

	@Before
	public void setUp() throws Exception
	{
		rng = new Random();
	}

	@Test
	public void test()
	{
		int x, y;
		for (int i = 0; i < 25; i++)
		{
			x = rng.nextInt(10) - 5;
			y = rng.nextInt(8) + 1;
			
			int myPower = PowerFunction.power(x, y);
			int realPower = (int)(Math.pow(x, y));
			
			if (myPower != realPower)
				System.out.println("You got " + myPower + ". Should have gotten " + realPower);
			
			assertEquals(realPower, myPower);
		}
	}

}
