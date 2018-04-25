import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class BSTTester
{
	Random rng;
	BST tree;
	
	@Before
	public void setUp() throws Exception
	{
		rng = new Random();
		tree = new BST();
		int next;
		for (int i = 0; i < 10; i++)
		{
			next = rng.nextInt(10);
			System.out.println(next);
			tree.put(next, next);
		}
	}

	@Test
	public void test()
	{
		System.out.println("\n" + tree.maxImbalance());
		
		/*
		System.out.println();
		
		Iterable<Integer> pre = tree.inOrder();
		for (Integer i : pre)
		{
			System.out.println(i);
		}
		
		BST reversedTree = tree.reverse();
		
		System.out.println();
		
		pre = reversedTree.inOrder();
		for (Integer i : pre)
		{
			System.out.println(i);
		}
		*/
	}

}
