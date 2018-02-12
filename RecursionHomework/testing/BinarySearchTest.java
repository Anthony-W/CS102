import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest
{
	@Test
	public void test()
	{
		Integer[] list = new Integer[15];
		
		//fill list
		for (int i = 0; i < list.length; i++)
		{
			list[i] = i;
		}
		
		//search for every item in list
		for (int i = 0; i < list.length; i++)
		{
			if (BinarySearch.<Integer>binarySearch(list, i) != i)
			{
				System.out.println("Wrong index for " + i);
			}
			assertTrue(list[i].equals(i));
		}
		
		//search for items outside of list
		Integer[] secondList = {0,2,5,7,8};
		assertEquals(BinarySearch.<Integer>binarySearch(secondList, -1), -1);
		assertEquals(BinarySearch.<Integer>binarySearch(secondList, 1), -1);
		assertEquals(BinarySearch.<Integer>binarySearch(secondList, 6), -1);
		assertEquals(BinarySearch.<Integer>binarySearch(secondList, 10), -1);
		assertEquals(BinarySearch.<Integer>binarySearch(secondList, 13), -1);
	}
}
