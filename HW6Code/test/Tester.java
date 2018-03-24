import static org.junit.Assert.*;

import org.junit.Test;

public class Tester
{

	@Test
	public void testToBinary()
	{
		assertEquals(Main.toBinary(0), "0");
		assertEquals(Main.toBinary(1), "1");
		assertEquals(Main.toBinary(2), "10");
		assertEquals(Main.toBinary(4), "100");
		assertEquals(Main.toBinary(7), "111");
		assertEquals(Main.toBinary(10), "1010");
		assertEquals(Main.toBinary(20), "10100");
	}
	
	@Test
	public void testIsBalanced()
	{
		assertTrue(Main.isBalanced(""));
		assertTrue(Main.isBalanced("()"));
		assertTrue(Main.isBalanced("()()"));
		assertTrue(Main.isBalanced("(())"));
		assertTrue(Main.isBalanced("((())((())))()]"));
		assertFalse(Main.isBalanced(")("));
		assertFalse(Main.isBalanced("(()"));
		
	}

}
