import static org.junit.Assert.*;
import java.util.NoSuchElementException;
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
		for (int i = 0; i < ab.size() - 1; i++)
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
		assertEquals(ab.size(), 0);
		for (int i = 0; i < ab.size(); i++)
		{
			ab.add(i);
			assertEquals(ab.size(), i + 1);
		}
		for (int i = ab.size() - 1; i >= 0; i--)
		{
			ab.remove(i);
			assertEquals(ab.size(), i + 1);
		}
	}

	@Test
	public void testAdd()
	{
		ab = new ArrayBag<Integer>(10);
		for (int i = 0; i < ab.size(); i++)
		{
			ab.add(i);
			assertEquals((int) ab.get(0), i);
			if (ab.size() > 1)
			{
				assertEquals((int) ab.get(1), i - 1);
			}
		}
	}

	@Test
	public void testInsert()
	{
		ab = new ArrayBag<Integer>(10);
		boolean successful;
		
		try
		{
			ab.insert(-1, 0);
			System.out.println("Trying to insert at invalid index did not fail.");
		}
		catch (NoSuchElementException e) {}
		
		try
		{
			ab.insert(10, 0);
			System.out.println("Trying to insert at invalid index did not fail.");
		}
		catch (NoSuchElementException e) {}
		
		successful = ab.insert(0, 1);
		assertTrue(successful);
		assertEquals((int)ab.get(0), 1);
		
		//TODO: Check if this should be possible or not
		//successful = ab.insert(9, 5);
		//assertTrue(successful);
		//assertEquals((int)ab.get(0), 5);
		
		successful = ab.insert(0, 2);
		assertTrue(successful);
		assertEquals((int)ab.get(0), 2);
		
		successful = ab.insert(1, 3);
		assertTrue(successful);
		assertEquals((int)ab.get(1), 3);
		
		while(!ab.isFull()) {
			ab.add(0);
		}
		successful = ab.insert(2, 6);
		assertFalse(successful);
		
	}

	@Test
	public void testRemove()
	{
		ab = new ArrayBag<Integer>(10);
		boolean successful;
		
		for (int i = 0; i < 10; i++) {
			ab.add(i);
		}
		
		
		successful = ab.remove(3);
		assertTrue(successful);
		assertEquals((int)ab.get(3), 4); //TODO: should this be a four? or empty?
		
		successful = ab.remove(0);
		assertTrue(successful);
		assertEquals((int)ab.get(0), 1); //TODO: should this be a 1? or empty?
		
		successful = ab.remove(-1);
		assertFalse(successful);
		
		successful = ab.remove(3);
		assertFalse(successful);
		
		successful = ab.remove(10);
		assertFalse(successful);
	}

	@Test
	public void testGet()
	{
		ab = new ArrayBag<Integer>(10);
		
		for (int i = 0; i < 10; i++) {
			ab.add(i);
		}
		
		for (int i = 0; i < 10; i++) {
			assertEquals((int)ab.get(i), i);
		}
		
		try {
			ab.get(-1);
			System.out.println("-1 is not a valid index");
		} catch (NoSuchElementException e) {}
		
		try {
			ab.get(10);
			System.out.println("10 is not a valid index");
		} catch (NoSuchElementException e) {}
	}

}
