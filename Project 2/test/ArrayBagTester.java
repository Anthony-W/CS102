import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class ArrayBagTester
{

	ArrayBag<Integer> ab;

	@Test
	public void testIsEmpty()
	{		
		//initialize bag
		ab = new ArrayBag<Integer>(10);
				
		//should be empty originally
		assertTrue(ab.isEmpty());
		
		//add 1, should not be empty
		ab.add(1);
		assertFalse(ab.isEmpty());
		
		//remove the 1, should be empty again
		ab.remove(1);
		assertTrue(ab.isEmpty());
	}

	@Test
	public void testIsFull()
	{
		//initialize bag
		ab = new ArrayBag<Integer>(10);
				
		//should not be full originally
		assertFalse(ab.isFull());
		
		//populate array, make sure isFull() is false
		//until we have added the maximum amount of elements
		for (int i = 0; i < 9; i++)
		{
			ab.add(i);
			assertFalse(ab.isFull());
		}
		
		//add the last element, filling array
		ab.add(9);
		assertTrue(ab.isFull());
		
		//remove an element, so the array is not full
		ab.remove(1);
		assertFalse(ab.isFull());
	}

	@Test
	public void testSize()
	{
		//initialize bag
		ab = new ArrayBag<Integer>(10);
		
		//size should be zero originally
		assertEquals(ab.size(), 0);
		
		//fill the array, checking for the
		//correct size after each addition 
		for (int i = 0; i < ab.size(); i++)
		{
			ab.add(i);
			assertEquals(ab.size(), i + 1);
		}
		
		//empty the array, checking for the
		//correct size after each removal 
		for (int i = ab.size() - 1; i >= 0; i--)
		{
			ab.remove(i);
			assertEquals(ab.size(), i);
		}
	}

	@Test
	public void testAdd()
	{
		//initialize bag
		ab = new ArrayBag<Integer>(10);
		
		//fill the array
		for (int i = 0; i < ab.size(); i++)
		{
			//add the next element
			ab.add(i);
			
			//make sure that the added element is at the beginning
			assertEquals((int) ab.get(0), i);
			
			//make sure that the previous element
			//was pushed back properly
			if (ab.size() > 1)
			{
				assertEquals((int) ab.get(1), i - 1);
			}
		}
	}
	
	@Test
	public void testInsert()
	{
		//initialize bag
		ab = new ArrayBag<Integer>(10);
		boolean successful;
		
		//try to insert a 0 at a negative index
		try
		{
			ab.insert(-1, 0);
			fail();
			System.err.println("Trying to insert at invalid index did not fail.");
		}
		catch (NoSuchElementException e) {}
		
		//try to insert a 0 at an index greater
		//than the size of the bag
		try
		{
			ab.insert(10, 0);
			fail();
			System.err.println("Trying to insert at invalid index did not fail.");
		}
		catch (NoSuchElementException e) {}
		
		//insert a 1 at the beginning of the empty bag
		successful = ab.insert(0, 1);
		assertTrue(successful);
		assertEquals((int)ab.get(0), 1);
		
		//insert a 2 at the beginning of the bag
		successful = ab.insert(0, 2);
		assertTrue(successful);
		assertEquals((int)ab.get(0), 2);
		
		//insert a 3 at the second index
		successful = ab.insert(1, 3);
		assertTrue(successful);
		assertEquals((int)ab.get(1), 3);
		
		//fill the array
		while(!ab.isFull()) {
			ab.add(0);
		}
		
		//try to add a 6 to a full bag
		successful = ab.insert(2, 6);
		assertFalse(successful);
		
		//remove 1 element
		ab.remove(0);
		
		//insert a 5 at the last index in the bag
		successful = ab.insert(9, 5);
		assertTrue(successful);
		assertEquals((int)ab.get(9), 5);
		
	}

	@Test
	public void testRemove()
	{
		//initialize bag
		ab = new ArrayBag<Integer>(10);
		boolean successful;
		
		//fill the bag
		for (int i = 9; i >= 0; i--) {
			ab.add(i);
		}
		
		//remove the 3 and check that all
		//following items have moved up
		successful = ab.remove(3);
		assertTrue(successful);
		assertEquals((int)ab.get(3), 4);
		
		//remove the 0 and check that all
		//following items have moved up
		successful = ab.remove(0);
		assertTrue(successful);
		assertEquals((int)ab.get(0), 1);
		
		//try to remove a -1, which is
		//not in the array
		successful = ab.remove(-1);
		assertFalse(successful);
		
		//try to remove the 3 which 
		//has already been removed
		successful = ab.remove(3);
		assertFalse(successful);
		
		//try to remove a 10, which is not in the array
		successful = ab.remove(10);
		assertFalse(successful);
	}

	@Test
	public void testGet()
	{	
		//initialize bag
		ab = new ArrayBag<Integer>(10);
		
		//fill array
		for (int i = 0; i < 10; i++) {
			ab.add(i);
		}
		
		//try to get each element
		for (int i = 0; i < 10; i++) {
			assertEquals((int)ab.get(i), 9-i);
		}
		
		//try to get a -1 which is not in the bag
		try {
			ab.get(-1);
			System.out.println("-1 is not a valid index");
		} catch (NoSuchElementException e) {}
		
		//try to get a 10 which is not in the bag
		try {
			ab.get(10);
			System.out.println("10 is not a valid index");
		} catch (NoSuchElementException e) {}
	}

}
