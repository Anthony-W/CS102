import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Tester
{

	@Test
	public void test()
	{
		MyCollection collection = new MyCollection();
		boolean testPassed;
		
		//tests where add should fail
		testPassed = collection.add(null);
		assertFalse(testPassed);
		if (testPassed) System.out.println("collection should not have added null");
		
		testPassed = collection.add(new Tainted());
		assertFalse(testPassed);
		if (testPassed) System.out.println("collection should not have added a Tainted object");
		
		testPassed = collection.add(collection);
		assertFalse(testPassed);
		if (testPassed) System.out.println("collection should not have added itself");
		
		//tests where add should succeed
		testPassed = collection.add("");
		assertTrue(testPassed);
		testPassed = collection.add("test");
		assertTrue(testPassed);
		testPassed = collection.add("add this");
		assertTrue(testPassed);
	}

}
