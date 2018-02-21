import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayBagTester
{

	ArrayBag<Integer> ab;

	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void testIsEmpty()
	{
		ab = new ArrayBag<Integer>(10);
		assertTrue(ab.isEmpty());
		ab.add(1);
		assertFalse(ab.isEmpty());
		ab.remove(1);
		assertTrue(ab.isEmpty());
	}

	@Test
	public void testIsFull()
	{
		ab = new ArrayBag<Integer>(10);
		assertFalse(ab.isFull());
		for (int i = 0; i < ab.size()-1; i++)
		{
			ab.add(i);
			assertFalse(ab.isFull());
		}
		ab.add(9);
		assertTrue(ab.isFull());
		ab.remove(1);
		assertFalse(ab.isFull());
	}

	@Test
	public void testSize()
	{
		ab = new ArrayBag<Integer>(10);
		assertEquals(ab.size(),0);
		for (int i = 0; i < ab.size(); i++) {
			ab.add(i);
			assertEquals(ab.size(),i+1);
		}
		for (int i = ab.size()-1; i >= 0; i--) {
			ab.remove(i);
			assertEquals(ab.size(),i+1);
		}
	}

	@Test
	public void testAdd()
	{
		ab = new ArrayBag<Integer>(10);
		for (int i = 0; i < ab.size(); i++) {
			ab.add(i);
			assertEquals((int)ab.get(0), i);
			if (ab.size()>1) {
				assertEquals((int)ab.get(1), i-1);
			}
		}
	}

	@Test
	public void testInsert()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testRemove()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGet()
	{
		fail("Not yet implemented");
	}

}
