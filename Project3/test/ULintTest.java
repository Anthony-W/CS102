import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ULintTest
{

	Random rng = new Random();
	int first, second;
	ULint num, num2;
	
	@Test
	public void testEquality()
	{
		for (int i = 0; i < 100; i++)
		{
			first = rng.nextInt(Integer.MAX_VALUE);
			second = first;
			
			num = new ULint(first);
			num2 = new ULint(second);
			
			assertTrue(num.equals(num2));
		}
		
		for (int i = 0; i < 100; i++)
		{
			first = rng.nextInt(Integer.MAX_VALUE);
			second = rng.nextInt(Integer.MAX_VALUE);
			
			num = new ULint(first);
			num2 = new ULint(second);
			
			assertFalse(num.equals(num2));
			
		}
	}
	
	@Test
	public void testComparison()
	{
		for (int i = 0; i < 100; i++)
		{
			first = rng.nextInt(Integer.MAX_VALUE);
			second = rng.nextInt(first);
			
			num = new ULint(first);
			num2 = new ULint(second);
			
			assertEquals(num.compareTo(num2), 1);
			
		}
		
		for (int i = 0; i < 100; i++)
		{
			first = rng.nextInt(Integer.MAX_VALUE);
			second = rng.nextInt(first);
			
			num = new ULint(second);
			num2 = new ULint(first);
			
			assertEquals(num.compareTo(num2), -1);
			
		}
	}
	
	@Test
	public void testIntValue()
	{
		for (int i = 0; i < 100; i++)
		{
			first = rng.nextInt(Integer.MAX_VALUE);
			
			num = new ULint(first);
			
			assertEquals(num.intValue(), first);
		}
	}
}
