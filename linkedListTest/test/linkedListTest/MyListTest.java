package linkedListTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyListTest {

	@Test
	void test() {
		MyList<Integer> list = new MyList<Integer>();
		assertEquals(list.size(), 0);
		list.add(0);
		assertEquals(list.size(), 1);
		System.out.println(list.toString());
		list.add(1);
		assertEquals(list.size(), 2);
		System.out.println(list.toString());
		list.add(2);
		assertEquals(list.size(), 3);
		System.out.println(list.toString());
		
		list.pop();
		assertEquals(list.size(), 2);
		System.out.println(list.toString());
	}

}
